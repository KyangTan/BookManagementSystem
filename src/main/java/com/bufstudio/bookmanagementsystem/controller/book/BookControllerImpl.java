package com.bufstudio.bookmanagementsystem.controller.book;

import com.bufstudio.bookmanagementsystem.model.dto.GetBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.GetBookListDto;
import com.bufstudio.bookmanagementsystem.model.request.book.*;
import com.bufstudio.bookmanagementsystem.service.book.BookService;
import com.bufstudio.bookmanagementsystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
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

    @Override
    public ResponseEntity<Map<String, Object>> addBook(CreateBookRequest request) {
        return ResponseUtil.createSuccessResponse("Successfully get one book", "");
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateBook(UpdateBookRequest request) {
        return ResponseUtil.createSuccessResponse("Successfully get one book", "");
    }

    @Override
    public void deleteBook(DeleteBookRequest request) {

    }
}
