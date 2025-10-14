package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.exceptions.APIException;
import com.ecommerce.ecommerce.exceptions.ResourceNotFoundException;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("No Categories found!");
        }
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category catergory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (catergory != null) {
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!!");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));

        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
