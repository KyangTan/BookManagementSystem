package com.bufstudio.bookmanagementsystem.service.order;

import com.bufstudio.bookmanagementsystem.model.dto.order.BookOrderDto;
import com.bufstudio.bookmanagementsystem.model.dto.order.GetOrderDto;
import com.bufstudio.bookmanagementsystem.model.entity.Order;

import com.bufstudio.bookmanagementsystem.model.response.order.GetOrderListResponse;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    GetOrderDto getOrder(Long orderId);

    GetOrderListResponse getOrderList(Long userId, BigDecimal priceFilterLowerBound, BigDecimal priceFilterUpperbound, String status, Integer page, Integer size);

    void addOrder(List<BookOrderDto> booksToOrder, Long userId);

    GetOrderDto updateOrder(Long orderId, Order updatedOrder);

    void deleteOrder(Long orderId);

    void applyPromoToOrder(Long orderId, Long promoId);
}

