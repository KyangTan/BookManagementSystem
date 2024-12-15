package com.bufstudio.bookmanagementsystem.model.response.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetOrderedBookResponse {
    private Long bookId;
    private String title;
    private String author;
    private BigDecimal price;
    private Integer quantity;  // 该书在订单中的数量

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

