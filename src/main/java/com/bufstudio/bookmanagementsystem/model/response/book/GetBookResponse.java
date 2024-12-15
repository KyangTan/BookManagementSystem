package com.bufstudio.bookmanagementsystem.model.response.book;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetBookResponse {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private BigDecimal price;
    private Integer stockQuantity;
    private Integer restockThreshold;
}
