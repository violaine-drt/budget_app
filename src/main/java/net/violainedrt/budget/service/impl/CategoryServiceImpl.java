package net.violainedrt.budget.service.impl;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.CategoryDto;
import net.violainedrt.budget.entity.Category;
import net.violainedrt.budget.mapper.CategoryMapper;
import net.violainedrt.budget.repository.CategoryRepository;
import net.violainedrt.budget.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
