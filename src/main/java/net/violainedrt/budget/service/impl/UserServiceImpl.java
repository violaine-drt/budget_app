package net.violainedrt.budget.service.impl;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.UserDto;
import net.violainedrt.budget.entity.User;
import net.violainedrt.budget.exception.ResourceNotFoundException;
import net.violainedrt.budget.mapper.UserMapper;
import net.violainedrt.budget.repository.UserRepository;
import net.violainedrt.budget.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserByID(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User does not exist with given ID : "+ userId));

        return UserMapper.mapToUserDto(user);
    }
}
