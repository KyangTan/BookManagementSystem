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
}

