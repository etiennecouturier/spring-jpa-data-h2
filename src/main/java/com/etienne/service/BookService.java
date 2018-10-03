package com.etienne.service;

import com.etienne.dao.BookRepository;
import com.etienne.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return toList(bookRepository.findAll());
    }

    public List<String> filterBooks() {
        return toList(bookRepository.findAll())
                .stream()
                .filter(book -> book.getPrice() > 500.0)
                .map(Book::getName)
                .collect(Collectors.toList());
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void saveAll(List<Book> books) {
        bookRepository.saveAll(books);
    }

    private static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

}
