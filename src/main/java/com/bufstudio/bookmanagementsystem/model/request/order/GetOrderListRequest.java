package com.bufstudio.bookmanagementsystem.model.request.order;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Data
public class GetOrderListRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -2094344702936651361L;

    private String userId;
    private BigInteger priceFilterLowerBound;
    private BigInteger priceFilterUpperBound;
    private String status;
    private Integer page;
    private Integer size;
    private String sort;
    private String orderByField;
}
