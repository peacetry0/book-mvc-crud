package com.peace.book_mvc_crud.dto.convertor;

import com.peace.book_mvc_crud.dto.request.CreateBookRequest;
import com.peace.book_mvc_crud.dto.request.UpdateBookRequest;
import com.peace.book_mvc_crud.dto.response.BookResponse;
import com.peace.book_mvc_crud.model.Book;

public class BookConvertor {




     public  Book fromCreateBookRequest(final CreateBookRequest createBookRequest){
         Book book = new Book() ;
         book.setTitle(createBookRequest.getTitle());
         book.setAuthor(createBookRequest.getAuthor());
         return book ;
     }

     public  Book fromUpdateBookRequest(final UpdateBookRequest updateBookRequest,final Book book){
         book.setTitle(updateBookRequest.getTitle());
         book.setAuthor(updateBookRequest.getAuthor());
         return book ;
     }

     public  BookResponse toBookResponse(final Book book){
         BookResponse bookResponse = new BookResponse() ;
         bookResponse.setId(book.getId());
         bookResponse.setCreatedAt(book.getCreatedAt());
         bookResponse.setUpdatedAt(book.getUpdatedAt());
         bookResponse.setTitle(book.getTitle());
         bookResponse.setAuthor(book.getAuthor());
         return bookResponse ;
     }
}
