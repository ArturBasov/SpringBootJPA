package com.basov.springbootjpa.service;

import com.basov.springbootjpa.entity.FileType;
import com.basov.springbootjpa.repository.FileTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileTypeServiceImpl implements FileTypeService {

    final
    FileTypeRepo fileTypeRepo;

    public FileTypeServiceImpl(FileTypeRepo fileTypeRepo) {
        this.fileTypeRepo = fileTypeRepo;
    }


    @Override
    public List<FileType> getAllFileTypes() {
        return fileTypeRepo.findAll();
    }

    @Override
    public FileType getFileTypeById(int id) {
        FileType fileType = null;
        Optional<FileType> optionalFileType = fileTypeRepo.findById(id);
        if (optionalFileType.isPresent()) {
            fileType = optionalFileType.get();
        }
        return fileType;
    }

    @Override
    public void addOrUpdateFileType(FileType fileType) {
        fileTypeRepo.save(fileType);
    }

    @Override
    public void deleteFileTypeById(int id) {
        fileTypeRepo.deleteById(id);
    }
}
