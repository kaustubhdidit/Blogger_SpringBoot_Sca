package com.scaler.blogapp.users;

import com.scaler.blogapp.users.dtos.CreateUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    // Create a new user
    public UserEntity createUser(CreateUserRequest u) {
        UserEntity newUser=modelMapper.map(u,UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(u.getPassword()));
        return usersRepository.save(newUser);
    }
    public UserEntity getUser(String username){
        return usersRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId){
        return usersRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
    }

    public UserEntity loginUser(String username, String password){
        var user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsersService.UserNotFoundException(username));
var passmatch=passwordEncoder.matches(password,user.getPassword());
if(!passmatch){
    throw new InvalidCredentialsException();
}
        return user;

    }

    public static class UserNotFoundException extends IllegalArgumentException {

        public UserNotFoundException(String username) {
            super("User " + username + " not found");
        }

        public UserNotFoundException(Long userId) {
            super("User " + userId + " not found");
        }
    }

    public static class InvalidCredentialsException extends IllegalArgumentException{
        public InvalidCredentialsException(){
            super("Invalid Username or Password Exception");
        }
    }
}
