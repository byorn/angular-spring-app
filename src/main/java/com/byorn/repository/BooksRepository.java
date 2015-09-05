package com.byorn.repository;

import com.byorn.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Byorn on 9/5/2015.
 */
public interface BooksRepository extends CrudRepository<Book,Long> {
}
