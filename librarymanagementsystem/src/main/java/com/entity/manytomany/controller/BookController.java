package com.entity.manytomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.manytomany.entity.Book;
import com.entity.manytomany.service.BookService;

@RestController
@RequestMapping("/api/")
public class BookController {
    
    @Autowired 
    private BookService bookService;

    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("books/add-book")
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @PutMapping("books/{id}/update-book")
    public void updateBook(@PathVariable("id") long id,@RequestBody Book book){
        bookService.updateBook(book, id);
    }

    @DeleteMapping("books/{id}/delete-book")
    public void deleteBook(@PathVariable("id") long id){
        bookService.deleteBook(id);
    }
}
