package com.bufstudio.bookmanagementsystem.controller.book;

import com.bufstudio.bookmanagementsystem.model.dto.GetBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.GetBookListDto;
import com.bufstudio.bookmanagementsystem.model.entity.Book;
import com.bufstudio.bookmanagementsystem.model.request.book.*;
import com.bufstudio.bookmanagementsystem.service.book.BookService;
import com.bufstudio.bookmanagementsystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookControllerImpl implements BookController {

    @Autowired
    BookService bookService;

    @Override
    public ResponseEntity<Map<String, Object>> getBook(GetBookRequest request) {
        GetBookDto serviceResult = bookService.getBook(request.getBookId());
        return ResponseUtil.createSuccessResponse("Successfully get one book", serviceResult);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getBookList(GetBookListRequest request) {

        GetBookListDto serviceResult = bookService.getBookList(request.getAuthor(), request.getPrice(), request.getGenre());
        return ResponseUtil.createSuccessResponse("Successfully get list book", "");
    }
    @PostMapping
    @Override
    public ResponseEntity<Map<String, Object>> addBook(@RequestBody CreateBookRequest request) {
        // Convert request to Book entity
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setGenre(request.getGenre());
        book.setPrice(request.getPrice());
        book.setStockQuantity(request.getStockQuantity());
        book.setRestockThreshold(request.getRestockThreshold());

        // Save the book
        bookService.addBook(book);

        return ResponseUtil.createSuccessResponse("Successfully added a book", null);
    }
    @PutMapping(value = "/{bookId}")
    @Override
    public ResponseEntity<Map<String, Object>> updateBook(@RequestBody UpdateBookRequest request) {
        // Convert request to Book entity for updates
        Book updatedBook = new Book();
        updatedBook.setTitle(request.getTitle());
        updatedBook.setAuthor(request.getAuthor());
        updatedBook.setGenre(request.getGenre());
        updatedBook.setPrice(request.getPrice());
        updatedBook.setStockQuantity(request.getStockQuantity());
        updatedBook.setRestockThreshold(request.getRestockThreshold());

        // Update the book and get the updated DTO
        GetBookDto updatedBookDto = bookService.updateBook(request.getBookId(), updatedBook);

        return ResponseUtil.createSuccessResponse("Successfully updated the book", updatedBookDto);
    }

    @Override
    public ResponseEntity<Map<String, Object>> deleteBook(DeleteBookRequest request) {
        // Delete the book
        bookService.deleteBook(request.getBookId());

        return ResponseUtil.createSuccessResponse("Successfully deleted the book", null);
    }
}
