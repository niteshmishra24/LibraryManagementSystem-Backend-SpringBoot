package com.entity.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.manytomany.entity.Book;
import com.entity.manytomany.entity.Loan;
import com.entity.manytomany.entity.User;
import com.entity.manytomany.repository.BookRepository;
import com.entity.manytomany.repository.LoanRepository;
import com.entity.manytomany.repository.UserRepository;

@Service
public class LoanService {
    
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    public void borrowBook(Loan loan,long userId,long bookId){
        Book book = bookRepository.findById(bookId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if(user != null && book != null){
            loan.setUser(user);
            loan.setBook(book);
            book.getLoans().add(loan);
            user.getLoans().add(loan);
            loanRepository.save(loan);
        }
    }

    public void returnBook(long loanId) {
        Loan loan = loanRepository.findById(loanId).orElse(null);
        if (loan != null) {
            Book book = loan.getBook();
            User user = loan.getUser();

            book.getLoans().remove(loan);
            user.getLoans().remove(loan);

            loanRepository.deleteById(loanId);
        }
    }
}
