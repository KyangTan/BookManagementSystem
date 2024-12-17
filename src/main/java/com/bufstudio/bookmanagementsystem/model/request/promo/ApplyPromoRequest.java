package com.bufstudio.bookmanagementsystem.model.request.promo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class ApplyPromoRequest {

    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @NotNull(message = "Promo ID cannot be null")
    private Long promoId;

    // 如果需要支持促销代码，也可以添加此字段
    private String promoCode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPromoId() {
        return promoId;
    }

    public void setPromoId(Long promoId) {
        this.promoId = promoId;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }
}
