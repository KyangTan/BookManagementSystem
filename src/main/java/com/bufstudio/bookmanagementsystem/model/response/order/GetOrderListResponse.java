package com.bufstudio.bookmanagementsystem.model.response.order;



import com.bufstudio.bookmanagementsystem.model.dto.order.GetOrderDto;
import lombok.Data;

import java.util.List;

@Data
public class GetOrderListResponse {
    /**
     * 订单列表，元素为单个订单的响应DTO
     */
    private List<GetOrderDto> orders;

    /**
     * 符合条件的订单总数，用于分页显示
     */
    private long totalCount;

    /**
     * 当前页码（通常从0或1开始，根据业务约定）
     */
    private int currentPage;

    /**
     * 每页显示的订单数
     */
    private int pageSize;

    public List<GetOrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<GetOrderDto> orders) {
        this.orders = orders;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

