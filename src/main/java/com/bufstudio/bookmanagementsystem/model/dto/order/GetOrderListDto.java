package com.bufstudio.bookmanagementsystem.model.dto.order;

import java.util.List;

public class GetOrderListDto {

    private List<GetOrderDto> orderList;

    public List<GetOrderDto> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<GetOrderDto> orderList) {
        this.orderList = orderList;
    }
}
