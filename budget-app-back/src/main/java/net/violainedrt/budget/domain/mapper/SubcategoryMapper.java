package net.violainedrt.budget.domain.mapper;

import jakarta.persistence.EntityNotFoundException;
import net.violainedrt.budget.application.dto.subcategory.*;
import net.violainedrt.budget.infrastructure.entity.*;
import net.violainedrt.budget.infrastructure.repository.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CategoryRepository.class},  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubcategoryMapper {


    @Mapping(source = "category.id", target = "categoryId")
    QuerySubcategoryDto toSubcategoryDto (Subcategory subcategoryEntity);

    @Mapping(source = "categoryId", target = "category", qualifiedByName = "mapCategoryIdToCategory")
    Subcategory toSubcategoryEntity (CreateSubcategoryDto createSubcategoryDto, @Context CategoryRepository categoryRepository);

    // 🔹 Met à jour une entité Subcategory existante avec un DTO de mise à jour. Ignore les champs nuls
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSubcategoryFromDto(UpdateSubcategoryDto updateSubcategoryDto, @MappingTarget Subcategory subcategoryEntity);

    @Named("mapCategoryIdToCategory")
    default Category mapCategoryIdToCategory (Long categoryId, @Context CategoryRepository categoryRepository) {
        if (categoryId == null) {
            return null;
        }
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Categorie avec l'ID " + categoryId + " introuvable."));
    }


}
