package com.entity.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.manytomany.entity.Book;
import com.entity.manytomany.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book, long id){
        Book existingBook = bookRepository.findById(id).orElse(null);
        if(existingBook!=null){
            existingBook.setTitle(book.getTitle());
            existingBook.setPublicationYear(book.getPublicationYear());
            bookRepository.save(existingBook);
        }
    }

    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
}
