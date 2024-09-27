package com.peace.book_mvc_crud.config;

import com.peace.book_mvc_crud.dto.convertor.BookConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


        @Bean
         public BookConvertor bookConvertor(){
            return new BookConvertor() ;
        }
}
