package com.bufstudio.bookmanagementsystem.service.book;

import com.bufstudio.bookmanagementsystem.mapper.BookDtoMapper;
import com.bufstudio.bookmanagementsystem.model.dto.GetBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.GetBookListDto;
import com.bufstudio.bookmanagementsystem.model.entity.Book;
import com.bufstudio.bookmanagementsystem.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public GetBookDto getBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));

        return BookDtoMapper.mapBookToGetBookDto(book);
    }

    @Override
    public GetBookListDto getBookList(String author, BigDecimal price, String genre) {
        List<Book> bookList = bookRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (author != null) {
                predicates.add(criteriaBuilder.equal(root.get("author"), author));
            }
            if (price != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), price));
            }
            if (genre != null) {
                predicates.add(criteriaBuilder.equal(root.get("genre"), genre));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

        GetBookListDto getBookListDto = new GetBookListDto();

        List<GetBookDto> convertedBookList = bookList.stream()
                .map(BookDtoMapper::mapBookToGetBookDto)
                .toList();

        getBookListDto.setBookList(convertedBookList);

        return getBookListDto;
    }


    @Override
    public void addBook(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public GetBookDto updateBook(Long bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));

        // Update fields
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setStockQuantity(updatedBook.getStockQuantity());
        existingBook.setRestockThreshold(updatedBook.getRestockThreshold());

        // Save updated book
        Book savedBook = bookRepository.saveAndFlush(existingBook);

        // Convert to DTO and return
        return BookDtoMapper.mapBookToGetBookDto(savedBook);
    }


    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));

        // Delete the book
        bookRepository.delete(book);
    }


}
