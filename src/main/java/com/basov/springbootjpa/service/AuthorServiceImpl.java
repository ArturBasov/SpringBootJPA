package com.basov.springbootjpa.service;

import com.basov.springbootjpa.entity.Author;
import com.basov.springbootjpa.repository.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }


    @Override
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        Author author = null;
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if (optionalAuthor.isPresent()) author = optionalAuthor.get();
        return author;
    }

    @Override
    public void addOrUpdateAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public void deleteAuthorById(int id) {
        authorRepo.deleteById(id);
    }
}