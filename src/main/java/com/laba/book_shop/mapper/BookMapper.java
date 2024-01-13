package com.laba.book_shop.mapper;

import com.laba.book_shop.dto.BookDTO;
import com.laba.book_shop.entity.Book;


public class BookMapper {

    public BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }

    public Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }
}
