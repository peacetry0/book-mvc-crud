package com.peace.book_mvc_crud.repository;

import com.peace.book_mvc_crud.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
