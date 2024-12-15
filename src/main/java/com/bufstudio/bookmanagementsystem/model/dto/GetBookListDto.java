package com.bufstudio.bookmanagementsystem.model.dto;

import java.util.List;

public class GetBookListDto {

    private List<GetBookDto> bookList;

    public List<GetBookDto> getBookList() {
        return bookList;
    }

    public void setBookList(List<GetBookDto> bookList) {
        this.bookList = bookList;
    }
}
