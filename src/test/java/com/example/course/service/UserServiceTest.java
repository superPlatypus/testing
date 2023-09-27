package com.example.course.service;

import com.example.course.entity.Role;
import com.example.course.entity.User;
import com.example.course.repository.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userSevice;
    @MockBean
    private UserRepo userRepo;

    @Test
    public void addUser() {
        User user = new User();

        boolean isUserCreated = userSevice.addUser(user);

        Assert.assertTrue(isUserCreated);
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }

    @Test
    public void addUserFail(){
        User user = new User();
        user.setUsername("Kirill");

        Mockito.doReturn(new User())
                .when(userRepo)
                .findByUsername("Kirill");

        boolean isUserCreated = userSevice.addUser(user);
        Assert.assertFalse(isUserCreated);
        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
    }
}