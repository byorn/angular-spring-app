package com.byorn.controller;

import com.byorn.dto.BookDTO;
import com.byorn.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Byorn on 9/5/2015.
 */

@RestController
public class BooksController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private BooksService service;

    @RequestMapping("/books")
    public List<BookDTO> getAllBooks() {
        return service.getAllBooks();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO book) {

        service.updateBook(book);

        return new ResponseEntity<BookDTO>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/books/createNew", method = RequestMethod.POST)
    public ResponseEntity<BookDTO> newBook(@RequestBody BookDTO book) {

        service.createNew(book);

        return new ResponseEntity<BookDTO>(book, HttpStatus.OK);
    }

}
