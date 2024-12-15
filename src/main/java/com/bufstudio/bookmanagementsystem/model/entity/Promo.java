package com.bufstudio.bookmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "promos")
@Data
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discountRate;
    private String promoCode;
    private String name;

    private LocalDateTime effectiveStartTimestamp;
    private LocalDateTime effectiveEndTimestamp;
    private Boolean isDeleted;

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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}

