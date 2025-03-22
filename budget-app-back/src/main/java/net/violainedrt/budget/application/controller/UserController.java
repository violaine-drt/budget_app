package net.violainedrt.budget.application.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import net.violainedrt.budget.application.dto.user.*;
import net.violainedrt.budget.domain.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;


    @PostMapping
    //Return value  ResponseEntity : http response
    public ResponseEntity<QueryUserDto> createUser(@Valid  @RequestBody CreateUserDto user){

      QueryUserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Build Get User REST API
    @GetMapping("{id}")
    public ResponseEntity<QueryUserDto> getUserById(@PathVariable("id")Long userId){
        QueryUserDto user = userService.getUserByID(userId);
        return ResponseEntity.ok(user);
    }

    //Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<QueryUserDto>> getAllUsers(){
        List<QueryUserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //Build update User REST API
    @PutMapping("{id}")
    public ResponseEntity<QueryUserDto> updateUser(@PathVariable("id") Long userId, @Valid @RequestBody UpdateUserDto user){
        QueryUserDto updatedUser = userService.updateUser(userId, user);
        return ResponseEntity.ok(updatedUser);
    }

    //Build delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
