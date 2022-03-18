package com.basov.springbootjpa.service;

import com.basov.springbootjpa.entity.FileType;

import java.util.List;

public interface FileTypeService {
    List<FileType> getAllFileTypes();

    FileType getFileTypeById(int id);

    void addOrUpdateFileType(FileType fileType);

    void deleteFileTypeById(int id);
}
