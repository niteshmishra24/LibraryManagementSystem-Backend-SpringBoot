package com.entity.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.manytomany.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    
}
