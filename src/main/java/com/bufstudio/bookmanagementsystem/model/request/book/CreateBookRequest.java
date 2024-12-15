package com.bufstudio.bookmanagementsystem.model.request.book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Data
public class CreateBookRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -124494212958511030L;

    @NotEmpty(message = "User Id is required")
    private String userId;

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Author is required")
    private String author;

    @NotEmpty(message = "Genre is required")
    private String genre;

    @NotEmpty(message = "Price is required")
    private BigInteger price;

    private Integer stock_quantity;

    private Integer restock_threshold;

}
