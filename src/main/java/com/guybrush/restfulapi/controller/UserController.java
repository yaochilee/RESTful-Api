package com.guybrush.restfulapi.controller;

import com.guybrush.restfulapi.entity.User;
import com.guybrush.restfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user/{userName}")
    public User getUserByUsername(@PathVariable String userName) {
        return userRepository.findByUserName(userName);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

//    @PostMapping("/user/login")
//    public User login(@RequestBody User user) {
//        String username = user.getUsername();
//        String password = user.getPassword();
//        User targetUser = userRepository.findByUsername(username);
//        //check Password
//        if (password.equals(targetUser.getPassword())) {
//            return targetUser;
//        } else {
//            return null;
//        }
//
//    }
}
