package com.bufstudio.bookmanagementsystem.model.request.book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class GetBookRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -1979893737479575233L;

    @NotEmpty(message = "User Id is required")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
