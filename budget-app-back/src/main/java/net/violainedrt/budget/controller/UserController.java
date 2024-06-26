package net.violainedrt.budget.controller;


import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.UserDto;
import net.violainedrt.budget.entity.User;
import net.violainedrt.budget.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor //annotation Lombok, génère constructor
@RestController //indique la nature de controller
@RequestMapping("/api/users") //indique que toutes les routes débuterons par ce segment
public class UserController {
    //injection du service userService dans la classe
    private UserService userService;

    //Build Add User REST API
    @PostMapping //annotation, indique que la méthode suivante correspondra à un post
    //Retour = ResponseEntity : une classe fournie par Spring, représente une réponse HTTP.
    //Encapsule un objet de type UserDto
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        //On appelle la méthode createUser du service sur l'objet userDto
        UserDto savedUser = userService.createUser(userDto);
        //On retourne
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Build Get User REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id")Long userId){
        UserDto userDto = userService.getUserByID(userId);
        return ResponseEntity.ok(userDto);
    }

    //Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //Build update User REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDto updatedUser){
        UserDto userDto = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(userDto);
    }

    //Build delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
