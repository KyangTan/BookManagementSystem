package com.bufstudio.bookmanagementsystem.model.request.book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Data
public class GetBookListRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -3047193828857309831L;

    @NotEmpty(message = "User Id is required")
    private String userId;

    private BigInteger price;

    private String author;

    private String genre;

//    private Integer stockQuantityFilterLowerBound;
//    private Integer stockQuantityFilterUpperBound;
//
//    private BigInteger priceFilterLowerBound;
//    private BigInteger priceFilterUpperBound;
//
//    private Integer page;
//    private Integer size;
//    private String sort;
//    private String orderByField;
}
