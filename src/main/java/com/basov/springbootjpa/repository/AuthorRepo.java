package com.basov.springbootjpa.repository;

import com.basov.springbootjpa.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
