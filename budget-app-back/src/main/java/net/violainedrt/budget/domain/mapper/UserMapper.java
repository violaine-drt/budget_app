package net.violainedrt.budget.domain.mapper;

import net.violainedrt.budget.application.dto.user.*;
import net.violainedrt.budget.infrastructure.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring",  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {


    QueryUserDto toUserDto(User userEntity);

    User toUserEntity (CreateUserDto createUserDto);

    // Updates existing entity. Ignores null fields
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UpdateUserDto updateUserDto, @MappingTarget User userEntity);
}