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

import com.entity.manytomany.entity.Author;
import com.entity.manytomany.service.AuthorService;


@RestController
@RequestMapping("/api/")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;

    @GetMapping("authors")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("authors/{id}")
    public Author getAuthorById(@PathVariable("id") long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("authors/add-author")
    public void createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
    }

    @PutMapping("authors/update-author/{id}")
    public void updateAuthor(@RequestBody Author author,@PathVariable("id") long id){
        authorService.updateAuthor(author, id);
    }

    @DeleteMapping("authors/delete-author/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        authorService.deleteAuthor(id);
    }
}
