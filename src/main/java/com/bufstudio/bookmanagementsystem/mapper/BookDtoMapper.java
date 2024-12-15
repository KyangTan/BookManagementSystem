package com.bufstudio.bookmanagementsystem.mapper;

import com.bufstudio.bookmanagementsystem.model.dto.GetBookDto;
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
}
