package com.yosra.bibliophiles.controller;

import com.yosra.bibliophiles.Repository.BookRepository;
import com.yosra.bibliophiles.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // list
    @GetMapping("/")
    public List<Book> list() {
        return bookRepository.findAll();
    }

    // CRUD
    @PostMapping("/create")
    public Book create(@ModelAttribute Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> read(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id,@ModelAttribute Book book) {
        //get the id
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
