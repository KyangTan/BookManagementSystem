package com.bufstudio.bookmanagementsystem.controller.book;

import com.bufstudio.bookmanagementsystem.model.request.book.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/books")
public interface BookController {

    @GetMapping(value = "/{bookId}")
    ResponseEntity<Map<String, Object>> getBook(@PathVariable Long bookId);

    @GetMapping
    ResponseEntity<Map<String, Object>> getBookList(@RequestBody GetBookListRequest request);

    @PostMapping
    ResponseEntity<Map<String, Object>> addBook(@RequestBody CreateBookRequest request);

    @PutMapping(value = "/{bookId}")
    ResponseEntity<Map<String, Object>> updateBook(@RequestBody UpdateBookRequest request , @PathVariable Long bookId);

    @DeleteMapping(value = "/{bookId}")
    ResponseEntity<Map<String, Object>> deleteBook(@RequestBody DeleteBookRequest request , @PathVariable Long bookId);
}
