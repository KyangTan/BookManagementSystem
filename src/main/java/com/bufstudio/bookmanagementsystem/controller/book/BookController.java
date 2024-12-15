package com.bufstudio.bookmanagementsystem.controller.book;

import com.bufstudio.bookmanagementsystem.model.request.book.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/books")
public interface BookController {

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<Map<String, Object>> getBook(@RequestParam GetBookRequest request);

    @GetMapping
    public ResponseEntity<Map<String, Object>> getBookList(@RequestParam GetBookListRequest request);

    @PostMapping
    public ResponseEntity<Map<String, Object>> addBook(@RequestParam CreateBookRequest request);

    @PutMapping(value = "/{bookId}")
    public ResponseEntity<Map<String, Object>> updateBook(@RequestParam UpdateBookRequest request);

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<Map<String, Object>> deleteBook(@RequestParam DeleteBookRequest request);
}
