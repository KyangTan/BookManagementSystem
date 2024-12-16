package com.bufstudio.bookmanagementsystem.controller.book;

import com.bufstudio.bookmanagementsystem.model.request.book.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/books")
public interface BookController {

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<Map<String, Object>> getBook(GetBookRequest request);

    @GetMapping
    ResponseEntity<Map<String, Object>> getBookList(@RequestBody GetBookListRequest request);

    @PostMapping
    ResponseEntity<Map<String, Object>> addBook(@RequestBody CreateBookRequest request);

    @PutMapping(value = "/{bookId}")
    public ResponseEntity<Map<String, Object>> updateBook(UpdateBookRequest request);

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<Map<String, Object>> deleteBook(DeleteBookRequest request);
}
