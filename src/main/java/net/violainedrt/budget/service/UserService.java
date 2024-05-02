package net.violainedrt.budget.service;

import net.violainedrt.budget.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByID(Long userId);

}
