package com.bufstudio.bookmanagementsystem.controller.order;

import com.bufstudio.bookmanagementsystem.model.dto.order.BookOrderDto;
import com.bufstudio.bookmanagementsystem.model.dto.order.GetOrderDto;
import com.bufstudio.bookmanagementsystem.model.entity.Order;
import com.bufstudio.bookmanagementsystem.model.entity.Promo;
import com.bufstudio.bookmanagementsystem.model.entity.PromotedOrder;
import com.bufstudio.bookmanagementsystem.model.request.order.*;
import com.bufstudio.bookmanagementsystem.model.request.promo.ApplyPromoRequest;
import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderListResponse;
//import com.bufstudio.bookmanagementsystem.service.order.OrderService;
//import com.bufstudio.bookmanagementsystem.service.order.OrderPromoService; // 假设有这类服务来处理促销应用
import com.bufstudio.bookmanagementsystem.repository.order.OrderRepository;
import com.bufstudio.bookmanagementsystem.repository.promo.PromoRepository;
import com.bufstudio.bookmanagementsystem.service.order.OrderService;
import com.bufstudio.bookmanagementsystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class OrderControllerImpl implements OrderController {

    @Autowired
    OrderService orderService;

    @Override
    public ResponseEntity<Map<String, Object>> getOrder(Long orderId) {
        GetOrderDto response = orderService.getOrder(orderId);
        return ResponseUtil.createSuccessResponse("Successfully got the order", response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOrderList(GetOrderListRequest request) {
        GetOrderListResponse response = orderService.getOrderList(request.getUserId(), request.getPriceFilterLowerBound(), request.getPriceFilterUpperBound(), request.getStatus(), request.getPage(), request.getSize());
        return ResponseUtil.createSuccessResponse("Successfully got order list", response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> createNewOrder(CreateOrderRequest request) {

        List<BookOrderDto> booksToOrder = request.getBooks();

        // Save the order
        orderService.addOrder(booksToOrder, request.getUserId());

        return ResponseUtil.createSuccessResponse("Successfully added an order", null);
    }


    @Override
    public ResponseEntity<Map<String, Object>> updateOrder(@PathVariable Long orderId, @RequestBody UpdateOrderRequest request) {
        // 将请求数据转换为 Order 实体用于更新
        Order updatedOrder = new Order();
        updatedOrder.setTotalPrice(request.getTotalPrice());
        updatedOrder.setStatus(request.getStatus());
        updatedOrder.setId(orderId);
        // 调用服务层更新订单，并获取更新后的 DTO
        GetOrderDto updatedOrderDto = orderService.updateOrder(orderId, updatedOrder);

        // 返回成功响应
        return ResponseUtil.createSuccessResponse("Successfully updated the order", updatedOrderDto);
    }


    @Override
    public ResponseEntity<Map<String, Object>> deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseUtil.createSuccessResponse("Successfully deleted the order", null);
    }

    @Override
    public ResponseEntity<Map<String, Object>> applyPromoToOrder(Long orderId, Long promoId) {
            orderService.applyPromoToOrder(orderId,promoId);
            return ResponseUtil.createSuccessResponse("Promo applied successfully to the order", null);
        }
    }





