package com.basov.springbootjpa.controller;

import com.basov.springbootjpa.entity.Author;
import com.basov.springbootjpa.exception_handling.NoSuchException;
import com.basov.springbootjpa.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "Рест контроллер для авторов")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    @ApiOperation("Получение всех авторов")
    public List<Author> getAllAuthors() {
        List<Author> authorList = authorService.getAllAuthors();
        return authorList;
    }

    @GetMapping("/authors/{id}")
    @ApiOperation("Получение автора по ID")
    public Author getAuthorById(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            throw new NoSuchException("There's no author this ID = " + id);
        }
        return author;
    }

    @PostMapping("/authors")
    @ApiOperation("Добавление нового автора")
    public Author addNewAuthor(@RequestBody @Valid Author author) {
        authorService.addOrUpdateAuthor(author);
        return author;
    }

    @PutMapping("/authors")
    @ApiOperation("Изменение автора")
    public Author updateAuthor(@RequestBody @Valid Author author) {
        authorService.addOrUpdateAuthor(author);
        return author;
    }

    @DeleteMapping("/authors/{id}")
    @ApiOperation("Удаление автора по ID")
    public String deleteAuthorById(@PathVariable("id") int id) {
        if (authorService.getAuthorById(id) == null) {
            throw new NoSuchException("There's no author with ID = " + id);
        }
        authorService.deleteAuthorById(id);
        return "Author with id = " + id + " was deleted";
    }
}
