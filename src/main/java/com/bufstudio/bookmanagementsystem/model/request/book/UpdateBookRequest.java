package com.bufstudio.bookmanagementsystem.model.request.book;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class UpdateBookRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 6764624002336635225L;
    private Long BookId;
    private String title;
    private String author;
    private String genre;
    private Integer stockQuantity;
    private Integer restockThreshold;

    public Long getBookId() {
        return BookId;
    }

    public void setBookId(Long bookId) {
        this.BookId = bookId;
    }

    private BigDecimal price;


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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getRestockThreshold() {
        return restockThreshold;
    }

    public void setRestockThreshold(Integer restock_threshold) {
        this.restockThreshold = restock_threshold;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
