package com.bufstudio.bookmanagementsystem.mapper;

import com.bufstudio.bookmanagementsystem.model.dto.order.GetOrderDto;
import com.bufstudio.bookmanagementsystem.model.entity.Order;

public class OrderDtoMapper {

    public static GetOrderDto mapOrderToGetOrderDto(Order order) {
        GetOrderDto dto = new GetOrderDto();
        dto.setId(order.getId());
        dto.setUserId(order.getId());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        // 如果订单有关联的订单项列表，可在此处进行对应的DTO转换
        return dto;
    }
}
