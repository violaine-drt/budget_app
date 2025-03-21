package net.violainedrt.budget.domain.service.user;

import lombok.RequiredArgsConstructor;
import net.violainedrt.budget.application.dto.user.*;
import net.violainedrt.budget.domain.mapper.UserMapper;
import net.violainedrt.budget.infrastructure.entity.User;
import net.violainedrt.budget.common.exception.ResourceNotFoundException;
import net.violainedrt.budget.infrastructure.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with given ID: " + userId));
    }

    @Override
    @Transactional
    public QueryUserDto createUser(CreateUserDto user) {
        User newUserEntity = userMapper.toUserEntity(user);
        newUserEntity.setLastLogin(LocalDateTime.now());
        User savedUser = userRepository.save(newUserEntity);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public QueryUserDto getUserByID(Long userId) {
        User user = findUserById(userId);
        return userMapper.toUserDto(user);
    }

    @Override
    public List<QueryUserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserDto)
                .toList();
    }

    @Override
    @Transactional
    public QueryUserDto updateUser(Long userId, UpdateUserDto user) {
        User toUpdateUser = findUserById(userId);
        userMapper.updateUserFromDto(user, toUpdateUser);
        User updatedUser = userRepository.save(toUpdateUser);
        return userMapper.toUserDto(updatedUser);

    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        findUserById(userId);
        userRepository.deleteById(userId);
    }
}
