package net.violainedrt.budget.service.impl;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.UserDto;
import net.violainedrt.budget.entity.User;
import net.violainedrt.budget.exception.ResourceNotFoundException;
import net.violainedrt.budget.mapper.UserMapper;
import net.violainedrt.budget.repository.UserRepository;
import net.violainedrt.budget.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with given id: "+userId)
        );
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);

    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with given id: "+userId)
        );
        userRepository.deleteById(userId);
    }
}
