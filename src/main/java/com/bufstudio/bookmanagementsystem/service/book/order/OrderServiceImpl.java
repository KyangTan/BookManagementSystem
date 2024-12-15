package com.bufstudio.bookmanagementsystem.service.book.order;
import com.bufstudio.bookmanagementsystem.mapper.OrderDtoMapper;
import com.bufstudio.bookmanagementsystem.model.entity.Order;
import com.bufstudio.bookmanagementsystem.model.request.order.*;
import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderListResponse;
import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderResponse;
import com.bufstudio.bookmanagementsystem.repository.book.order.OrderRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public GetOrderResponse getOrder(GetOrderRequest request) {
        // 查找订单
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + request.getOrderId()));



        // 转换为响应DTO
        return OrderDtoMapper.mapOrderToGetOrderDto(order);
    }

    @Override
    public GetOrderListResponse getOrderList(GetOrderListRequest request) {
        // 使用criteriaBuilder构建动态查询条件
        var orders = orderRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 按userId过滤
            if (request.getUserId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("userId"), request.getUserId()));
            }

            // 按价格区间过滤
            if (request.getPriceFilterLowerBound() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("totalPrice"), request.getPriceFilterLowerBound()));
            }
            if (request.getPriceFilterUpperBound() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalPrice"), request.getPriceFilterUpperBound()));
            }

            // 按状态过滤
            if (request.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), request.getStatus()));
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
        response.setCurrentPage(request.getPage() != null ? request.getPage() : 0);
        response.setPageSize(request.getSize() != null ? request.getSize() : orderResponseList.size());

        return response;
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }


    @Override
    public GetOrderResponse updateOrder(UpdateOrderRequest request) {
        Order existingOrder = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + request.getOrderId()));

        // 更新字段
        if (request.getTotalPrice() != null) {
            existingOrder.setTotalPrice(request.getTotalPrice());
        }
        if (request.getStatus() != null) {
            existingOrder.setStatus(request.getStatus());
        }

        // 保存更新后的订单
        Order savedOrder = orderRepository.saveAndFlush(existingOrder);

        return OrderDtoMapper.mapOrderToGetOrderDto(savedOrder);
    }

    @Override
    public void deleteOrder(DeleteOrderRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + request.getOrderId()));

        // logical delete
        order.setIsDeleted(true);
        orderRepository.saveAndFlush(order);
    }
}

