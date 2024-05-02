package net.violainedrt.budget.service;

import net.violainedrt.budget.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByID(Long userId);

    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser (Long userId);


}
