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

import com.entity.manytomany.entity.Category;
import com.entity.manytomany.service.CategoryService;


@RestController
@RequestMapping("/api/")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("category")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("category/{id}")
    public Category getCategoryById(@PathVariable("id") long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("category/add-category")
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @PutMapping("category/update-category/{id}")
    public void updateCategory(@PathVariable("id") long id,@RequestBody Category category){
        categoryService.updateCategory(id, category);
    }

    @DeleteMapping("category/delete-category/{id}")
    public void deleteCategory(@PathVariable("id") long id){
        categoryService.deleteCategory(id);
    }
}