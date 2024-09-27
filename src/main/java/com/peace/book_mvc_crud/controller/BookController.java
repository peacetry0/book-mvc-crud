package com.peace.book_mvc_crud.controller;

import com.peace.book_mvc_crud.dto.request.CreateBookRequest;
import com.peace.book_mvc_crud.dto.request.UpdateBookRequest;
import com.peace.book_mvc_crud.dto.response.BookResponse;
import com.peace.book_mvc_crud.model.Book;
import com.peace.book_mvc_crud.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable final Long id) {
        BookResponse bookResponse = this.bookService.getById(id);
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> bookResponses = this.bookService.getAllBooks();
        return ResponseEntity.ok(bookResponses);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody final CreateBookRequest createBookRequest) {
        BookResponse createdBook = this.bookService.createBook(createBookRequest);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable final Long id, @RequestBody final UpdateBookRequest updateBookRequest) {
        BookResponse updatedBook = this.bookService.updateBook(id, updateBookRequest);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable final Long id) {
        this.bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
