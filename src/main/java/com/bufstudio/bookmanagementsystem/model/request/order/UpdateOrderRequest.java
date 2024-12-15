package com.bufstudio.bookmanagementsystem.model.request.order;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UpdateOrderRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -987654321098765432L;
    @NotEmpty(message = "orderId is required")
    private Long orderId;
    @NotEmpty(message = "totalPrice is required")
    private BigDecimal totalPrice;
    @NotEmpty(message = "status is required")
    private String status;

    public @NotEmpty(message = "orderId is required") Long getOrderId() {
        return orderId;
    }

    public void setOrderId(@NotEmpty(message = "orderId is required") Long orderId) {
        this.orderId = orderId;
    }

    public @NotEmpty(message = "totalPrice is required") BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@NotEmpty(message = "totalPrice is required") BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public @NotEmpty(message = "status is required") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "status is required") String status) {
        this.status = status;
    }
}
