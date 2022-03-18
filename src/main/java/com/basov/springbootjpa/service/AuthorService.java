package com.basov.springbootjpa.service;

import com.basov.springbootjpa.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(int id);

    void addOrUpdateAuthor(Author author);

    void deleteAuthorById(int id);
}
