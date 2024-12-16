package com.bufstudio.bookmanagementsystem.model.request.book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GetBookListRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -3047193828857309831L;

    @NotEmpty(message = "User Id is required")
    private String userId;

    private BigDecimal price;

    private String author;

    private String genre;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    //    private Integer stockQuantityFilterLowerBound;
    //    private Integer stockQuantityFilterUpperBound;
    //
    //    private BigDecimal priceFilterLowerBound;
    //    private BigDecimal priceFilterUpperBound;
    //
    //    private Integer page;
    //    private Integer size;
    //    private String sort;
    //    private String orderByField;
}
