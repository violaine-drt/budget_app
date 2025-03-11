package net.violainedrt.budget.domain.service.user;

import net.violainedrt.budget.application.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByID(Long userId);

    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser (Long userId);


}
