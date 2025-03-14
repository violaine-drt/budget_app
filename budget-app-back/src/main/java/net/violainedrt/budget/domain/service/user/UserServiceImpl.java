package net.violainedrt.budget.domain.service.user;

import lombok.RequiredArgsConstructor;
import net.violainedrt.budget.application.dto.UserDto;
import net.violainedrt.budget.domain.mapper.UserMapper;
import net.violainedrt.budget.infrastructure.entity.User;
import net.violainedrt.budget.common.exception.ResourceNotFoundException;
import net.violainedrt.budget.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        UserDto userToSave = UserDto.builder()
                .id(userDto.id())
                .name(userDto.name())
                .email(userDto.email())
                .password(userDto.password())
                .userBalance(userDto.userBalance())
                .lastLogin(LocalDateTime.now())
                .build();

        User user = userMapper.toUserEntity(userToSave);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public UserDto getUserByID(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User does not exist with given ID : "+ userId));

        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> userMapper.toUserDto(user))
                .toList();
    }

    @Override
    @Transactional
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with given id: "+userId)
        );
        user.setName(updatedUser.name());
        user.setEmail(updatedUser.email());

        User updatedUserObj = userRepository.save(user);
        return userMapper.toUserDto(updatedUserObj);

    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with given id: "+userId)
        );
        userRepository.deleteById(userId);
    }
}
