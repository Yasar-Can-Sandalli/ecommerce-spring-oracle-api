package com.sandalliyasarcan.controller.impl;

import com.sandalliyasarcan.controller.ICategoryController;
import com.sandalliyasarcan.dto.category.CategoryDTO;
import com.sandalliyasarcan.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/category/")
public class CategoryControllerImpl implements ICategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Override
    @PostMapping(path = "/save")
    public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }

    @Override
    @GetMapping(path = "/list")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public CategoryDTO getCategoryById(@PathVariable(name = "id" , required = true) Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteCategoryById(@PathVariable(name = "id" , required = true) Integer categoryId) {
        return categoryService.deleteCategoryById(categoryId);
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public CategoryDTO updateCategoryById(@PathVariable(name = "id") Integer id, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategoryById(id,categoryDTO);
    }

    @Override
    @GetMapping(path = "/findByName/{name}")
    public CategoryDTO getCategoryByName(@PathVariable(name = "name" ,required = true) String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }
}
