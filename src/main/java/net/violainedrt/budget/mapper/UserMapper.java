package net.violainedrt.budget.mapper;

import net.violainedrt.budget.dto.UserDto;
import net.violainedrt.budget.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
               user.getId(),
               user.getName(),
               user.getEmail()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail()
        );
    }
}
