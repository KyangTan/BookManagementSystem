package com.bufstudio.bookmanagementsystem.service.book;

import com.bufstudio.bookmanagementsystem.model.dto.GetBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.GetBookListDto;
import com.bufstudio.bookmanagementsystem.model.entity.Book;

import java.math.BigInteger;

public interface BookService {

    public void addBook(Book book);

    public void updateBook();

    public void deleteBook();

    public GetBookDto getBook(Long bookId);

    public GetBookListDto getBookList(String author, BigInteger price, String genre);
}
