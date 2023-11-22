package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setFirst_name("test");
        user.setLast_name("test");
        return userRepository3.save(user);
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    //TODO: update process
    public User updateUser(Integer id, String password){
        User user = userRepository3.findById(id).orElse(null);
        if(user!=null) user.setPassword(password);
        return user;
    }
}
