package com.bufstudio.bookmanagementsystem.controller.order;
import com.bufstudio.bookmanagementsystem.model.dto.GetOrderDto;
import com.bufstudio.bookmanagementsystem.model.entity.Order;
import com.bufstudio.bookmanagementsystem.model.request.order.*;
import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderListResponse;
import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderResponse;
//import com.bufstudio.bookmanagementsystem.service.order.OrderService;
//import com.bufstudio.bookmanagementsystem.service.order.OrderPromoService; // 假设有这类服务来处理促销应用
import com.bufstudio.bookmanagementsystem.service.book.order.OrderService;
import com.bufstudio.bookmanagementsystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class OrderControllerImpl implements OrderController {

    @Autowired
    OrderService orderService;



    @Override
    public ResponseEntity<Map<String, Object>> createNewOrder(CreateOrderRequest request) {
        // Convert request to Order entity
        Order order = new Order();
        order.setId(request.getUserId());
        order.setTotalPrice(request.getTotalPrice());
        order.setStatus(request.getStatus());
        order.setCreatedAt(LocalDateTime.now());
        order.setIsDeleted(false);

        // Save the order
        orderService.addOrder(order);

        return ResponseUtil.createSuccessResponse("Successfully added an order", null);
    }


    @Override
    public ResponseEntity<Map<String, Object>> getOrder(Long orderId) {
        // 假设使用GetOrderRequest
        GetOrderRequest getOrderRequest = new GetOrderRequest();
        getOrderRequest.setOrderId(orderId);
        GetOrderDto response = orderService.getOrder(getOrderRequest);
        return ResponseUtil.createSuccessResponse("Successfully got the order", response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOrderList(GetOrderListRequest request) {
        GetOrderListResponse response = orderService.getOrderList(request);
        return ResponseUtil.createSuccessResponse("Successfully got order list", response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateOrder(UpdateOrderRequest request) {
        // 将请求数据转换为 Order 实体用于更新
        Order updatedOrder = new Order();
        updatedOrder.setTotalPrice(request.getTotalPrice());
        updatedOrder.setStatus(request.getStatus());
        updatedOrder.setId(request.getOrderId());
        // 调用服务层更新订单，并获取更新后的 DTO
        GetOrderDto updatedOrderDto = orderService.updateOrder(request.getOrderId(), updatedOrder);

        // 返回成功响应
        return ResponseUtil.createSuccessResponse("Successfully updated the order", updatedOrderDto);
    }


    @Override
    public ResponseEntity<Map<String, Object>> deleteOrder(DeleteOrderRequest request) {
        orderService.deleteOrder(request);
        return ResponseUtil.createSuccessResponse("Successfully deleted the order", null);
    }


}
