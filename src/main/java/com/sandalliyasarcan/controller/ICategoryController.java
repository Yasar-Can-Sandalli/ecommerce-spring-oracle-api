package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.dto.category.CategoryDTO;

import java.util.List;

public interface ICategoryController {
    CategoryDTO saveCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories();
    CategoryDTO  getCategoryById(Integer categoryId);
    boolean  deleteCategoryById(Integer categoryId);
    CategoryDTO updateCategoryById(Integer id ,CategoryDTO categoryDTO);
    CategoryDTO getCategoryByName(String categoryName);

}
