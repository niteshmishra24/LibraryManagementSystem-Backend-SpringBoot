package com.entity.manytomany.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.manytomany.entity.Category;
import com.entity.manytomany.repository.CategoryRepository;



@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(long id,Category category){
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if(existingCategory!=null){
            existingCategory.setName(category.getName());
            categoryRepository.save(existingCategory);
        }
    }

    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }
}
