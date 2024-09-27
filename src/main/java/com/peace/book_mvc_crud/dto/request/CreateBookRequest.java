package com.peace.book_mvc_crud.dto.request;

import lombok.Data;

@Data
public class CreateBookRequest {

    private String title;
    private String author;
}
