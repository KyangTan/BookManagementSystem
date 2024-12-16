package com.bufstudio.bookmanagementsystem.service.book;

import com.bufstudio.bookmanagementsystem.model.dto.book.GetBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.book.GetBookListDto;
import com.bufstudio.bookmanagementsystem.model.entity.Book;

import java.math.BigDecimal;

public interface BookService {

    void addBook(Book book);

    GetBookDto updateBook(Long bookId, Book updatedBook);

    GetBookDto getBook(Long bookId);

    GetBookListDto getBookList(String author, BigDecimal price, String genre);

    void deleteBook(Long bookId);
}
