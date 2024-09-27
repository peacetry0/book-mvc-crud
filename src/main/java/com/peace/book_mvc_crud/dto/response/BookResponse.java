package com.peace.book_mvc_crud.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    protected LocalDateTime createdAt ;
    protected LocalDateTime updatedAt ;

}
