package com.bufstudio.bookmanagementsystem.model.request.book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class GetBookRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -1979893737479575233L;

    @NotEmpty(message = "Book Id is required")
    private Long bookId;

    @NotEmpty(message = "User Id is required")
    private String userId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
