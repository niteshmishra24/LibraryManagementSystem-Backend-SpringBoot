package com.entity.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.manytomany.entity.Author;
import com.entity.manytomany.repository.AuthorRepository;


@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(long id){
        return authorRepository.findById(id).orElse(null);
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(long id){
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Author author,long id){
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        if(existingAuthor != null){
            existingAuthor.setName(author.getName());
            authorRepository.save(existingAuthor);
        }
    }
}

