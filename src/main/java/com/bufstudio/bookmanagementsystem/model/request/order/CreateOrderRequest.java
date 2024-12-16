package com.bufstudio.bookmanagementsystem.model.request.order;

import com.bufstudio.bookmanagementsystem.model.dto.order.BookOrderDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class CreateOrderRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -1234567890123456789L;

    @NotEmpty(message = "User ID is required")
    private Long userId;

    @NotEmpty(message = "At least one book is required")
    private List<BookOrderDto> books;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<BookOrderDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookOrderDto> books) {
        this.books = books;
    }
}