package com.scaler.blogapp.users;

import com.scaler.blogapp.users.dtos.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Create a new user
    public UserEntity createUser(CreateUserRequest req) {
        var newUser = UserEntity.builder()
                        .username(req.getUsername())
//                        .password(password)
                        .email (req.getEmail()).build();
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
}
