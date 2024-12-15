package com.bufstudio.bookmanagementsystem.controller.order;

import com.bufstudio.bookmanagementsystem.model.request.order.GetOrderListRequest;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderController {

    public void createNewOrder();

    public void getOrder();

    public void getOrderList(@RequestParam GetOrderListRequest request);

    public void updateOrder();

    public void deleteOrder();

    public void applyPromoToOrder();
}
