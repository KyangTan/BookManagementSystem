package com.bufstudio.bookmanagementsystem.model.request.order;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class DeleteOrderRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -111222333444555666L;
@NotEmpty(message = "orderId is request")
    private Long orderId;

    public @NotEmpty(message = "orderId is request") Long getOrderId() {
        return orderId;
    }

    public void setOrderId(@NotEmpty(message = "orderId is request") Long orderId) {
        this.orderId = orderId;
    }
}
