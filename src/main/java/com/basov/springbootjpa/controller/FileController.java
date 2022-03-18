package com.basov.springbootjpa.controller;

import com.basov.springbootjpa.entity.File;
import com.basov.springbootjpa.exception_handling.NoSuchException;
import com.basov.springbootjpa.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "Рест контроллер для файлов")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/files")
    @ApiOperation("Получение всех файлов")
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/files/{id}")
    @ApiOperation("Получение файла по ID")
    public File getFileById(@PathVariable("id") int id) {
        if (fileService.getFileById(id) == null) {
            throw new NoSuchException("There's no file with ID = " + id);
        }
        return fileService.getFileById(id);
    }

    @PostMapping("/files")
    @ApiOperation("Добавление нового файла")
    public File addNewFile(@RequestBody @Valid File file) {
        fileService.addOrUpdateFile(file);
        return file;
    }

    @PutMapping("/files")
    @ApiOperation("Изменение файла")
    public File updateFile(@RequestBody @Valid File file) {
        fileService.addOrUpdateFile(file);
        return file;
    }

    @DeleteMapping("/files/{id}")
    @ApiOperation("Удаление файла по Id")
    public String deleteFileById(@PathVariable int id) {
        if (fileService.getFileById(id) == null) {
            throw new NoSuchException("There's no file with ID = " + id);
        }
        fileService.deleteFileById(id);
        return "File with ID = " + id + "was deleted!";
    }
}
