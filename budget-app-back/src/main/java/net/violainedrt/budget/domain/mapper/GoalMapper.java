package net.violainedrt.budget.domain.mapper;

import jakarta.persistence.EntityNotFoundException;
import net.violainedrt.budget.application.dto.goal.*;
import net.violainedrt.budget.infrastructure.entity.*;
import net.violainedrt.budget.infrastructure.repository.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserRepository.class, CategoryRepository.class, SubcategoryRepository.class},  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GoalMapper {


    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "subcategory.id", target = "subcategoryId")
    QueryGoalDto toGoalDto (Goal goalEntity);

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUserIdToUser")
    @Mapping(source = "categoryId", target = "category", qualifiedByName = "mapCategoryIdToCategory")
    @Mapping(source = "subcategoryId", target = "subcategory", qualifiedByName = "mapSubcategoryIdToSubcategory")
    Goal toGoalEntity (CreateGoalDto createGoalDto, @Context UserRepository userRepository, @Context CategoryRepository categoryRepository, @Context SubcategoryRepository subcategoryRepository);

    // 🔹 Met à jour une entité Goal existante avec un DTO de mise à jour. Ignore les champs nuls
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGoalFromDto (UpdateGoalDto updateGoalDto, @MappingTarget Goal goalEntity);


    @Named("mapUserIdToUser")
    default User mapUserIdToUser(Long userId, @Context UserRepository userRepository) {
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur avec l'ID " + userId + " introuvable."));
    }

    @Named("mapCategoryIdToCategory")
    default Category mapCategoryIdToCategory (Long categoryId, @Context CategoryRepository categoryRepository) {
        if (categoryId == null) {
            return null;
        }
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Categorie avec l'ID " + categoryId + " introuvable."));
    }

    @Named("mapSubcategoryIdToSubcategory")
    default Subcategory mapSubcategoryIdToSubcategory (Long subcategoryId, @Context SubcategoryRepository subcategoryRepository) {
        if (subcategoryId == null) {
            return null;
        }
        return subcategoryRepository.findById(subcategoryId)
                .orElseThrow(() -> new EntityNotFoundException("Sous-categorie avec l'ID " + subcategoryId + " introuvable."));
    }
}
