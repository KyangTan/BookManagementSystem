package com.bufstudio.bookmanagementsystem.model.request.book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Data
public class UpdateBookRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 6764624002336635225L;

    @NotEmpty(message = "Book Id is required")
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private Integer stock_quantity;
    private Integer restock_threshold;
    private BigInteger price;

}
