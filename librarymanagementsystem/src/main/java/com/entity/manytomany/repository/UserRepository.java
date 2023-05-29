package com.entity.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.manytomany.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
