package com.nicolasortiz.chatapp.service;

import com.nicolasortiz.chatapp.exception.ExistingUserException;
import com.nicolasortiz.chatapp.exception.UserNotFoundException;
import com.nicolasortiz.chatapp.model.dto.UserDto;
import com.nicolasortiz.chatapp.model.entity.User;

import java.util.List;

public interface IUserService {

    List<UserDto> findAllUsers();

    UserDto findUserById(Long userId) throws UserNotFoundException;

    void saveUser(User user) throws ExistingUserException;

    void deleteUserById(Long userId) throws UserNotFoundException;

}
