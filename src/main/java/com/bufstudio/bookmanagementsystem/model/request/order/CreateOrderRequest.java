package com.bufstudio.bookmanagementsystem.model.request.order;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CreateOrderRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -1234567890123456789L;
    @NotEmpty(message = "userId is required")
    private Long userId;
    @NotEmpty(message = "totalPrice is required")
    private BigDecimal totalPrice;

    public @NotEmpty(message = "status is required") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "status is required") String status) {
        this.status = status;
    }

    public @NotEmpty(message = "totalPrice is required") BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@NotEmpty(message = "totalPrice is required") BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NotEmpty(message = "userId is required") Long userId) {
        this.userId = userId;
    }

    @NotEmpty(message = "status is required")
    private String status;


}