package com.bufstudio.bookmanagementsystem.service.book;

import com.bufstudio.bookmanagementsystem.model.dto.GetBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.GetBookListDto;
import com.bufstudio.bookmanagementsystem.model.entity.Book;

import java.math.BigDecimal;

public interface BookService {

    public void addBook(Book book);

    public GetBookDto updateBook(Long bookId, Book updatedBook);

    public GetBookDto getBook(Long bookId);

    public GetBookListDto getBookList(String author, BigDecimal price, String genre);

    void deleteBook(Long bookId);
}
