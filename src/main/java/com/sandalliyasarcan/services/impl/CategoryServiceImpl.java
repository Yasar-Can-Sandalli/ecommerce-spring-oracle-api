package com.sandalliyasarcan.services.impl;

import com.sandalliyasarcan.dto.category.CategoryDTO;
import com.sandalliyasarcan.entities.Category;
import com.sandalliyasarcan.repository.CategoryRepository;
import com.sandalliyasarcan.services.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        categoryRepository.save(category);
        CategoryDTO response = new CategoryDTO();
        BeanUtils.copyProperties(category, response);
        return response;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> dtoCategories = new ArrayList<>();

        for (Category dBcategory : categoryRepository.findAll()) {
            CategoryDTO dtoCategory = new CategoryDTO();
            BeanUtils.copyProperties(dBcategory, dtoCategory);
            dtoCategories.add(dtoCategory);
        }
        return dtoCategories;


    }

    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            CategoryDTO dtoCategory = new CategoryDTO();
            BeanUtils.copyProperties(category.get(), dtoCategory);
            return dtoCategory;
        }
        return null;
    }

    @Override
    public boolean deleteCategoryById(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
            System.out.println("Category deleted successfully");
            return true;
        }else{
            System.out.println("Category not found");
            return false;
        }
    }

    @Override
    public CategoryDTO updateCategoryById(Integer id, CategoryDTO categoryDTO) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category dbCategory = category.get();
            dbCategory.setCategoryName(categoryDTO.getCategoryName());
            Category updatedCategory = categoryRepository.save(dbCategory);
            CategoryDTO response = new CategoryDTO();
//            response.setCategoryId(updatedCategory.getCategoryId());
//            response.setCategoryName(updatedCategory.getCategoryName());
            BeanUtils.copyProperties(updatedCategory, response);

            return response;
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }


    public CategoryDTO getCategoryByName(String categoryName) {
    Category category = categoryRepository.getCategoryByName(categoryName);
    
    // Handle if category is null
    if (category == null) {
        throw new RuntimeException("Category not found with name: " + categoryName);
    }

    CategoryDTO dtoCategory = new CategoryDTO();
    dtoCategory.setCategoryId(category.getCategoryId());
    dtoCategory.setCategoryName(category.getCategoryName());
    return dtoCategory;
}

}