package com.bufstudio.bookmanagementsystem.model.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GetOrderDto {
    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private BigDecimal totalPrice;
    private String status;

    // 如果需要订单项信息可在这里加入List<GetOrderedBookDto>等字段

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
