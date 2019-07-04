package com.yosra.bibliophiles.controller;

import com.yosra.bibliophiles.Repository.BookRepository;
import com.yosra.bibliophiles.Repository.CommentRepository;
import com.yosra.bibliophiles.domain.Book;
import com.yosra.bibliophiles.domain.Comment;
import com.yosra.bibliophiles.domain.Link;
import com.yosra.bibliophiles.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;
    private CommentRepository commentRepository;

    public BookController(BookService bookService, CommentRepository commentRepository) {
        this.bookService = bookService;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/book")
    public String list(Model model){
        model.addAttribute("books",bookService.findAll());
        return "link/list";
    }

    @GetMapping("/book/{id}")
    public String read(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            Book currentBook = book.get();
            Comment comment = new Comment();
            comment.setBook(currentBook);
            model.addAttribute("comment", comment);
            model.addAttribute("book", currentBook);
            model.addAttribute("success", model.containsAttribute("success"));
            return "book/book";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/book/exchange")
    public String newLinkForm(Model model) {
        model.addAttribute("book",new Book());
        return "book/exchange";
    }
    @PostMapping("/book/exchange")
    public String createBook(@Valid Book book, BindingResult bindingResult, Model
            model, RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            logger.info("Validation errors were found while submitting a new book.");
            model.addAttribute("book",book);
            return "book/exchange";
        } else {
            // save our link
            bookService.save(book);
            logger.info("New link was saved successfully");
            redirectAttributes
                    .addAttribute("id",book.getId())
                    .addFlashAttribute("success",true);
            return "redirect:/book/{id}";
        }

    }

    @PostMapping("/book/comments")
    public String addComment(@Valid Comment comment, BindingResult bindingResult, Model
            model, RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            logger.info("Something went wrong.");
        } else {
            logger.info("New Comment Saved!");
            commentRepository.save(comment);
        }
        return "redirect:/book/" + comment.getBook().getId();
    }
}
