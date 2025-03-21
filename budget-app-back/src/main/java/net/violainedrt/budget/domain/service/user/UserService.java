package net.violainedrt.budget.domain.service.user;

import net.violainedrt.budget.application.dto.user.*;

import java.util.List;


public interface UserService {
    QueryUserDto createUser(CreateUserDto user);
    QueryUserDto getUserByID(Long userId);
    List<QueryUserDto> getAllUsers();
    QueryUserDto updateUser(Long userId, UpdateUserDto user);
    void deleteUser (Long userId);


}
