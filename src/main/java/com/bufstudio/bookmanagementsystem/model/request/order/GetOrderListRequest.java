package com.bufstudio.bookmanagementsystem.model.request.order;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GetOrderListRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -2094344702936651361L;

    private String userId;
    private BigDecimal priceFilterLowerBound;
    private BigDecimal priceFilterUpperBound;
    private String status;
    private Integer page;
    private Integer size;
    private String sort;
    private String orderByField;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getPriceFilterLowerBound() {
        return priceFilterLowerBound;
    }

    public void setPriceFilterLowerBound(BigDecimal priceFilterLowerBound) {
        this.priceFilterLowerBound = priceFilterLowerBound;
    }

    public BigDecimal getPriceFilterUpperBound() {
        return priceFilterUpperBound;
    }

    public void setPriceFilterUpperBound(BigDecimal priceFilterUpperBound) {
        this.priceFilterUpperBound = priceFilterUpperBound;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }
}
