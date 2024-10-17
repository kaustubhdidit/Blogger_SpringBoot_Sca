package com.scaler.blogapp.users;

import com.scaler.blogapp.users.dtos.CreateUserRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {

    @Autowired
    UsersService usersService;

    @Test
    void can_create_users(){
        var user=usersService.createUser(new CreateUserRequest("john","pass123","john@blog.com"));
        org.junit.jupiter.api.Assertions.assertNotNull(user);
        org.junit.jupiter.api.Assertions.assertEquals("john",user.getUsername());
    }

}
