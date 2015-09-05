package com.byorn.service;

import com.byorn.dto.BookDTO;
import com.byorn.model.Book;
import com.byorn.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Byorn on 9/5/2015.
 */
@Service
public class BooksService {

    @Autowired
    BooksRepository repo;

    public List<BookDTO> getAllBooks(){

        final List<BookDTO> books = new ArrayList<>();

        repo.findAll().forEach(

                book -> {
                    BookDTO dto = new BookDTO();
                    dto.setId(book.getId().toString());
                    dto.setName(book.getName());
                    books.add(dto);
                }

        );

        return books;

    }


    public void updateBook(BookDTO bookDTO){
        Book book = repo.findOne(Long.valueOf(bookDTO.getId()));
        book.setName(bookDTO.getName());
        repo.save(book);
    }

    public void createNew(BookDTO bookDTO){
        Book book = new Book();
        book.setName(bookDTO.getName());
        repo.save(book);
    }
}
