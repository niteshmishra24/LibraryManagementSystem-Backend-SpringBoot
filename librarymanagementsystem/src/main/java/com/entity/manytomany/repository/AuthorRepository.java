package com.entity.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.manytomany.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    
}
