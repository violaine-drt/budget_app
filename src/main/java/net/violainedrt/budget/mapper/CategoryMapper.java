package net.violainedrt.budget.mapper;

import net.violainedrt.budget.dto.CategoryDto;
import net.violainedrt.budget.entity.Category;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getParent(),
                category.getChildren(),
                category.getTransactions(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }

    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getParent(),
                categoryDto.getChildren(),
                categoryDto.getTransactions(),
                categoryDto.getCreatedAt(),
                categoryDto.getUpdatedAt()
        );
    }
}
