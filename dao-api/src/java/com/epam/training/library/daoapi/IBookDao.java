package com.epam.training.library.daoapi;

import java.util.List;

import com.epam.training.library.datamodel.Book;

public interface IBookDao {

    Book get(Long id);

    Long insert(Book entity);

    void update(Book entity);

    void delete(Long id);

    List<Book> getAll();

}
