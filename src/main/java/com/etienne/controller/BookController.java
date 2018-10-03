package com.etienne.controller;

import com.etienne.model.Book;
import com.etienne.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/books")
    public List<Book> books() {
        return bookService.findAllBooks();
    }

    @GetMapping("/filter")
    public List<String> filterBooks() {
        return bookService.filterBooks();
    }

    @PostMapping("/save")
    public void save(@RequestBody Book book) {
        bookService.save(book);
    }

    @PostMapping("/saveAll")
    public void saveAll(@RequestBody List<Book> books) {
        bookService.saveAll(books);
    }

}
