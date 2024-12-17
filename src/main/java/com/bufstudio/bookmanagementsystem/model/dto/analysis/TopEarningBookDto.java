package com.bufstudio.bookmanagementsystem.model.dto.analysis;

import java.math.BigDecimal;

public class TopEarningBookDto {
    private String bookName;
    private BigDecimal totalEarning;
    private Integer count;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(BigDecimal totalEarning) {
        this.totalEarning = totalEarning;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
