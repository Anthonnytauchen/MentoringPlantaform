package project.mentoringplantaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.mentoringplantaform.dto.UserDto;

import project.mentoringplantaform.service.UserService;

@Controller("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto.UserResponseDTO> createdUser(@RequestBody UserDto.UserCreateDTO user){
        UserDto.UserResponseDTO createdUser = userService.createdUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
