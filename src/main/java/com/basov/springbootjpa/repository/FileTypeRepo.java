package com.basov.springbootjpa.repository;

import com.basov.springbootjpa.entity.FileType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileTypeRepo extends JpaRepository<FileType, Integer> {

}
