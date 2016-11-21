package com.epam.training.library.daoapi;

import java.util.List;

import com.epam.training.library.datamodel.Author;
import com.epam.training.library.datamodel.AuthorWithCountry;

public interface IAuthorDao {

    AuthorWithCountry getWithCountry(Long id);

    void save(Author entity);

    void delete(Long id);

    List<Author> getAll();

}
