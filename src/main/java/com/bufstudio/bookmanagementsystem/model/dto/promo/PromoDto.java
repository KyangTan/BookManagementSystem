package com.bufstudio.bookmanagementsystem.model.dto.promo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PromoDto implements Serializable {
    private Long id;

    private BigDecimal discountRate;
    private String promoCode;
    private String name;

    private LocalDateTime effectiveStartTimestamp;
    private LocalDateTime effectiveEndTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEffectiveStartTimestamp() {
        return effectiveStartTimestamp;
    }

    public void setEffectiveStartTimestamp(LocalDateTime effectiveStartTimestamp) {
        this.effectiveStartTimestamp = effectiveStartTimestamp;
    }

    public LocalDateTime getEffectiveEndTimestamp() {
        return effectiveEndTimestamp;
    }

    public void setEffectiveEndTimestamp(LocalDateTime effectiveEndTimestamp) {
        this.effectiveEndTimestamp = effectiveEndTimestamp;
    }
}
