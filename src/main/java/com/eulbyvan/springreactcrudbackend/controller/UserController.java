package com.eulbyvan.springreactcrudbackend.controller;

import com.eulbyvan.springreactcrudbackend.model.User;
import com.eulbyvan.springreactcrudbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 27/12/2022
 */

@RestController
@RequestMapping("/api/1.0/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}