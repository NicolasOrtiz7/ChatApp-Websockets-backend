package com.nicolasortiz.chatapp.controller;

import com.nicolasortiz.chatapp.exception.ExistingUserException;
import com.nicolasortiz.chatapp.exception.UserNotFoundException;
import com.nicolasortiz.chatapp.model.dto.ResponseDto;
import com.nicolasortiz.chatapp.model.dto.UserDto;
import com.nicolasortiz.chatapp.model.entity.User;
import com.nicolasortiz.chatapp.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final IUserService userService;


    @GetMapping
    public ResponseEntity<ResponseDto> findAll(){
        List<UserDto> usersDtoList = userService.findAllUsers();

        return ResponseEntity.ok(ResponseDto.builder()
                .status(HttpStatus.OK)
                .message("Lista de todos los usuarios")
                .response(usersDtoList)
                .build());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long userId) throws UserNotFoundException {
        UserDto userDto = userService.findUserById(userId);
        return ResponseEntity.ok(ResponseDto.builder()
                        .status(HttpStatus.OK)
                        .message("Usuario encontrado")
                        .response(userDto)
                .build());
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveUser(@RequestBody @Valid User user)
            throws ExistingUserException {
        UserDto userDto = userService.saveUser(user);
        return ResponseEntity.ok(ResponseDto.builder()
                        .response(HttpStatus.CREATED)
                        .message("Usuario creado con éxito")
                        .response(userDto)
                .build());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Long userId){
        UserDto userDto = userService.deleteUserById(userId);
        return ResponseEntity.ok(ResponseDto.builder()
                .response(HttpStatus.OK)
                .message("Usuario eliminado con éxito")
                .response(userDto)
                .build());
    }

}
