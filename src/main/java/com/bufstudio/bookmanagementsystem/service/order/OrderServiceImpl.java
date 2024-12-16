package com.bufstudio.bookmanagementsystem.service.order;

import com.bufstudio.bookmanagementsystem.enumeration.OrderStatusEnum;
import com.bufstudio.bookmanagementsystem.mapper.OrderDtoMapper;
import com.bufstudio.bookmanagementsystem.model.dto.order.BookOrderDto;
import com.bufstudio.bookmanagementsystem.model.dto.order.GetOrderDto;
import com.bufstudio.bookmanagementsystem.model.entity.Book;
import com.bufstudio.bookmanagementsystem.model.entity.Order;
import com.bufstudio.bookmanagementsystem.model.entity.OrderedBook;
import com.bufstudio.bookmanagementsystem.model.entity.User;
import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderListResponse;
import com.bufstudio.bookmanagementsystem.repository.book.BookRepository;
import com.bufstudio.bookmanagementsystem.repository.order.OrderRepository;
import com.bufstudio.bookmanagementsystem.repository.ordered_book.OrderedBookRepository;
import com.bufstudio.bookmanagementsystem.repository.user.UserRepository;
import com.bufstudio.bookmanagementsystem.service.book.BookService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderedBookRepository orderedBookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Override
    public GetOrderDto getOrder(Long orderId) {
        // 查找订单
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));


        // 转换为响应DTO
        return OrderDtoMapper.mapOrderToGetOrderDto(order);
    }

    @Override
    public GetOrderListResponse getOrderList(Long userId, BigDecimal priceFilterLowerBound, BigDecimal priceFilterUpperbound, String status, Integer page, Integer size) {
        // 使用criteriaBuilder构建动态查询条件
        var orders = orderRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 按价格区间过滤
            if (priceFilterLowerBound != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("totalPrice"), priceFilterLowerBound));
            }
            if (priceFilterUpperbound != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalPrice"), priceFilterUpperbound));
            }

            // 按状态过滤
            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }

            // 未删除条件
            predicates.add(criteriaBuilder.equal(root.get("isDeleted"), false));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

        // 转换为响应DTO列表
        var orderResponseList = orders.stream()
                .map(OrderDtoMapper::mapOrderToGetOrderDto)
                .toList();

        // 构建返回结果对象
        GetOrderListResponse response = new GetOrderListResponse();
        response.setOrders(orderResponseList);
        response.setTotalCount(orderResponseList.size());
        response.setCurrentPage(page != null ? page : 0);
        response.setPageSize(size != null ? size : orderResponseList.size());

        return response;
    }

    @Override
    @Transactional
    public void addOrder(List<BookOrderDto> booksToOrder, Long userId) {
        BigDecimal total = new BigDecimal(0);
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        // Save the new order into the database first
        Order order = new Order();
        order.setTotalPrice(total);
        order.setStatus(OrderStatusEnum.ORDER_STATUS_PROCESSING);
        order.setCreatedAt(LocalDateTime.now());
        order.setUser(user);
        order = orderRepository.save(order);

        for (BookOrderDto bookToOrder : booksToOrder) {
            // Retrieve the book from database
            Book book = bookRepository.findByIdWithPessimisticLock(bookToOrder.getBookId()).orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookToOrder.getBookId()));

            // Check if the book quantity is not enough to make the order
            if (book.getStockQuantity() < bookToOrder.getQuantity()) {
                throw new IllegalStateException("Not enough stock for book: " + book.getTitle());
            }

            // Update the book quantity in the database
            book.setStockQuantity(book.getStockQuantity() - bookToOrder.getQuantity());
            bookService.updateBook(book.getId(), book);

            // Add ordered book
            OrderedBook orderedBook = new OrderedBook();
            orderedBook.setBook(book);
            orderedBook.setQuantity(bookToOrder.getQuantity());
            orderedBook.setOrder(order);
            orderedBook.setCreatedAt(LocalDateTime.now());
            orderedBookRepository.save(orderedBook);

            // Add up the total price to the order
            total = total.add(book.getPrice().multiply(new BigDecimal(bookToOrder.getQuantity())));
        }

        // Update the total price for the order and status to COMPLETED
        order.setTotalPrice(total);
        order.setStatus(OrderStatusEnum.ORDER_STATUS_DELIVERING);
        orderRepository.save(order);
    }


    @Override
    @Transactional
    public GetOrderDto updateOrder(Long orderId, Order updatedOrder) {
        // 查找现有的订单，如果不存在则抛出异常
        Order existingOrder = orderRepository.findByIdWithPessimisticLock(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));


        if (updatedOrder.getTotalPrice() == null) {
            throw new IllegalStateException("Total price cannot be null");
        }

        if (existingOrder.getIsDeleted()) {
            throw new IllegalStateException("Cannot update a deleted order");
        }

        // 更新订单字段
        if (updatedOrder.getTotalPrice() != null) {
            existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        }
        if (updatedOrder.getStatus() != null) {
            existingOrder.setStatus(updatedOrder.getStatus());
        }
        if (updatedOrder.getId() != null) {
            existingOrder.setId(updatedOrder.getId());
        }

        // 保存更新后的订单
        Order savedOrder = orderRepository.saveAndFlush(existingOrder);

        // 将实体转换为 DTO 并返回
        return OrderDtoMapper.mapOrderToGetOrderDto(savedOrder);
    }


    @Override
    @Transactional
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findByIdWithPessimisticLock(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));


        // The order is still running, not something in the past, need to add back the book stock quantity in database
        if (order.getStatus().equals(OrderStatusEnum.ORDER_STATUS_PROCESSING) || order.getStatus().equals(OrderStatusEnum.ORDER_STATUS_DELIVERING)) {
            order.setStatus(OrderStatusEnum.ORDER_STATUS_CANCELLED);
            orderRepository.save(order);

            List<OrderedBook> orderedBooks = orderedBookRepository.findAllByOrderId(orderId);
            for (OrderedBook orderedBook : orderedBooks) {
                Book book = orderedBook.getBook();
                int newStockQuantity = book.getStockQuantity() + orderedBook.getQuantity();

                // Update the book stock directly
                book.setStockQuantity(newStockQuantity);
                bookRepository.save(book); // Direct repository save avoids redundant logic in bookService
            }
        }
        order.setIsDeleted(true);
        orderRepository.save(order);

        // Logical delete the order
//        orderRepository.delete(order);
    }
}

