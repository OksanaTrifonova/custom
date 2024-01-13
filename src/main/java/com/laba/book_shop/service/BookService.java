package com.laba.book_shop.service;

import com.laba.book_shop.dto.BookDTO;
import com.laba.book_shop.entity.Book;
import com.laba.book_shop.mapper.BookMapper;
import com.laba.book_shop.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));
        return bookMapper.toBookDTO(book);
    }

    public void addBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Long id, BookDTO updatedBookDTO) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(updatedBookDTO.getTitle());
            book.setPrice(updatedBookDTO.getPrice());
            book.setAuthor(updatedBookDTO.getAuthor());
        }
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.delete(book);
        }
    }

//    public Set<Author> mapAuthorIDsToAuthors(List <Long> authorIds){
//        return authorIds.stream()
//                .map(authorId -> authorRepository.findById(authorId)
//                        .orElseThrow(()->new IllegalArgumentException("Invalid author ID:"+authorId)))
//                .collect(Collectors.toSet());
//    }
}
