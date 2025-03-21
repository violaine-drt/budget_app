package net.violainedrt.budget.domain.service.category;

import net.violainedrt.budget.application.dto.category.*;

import java.util.List;

public interface CategoryService {
    //@todo Devra valider qu'une catégorie appartient bien à une sous-catégroie (méthode qui sera appellée ensuite dans le GoalService, TransactionService)

    QueryCategoryDto createCategory (CreateCategoryDto category);
    QueryCategoryDto getCategoryById(Long categoryId);
    List<QueryCategoryDto> getAllCategories();
    QueryCategoryDto updateCategory(Long categoryId, UpdateCategoryDto category);
    void deleteCategory(Long categoryId);
}
