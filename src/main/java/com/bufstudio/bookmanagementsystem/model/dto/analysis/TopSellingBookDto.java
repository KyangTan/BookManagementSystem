package com.bufstudio.bookmanagementsystem.model.dto.analysis;

import java.math.BigDecimal;

public class TopSellingBookDto {
    private String bookName;
    private Integer count;
    private BigDecimal totalEarning;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(BigDecimal totalEarning) {
        this.totalEarning = totalEarning;
    }
}
