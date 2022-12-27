package com.eulbyvan.springreactcrudbackend.controller;

import com.eulbyvan.springreactcrudbackend.exception.UserNotFoundException;
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
@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());

                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if(!userRepository.existsById(id)) throw new UserNotFoundException(id);
        userRepository.deleteById(id);

        return "User with id " + id + " has been deleted successfully";
    }
}
