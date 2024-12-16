package com.bufstudio.bookmanagementsystem.mapper;

import com.bufstudio.bookmanagementsystem.model.dto.book.GetBookDto;
import com.bufstudio.bookmanagementsystem.model.entity.Book;

public class BookDtoMapper {

    public static GetBookDto mapBookToGetBookDto(Book book) {
        GetBookDto dto = new GetBookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        dto.setPrice(book.getPrice());
        dto.setStockQuantity(book.getStockQuantity());
        dto.setRestockThreshold(book.getRestockThreshold());
        return dto;
    }

    public static Book mapGetBookDtoToBook(GetBookDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setPrice(dto.getPrice());
        book.setStockQuantity(dto.getStockQuantity());
        book.setRestockThreshold(dto.getRestockThreshold());
        return book;
    }
}
