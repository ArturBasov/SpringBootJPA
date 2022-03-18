package com.basov.springbootjpa.controller;

import com.basov.springbootjpa.entity.Author;
import com.basov.springbootjpa.entity.FileType;
import com.basov.springbootjpa.exception_handling.NoSuchException;
import com.basov.springbootjpa.service.AuthorService;
import com.basov.springbootjpa.service.FileTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = "Рест контроллер взаимодействия типов файлов и авторов")
public class AuthorTypesController {

    private final AuthorService authorService;

    private final FileTypeService fileTypeService;

    public AuthorTypesController(AuthorService authorService, FileTypeService fileTypeService) {
        this.authorService = authorService;
        this.fileTypeService = fileTypeService;
    }

    @PutMapping("/filetypes/{fileTypeId}/authors/{authorId}")
    @ApiOperation("Добавление типа файла по ID к автору по ID")
    public Author addFileTypeToAuthor(@PathVariable("fileTypeId") int fileTypeId,
                                      @PathVariable("authorId") int authorId) {
        FileType fileType = fileTypeService.getFileTypeById(fileTypeId);
        if (fileType == null) {
            throw new NoSuchException("There's no file type with ID = " + fileTypeId);
        }
        Author author = authorService.getAuthorById(authorId);
        if (author == null) {
            throw new NoSuchException("There's no author with ID = " + authorId);
        }

        author.addFileType(fileType);
        authorService.addOrUpdateAuthor(author);

        return author;
    }

    @PutMapping("/authors/{authorId}/filetypes/{fileTypeId}")
    @ApiOperation("Добавление автора по ID к типу файла по ID")
    public FileType addAuthorToFileType(@PathVariable("authorId") int authorId,
                                        @PathVariable("fileTypeId") int fileTypeId) {

        Author author = authorService.getAuthorById(authorId);
        if (author == null) {
            throw new NoSuchException("There's no author with ID = " + authorId);
        }
        FileType fileType = fileTypeService.getFileTypeById(fileTypeId);
        if (fileType == null) {
            throw new NoSuchException("There's no file type with ID = " + fileTypeId);
        }

        fileType.addAuthor(author);
        fileTypeService.addOrUpdateFileType(fileType);

        return fileType;
    }
}
