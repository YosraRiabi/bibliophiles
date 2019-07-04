package com.yosra.bibliophiles.service;

import com.yosra.bibliophiles.Repository.BookRepository;
import com.yosra.bibliophiles.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public Book save (Book link){
        return bookRepository.save(link);
    }
}
