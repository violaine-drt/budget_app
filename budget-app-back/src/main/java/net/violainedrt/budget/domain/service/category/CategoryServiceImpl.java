package net.violainedrt.budget.domain.service.category;

import lombok.RequiredArgsConstructor;
import net.violainedrt.budget.application.dto.CategoryDto;
import net.violainedrt.budget.domain.mapper.*;
import net.violainedrt.budget.infrastructure.entity.Category;
import net.violainedrt.budget.common.exception.ResourceNotFoundException;
import net.violainedrt.budget.infrastructure.repository.CategoryRepository;
import net.violainedrt.budget.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryDto createCategory(CategoryDto categoryDto) {
        CategoryDto categoryToSave = CategoryDto.builder()
                .id(categoryDto.id())
                .name(categoryDto.name())
                .colorCode(categoryDto.colorCode())
                .isDefault(categoryDto.isDefault())
                .isFlagged(categoryDto.isFlagged())
                .userId(categoryDto.userId())
                .build();
        Category category = categoryMapper.toCategoryEntity(categoryToSave, userRepository);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with given ID : " + categoryId));
        return categoryMapper.toCategoryDto(category);

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> categoryMapper.toCategoryDto(category)).toList();

    }

    @Override
    @Transactional
    public CategoryDto updateCategory(Long categoryId, CategoryDto updateCategory) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with given id: " + categoryId));
        category.setName(updateCategory.name());
        category.setColorCode(updateCategory.colorCode());
        category.setIsDefault(updateCategory.isDefault());
        category.setIsFlagged(updateCategory.isFlagged());
        Category updatedCategoryObj = categoryRepository.save(category);
        return categoryMapper.toCategoryDto(updatedCategoryObj);
    }

    @Override
    @Transactional
    public void deleteCategory(Long categoryId) {
        categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with given id: " + categoryId));
        categoryRepository.deleteById(categoryId);
    }
}
