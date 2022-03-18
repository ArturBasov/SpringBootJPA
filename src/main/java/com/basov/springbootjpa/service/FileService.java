package com.basov.springbootjpa.service;

import com.basov.springbootjpa.entity.File;

import java.util.List;

public interface FileService {
    List<File> getAllFiles();

    File getFileById(int id);

    File addOrUpdateFile(File file);

    void deleteFileById(int id);
}
