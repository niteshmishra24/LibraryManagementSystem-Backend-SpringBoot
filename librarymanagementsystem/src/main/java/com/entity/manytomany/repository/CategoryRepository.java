package com.entity.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.manytomany.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
