package com.basov.springbootjpa.service;

import com.basov.springbootjpa.entity.File;
import com.basov.springbootjpa.repository.FileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService{

    final
    FileRepo fileRepo;

    public FileServiceImpl(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    public List<File> getAllFiles() {
        return fileRepo.findAll();
    }

    @Override
    public File getFileById(int id) {
        File file = null;
        Optional<File> optionalFile = fileRepo.findById(id);
        if (optionalFile.isPresent()) {
            file = optionalFile.get();
        }
        return file;
    }

    @Override
    public File addOrUpdateFile(File file) {
        fileRepo.save(file);
        return file;
    }

    @Override
    public void deleteFileById(int id) {
        fileRepo.deleteById(id);
    }
}
