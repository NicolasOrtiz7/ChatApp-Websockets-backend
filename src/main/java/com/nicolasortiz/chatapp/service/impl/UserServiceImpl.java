package com.nicolasortiz.chatapp.service.impl;

import com.nicolasortiz.chatapp.model.dto.UserDto;
import com.nicolasortiz.chatapp.model.entity.User;
import com.nicolasortiz.chatapp.exception.ExistingUserException;
import com.nicolasortiz.chatapp.exception.UserNotFoundException;
import com.nicolasortiz.chatapp.model.mapper.UserMapper;
import com.nicolasortiz.chatapp.repository.IUserRepository;
import com.nicolasortiz.chatapp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public List<UserDto> findAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper.INSTANCE::userToDto).toList();
    }

    @Override
    public UserDto findUserById(Long userId) throws UserNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("Usuario no encontrado"));

        return UserMapper.INSTANCE.userToDto(user);
    }


    @Override
    public void saveUser(User user) throws ExistingUserException{
        Optional<User> userFound = userRepository
                .findByUsernameOrEmail(user.getUsername(), user.getEmail());

        if (userFound.isPresent())
            throw new ExistingUserException("Ya existe un usuario con ese email o username");
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) throws UserNotFoundException{
        User userDeleted = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("Usuario no encontrado"));
        userRepository.deleteById(userId);
    }
}
