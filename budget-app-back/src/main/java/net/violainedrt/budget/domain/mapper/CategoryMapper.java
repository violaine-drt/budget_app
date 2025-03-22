package net.violainedrt.budget.domain.mapper;


import jakarta.persistence.EntityNotFoundException;
import net.violainedrt.budget.application.dto.category.*;
import net.violainedrt.budget.infrastructure.entity.*;
import net.violainedrt.budget.infrastructure.repository.UserRepository;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserRepository.class},  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {


    @Mapping(source = "user.id", target = "userId")
    QueryCategoryDto toCategoryDto (Category categoryEntity);

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUserIdToUser")
    Category toCategoryEntity (CreateCategoryDto createCategoryDto, @Context UserRepository userRepository);

    // Updates existing entity. Ignores null fields
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromDto(UpdateCategoryDto updateCategoryDto, @MappingTarget Category categoryEntity);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(Long userId, @Context UserRepository userRepository) {
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur avec l'ID " + userId + " introuvable."));
    }


}



