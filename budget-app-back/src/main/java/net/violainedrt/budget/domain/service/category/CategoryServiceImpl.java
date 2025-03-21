package net.violainedrt.budget.domain.service.category;

import lombok.RequiredArgsConstructor;
import net.violainedrt.budget.application.dto.category.*;
import net.violainedrt.budget.domain.mapper.*;
import net.violainedrt.budget.domain.service.user.UserServiceImpl;
import net.violainedrt.budget.infrastructure.entity.Category;
import net.violainedrt.budget.common.exception.ResourceNotFoundException;
import net.violainedrt.budget.infrastructure.repository.CategoryRepository;
import net.violainedrt.budget.infrastructure.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;


    //@todo : ajouter un système de logs
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist with given ID: " + categoryId));
    }

    @Override
    @Transactional
    public QueryCategoryDto createCategory(CreateCategoryDto category) {
        Category newCategoryEntity = categoryMapper.toCategoryEntity(category, userRepository);
        Category savedCategory = categoryRepository.save(newCategoryEntity);
        return categoryMapper.toCategoryDto(savedCategory);
    }

    @Override
    public QueryCategoryDto getCategoryById(Long categoryId) {
        Category category = findCategoryById(categoryId);
        return categoryMapper.toCategoryDto(category);

    }

    @Override
    public List<QueryCategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryDto).toList();

    }

    @Override
    @Transactional
    public QueryCategoryDto updateCategory(Long categoryId, UpdateCategoryDto category) {
        Category toUpdateCategory = findCategoryById(categoryId);
        categoryMapper.updateCategoryFromDto(category, toUpdateCategory);
        Category updatedCategory = categoryRepository.save(toUpdateCategory);
        return categoryMapper.toCategoryDto(updatedCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(Long categoryId) {
       findCategoryById(categoryId);
        categoryRepository.deleteById(categoryId);
    }
}
