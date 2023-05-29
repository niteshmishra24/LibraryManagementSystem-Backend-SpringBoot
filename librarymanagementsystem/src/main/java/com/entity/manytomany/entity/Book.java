package com.entity.manytomany.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String publicationYear;

    @ManyToMany
    @JoinTable(name = "books_authors", 
    joinColumns = { @JoinColumn(name = "book_id") }, 
    inverseJoinColumns = {@JoinColumn(name = "author_id") })
    // @JsonManagedReference
    private Set<Author> authors;

    @ManyToMany
    @JoinTable(name = "books_category", 
    joinColumns = { @JoinColumn(name = "book_id") }, 
    inverseJoinColumns = {@JoinColumn(name = "category_id") })
    private Set<Category> categories;

    @OneToMany(mappedBy = "book")
    // @JsonBackReference
    @JsonIgnore
    private List<Loan> loans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Book() {
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public Book(long id, String title, String publicationYear, Set<Author> authors, Set<Category> categories,
            List<Loan> loans) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.authors = authors;
        this.categories = categories;
        this.loans = loans;
    }

    
    
}
