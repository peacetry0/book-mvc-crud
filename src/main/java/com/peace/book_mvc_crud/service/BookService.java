package com.peace.book_mvc_crud.service;

import com.peace.book_mvc_crud.model.Book;
import com.peace.book_mvc_crud.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book getById(final Long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id is not found"));
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book createBook(final Book book) {
        return this.bookRepository.save(book);
    }

    public Book updateBook(final Long id, final Book book) {
        Book existingBook = this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID is not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());

        return this.bookRepository.save(existingBook);
    }

    public void deleteBook(final Long id) {
        this.bookRepository.deleteById(id);
    }
}
