package com.bufstudio.bookmanagementsystem.model.request.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class GetOrderRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -3176623870790075374L;

    public @NotNull(message = "Order Id is required") Long getOrderId() {
        return orderId;
    }

    public void setOrderId(@NotNull(message = "Order Id is required") Long orderId) {
        this.orderId = orderId;
    }

    public @NotEmpty(message = "User Id is required") String getUserId() {
        return userId;
    }

    public void setUserId(@NotEmpty(message = "User Id is required") String userId) {
        this.userId = userId;
    }

    @NotNull(message = "Order Id is required")
    private Long orderId;

    @NotEmpty(message = "User Id is required")
    private String userId;
}
