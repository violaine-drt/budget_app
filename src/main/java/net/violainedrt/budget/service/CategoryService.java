package net.violainedrt.budget.service;

import net.violainedrt.budget.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory (CategoryDto categoryDto);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long categoryId, CategoryDto updateCategory);

    void deleteCategory(Long categoryId);
}
