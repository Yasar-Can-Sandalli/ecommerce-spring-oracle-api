package com.sandalliyasarcan.services;

import com.sandalliyasarcan.dto.category.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    CategoryDTO saveCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories();
    CategoryDTO  getCategoryById(Integer categoryId);
    boolean  deleteCategoryById(Integer categoryId);
    CategoryDTO updateCategoryById(Integer id ,CategoryDTO categoryDTO);
    CategoryDTO getCategoryByName(String categoryName);
}
