package net.violainedrt.budget.domain.mapper;


import jakarta.persistence.EntityNotFoundException;
import net.violainedrt.budget.application.dto.CategoryDto;
import net.violainedrt.budget.infrastructure.entity.*;
import net.violainedrt.budget.infrastructure.repository.UserRepository;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserRepository.class},  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {


    @Mapping(source = "user.id", target = "userId")
    CategoryDto toCategoryDto (Category categoryEntity);

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUserIdToUser")
    Category toCategoryEntity (CategoryDto categoryDto, @Context UserRepository userRepository);


    @Named("mapUserIdToUser")
    default User mapUserIdToUser(Long userId, @Context UserRepository userRepository) {
        if (userId == null) {
            return null;
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur avec l'ID " + userId + " introuvable."));
    }


}

