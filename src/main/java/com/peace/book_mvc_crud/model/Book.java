package com.peace.book_mvc_crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Books")
public class Book extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id ;

    @Column(name = "TITLE")
    private String title ;
    @Column(name = "AUTHOR")
    private String author ;

}
