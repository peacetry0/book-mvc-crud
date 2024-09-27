package com.peace.book_mvc_crud.service;

import com.peace.book_mvc_crud.dto.convertor.BookConvertor;
import com.peace.book_mvc_crud.dto.request.CreateBookRequest;
import com.peace.book_mvc_crud.dto.request.UpdateBookRequest;
import com.peace.book_mvc_crud.dto.response.BookResponse;
import com.peace.book_mvc_crud.model.Book;
import com.peace.book_mvc_crud.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookConvertor bookConvertor ;

    public BookResponse getById(final Long id) {
        Book book =  this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id is not found"));

        return bookConvertor.toBookResponse(book) ;
    }

    public List<BookResponse> getAllBooks() {
        return this.bookRepository.findAll()
                .stream()
                .map(bookConvertor::toBookResponse)
                .collect(Collectors.toList());
    }

    public BookResponse createBook(final CreateBookRequest createBookRequest) {
        Book book = bookConvertor.fromCreateBookRequest(createBookRequest) ;

        return bookConvertor.toBookResponse(this.bookRepository.save(book)) ;
    }

    public BookResponse updateBook(final Long id, final UpdateBookRequest updateBookRequest) {
        Book existingBook = this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID is not found"));

       bookConvertor.fromUpdateBookRequest(updateBookRequest,existingBook) ;

        return bookConvertor.toBookResponse(this.bookRepository.save(existingBook)) ; 
    }

    public void deleteBook(final Long id) {
        this.bookRepository.deleteById(id);
    }
}
