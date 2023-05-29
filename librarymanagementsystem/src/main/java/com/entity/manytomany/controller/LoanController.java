package com.entity.manytomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.manytomany.entity.Loan;
import com.entity.manytomany.repository.LoanRepository;
import com.entity.manytomany.service.LoanService;

@RestController
@RequestMapping("/api/")
public class LoanController {
    
    @Autowired
    private LoanService loanService;

    @GetMapping("loans")
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    @PostMapping("loans/{userId}/user/{bookId}/book")
    public void borrowBook(@RequestBody Loan loan,@PathVariable("userId") long userId,@PathVariable("bookId") long bookId){
        loanService.borrowBook(loan, userId, bookId);
    }

    @DeleteMapping("loans/{id}/returnBook")
    public void returnBook(@PathVariable("id") long id){
        loanService.returnBook(id);
    }
}
