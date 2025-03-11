package net.violainedrt.budget.domain.mapper;

import net.violainedrt.budget.application.dto.UserDto;
import net.violainedrt.budget.infrastructure.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring",  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {


    UserDto toUserDto (User userEntity);

    User toUserEntity (UserDto userDto);


}