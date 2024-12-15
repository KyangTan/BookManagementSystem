package com.bufstudio.bookmanagementsystem.service.book.order;

import com.bufstudio.bookmanagementsystem.model.dto.GetOrderDto;
import com.bufstudio.bookmanagementsystem.model.entity.Order;
import com.bufstudio.bookmanagementsystem.model.request.order.CreateOrderRequest;
import com.bufstudio.bookmanagementsystem.model.request.order.DeleteOrderRequest;
import com.bufstudio.bookmanagementsystem.model.request.order.GetOrderListRequest;
import com.bufstudio.bookmanagementsystem.model.request.order.GetOrderRequest;
import com.bufstudio.bookmanagementsystem.model.request.order.UpdateOrderRequest;

import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderListResponse;
import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderResponse;

public interface OrderService {

    GetOrderDto getOrder(GetOrderRequest request);


    GetOrderListResponse getOrderList(GetOrderListRequest request);

    void addOrder(Order order);



    GetOrderDto updateOrder(Long orderId, Order updatedOrder);

    void deleteOrder(DeleteOrderRequest request);
}

