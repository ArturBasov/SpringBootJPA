package com.basov.springbootjpa.controller;

import com.basov.springbootjpa.entity.FileType;
import com.basov.springbootjpa.exception_handling.NoSuchException;
import com.basov.springbootjpa.service.FileTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "Рест контроллер для типов файлов")
public class FileTypeController {

    private final FileTypeService fileTypeService;

    public FileTypeController(FileTypeService fileTypeService) {
        this.fileTypeService = fileTypeService;
    }

    @GetMapping("/filetypes")
    @ApiOperation("Получение всех типов файлов")
    public List<FileType> getAllFileTypes() {
        return fileTypeService.getAllFileTypes();
    }

    @GetMapping("/filetypes/{id}")
    @ApiOperation("Получение типа файла по ID")
    public FileType getFileTypeById(@PathVariable("id") int id) {
        if (fileTypeService.getFileTypeById(id) == null) {
            throw new NoSuchException("There's no file type with ID = " + id);
        }
        return fileTypeService.getFileTypeById(id);
    }

    @PostMapping("/filetypes")
    @ApiOperation("Добавление нового типа файла")
    public FileType addFileType(@RequestBody @Valid FileType fileType) {
        fileTypeService.addOrUpdateFileType(fileType);
        return fileType;
    }

    @PutMapping("/filetypes")
    @ApiOperation("Изменение типа файла")
    public FileType updateFileType(@RequestBody @Valid FileType fileType) {
        fileTypeService.addOrUpdateFileType(fileType);
        return fileType;
    }

    @DeleteMapping("/filetypes/{id}")
    @ApiOperation("Удаление типа файла по ID")
    public String deleteFileTypeById(@PathVariable("id") int id) {
        if (fileTypeService.getFileTypeById(id) == null) {
            throw new NoSuchException("There's no file with ID = " + id);
        }
        fileTypeService.deleteFileTypeById(id);
        return "FileType with ID = " + id + " was deleted!";
    }
}
