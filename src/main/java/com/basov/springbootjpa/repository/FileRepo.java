package com.basov.springbootjpa.repository;

import com.basov.springbootjpa.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File, Integer> {

}
