package net.violainedrt.budget.mapper;

import net.violainedrt.budget.dto.CategoryDto;
import net.violainedrt.budget.entity.Category;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getCategoryName(),
                category.getColorCode(),
                category.getIsFlagged(),
                category.getIsDefault(),
                category.getUser(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }

    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.getId(),
                categoryDto.getCategoryName(),
                categoryDto.getColorCode(),
                categoryDto.getIsFlagged(),
                categoryDto.getIsDefault(),
                categoryDto.getUser(),
                categoryDto.getCreatedAt(),
                categoryDto.getUpdatedAt()
        );
    }
}
