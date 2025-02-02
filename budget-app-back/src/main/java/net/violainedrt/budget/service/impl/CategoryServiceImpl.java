package net.violainedrt.budget.service.impl;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.CategoryDto;
import net.violainedrt.budget.entity.Category;
import net.violainedrt.budget.entity.User;
import net.violainedrt.budget.exception.ResourceNotFoundException;
import net.violainedrt.budget.mapper.CategoryMapper;
import net.violainedrt.budget.mapper.UserMapper;
import net.violainedrt.budget.repository.CategoryRepository;
import net.violainedrt.budget.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist with given ID : " + categoryId));
        return CategoryMapper.mapToCategoryDto(category);

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());

    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto updateCategory) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category does not exist with given id: " + categoryId)
        );
        category.setCategoryName(updateCategory.getCategoryName());
        category.setColorCode(updateCategory.getColorCode());
        category.setIsFlagged(updateCategory.getIsFlagged());
        category.setIsDefault(false);
        Category updatedCategoryObj = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategoryObj);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category does not exist with given id: " + categoryId)
        );
        categoryRepository.deleteById(categoryId);
    }
}
