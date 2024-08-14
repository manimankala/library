package com.Libarary.Systems.Controller;


import com.Libarary.Systems.Models.User;
import com.Libarary.Systems.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(User createuser) {
        return userService.addUser(createuser);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/name")
    public Optional<User> findUserByName(@RequestParam String userName) {
        return userService.getUserByName(userName);
    }
    @GetMapping("/phone")
    public Optional<User> findUserByPhone(@RequestParam String userPhone) {
        return userService.getUserByPhone(userPhone);
    }

    @PutMapping
    public User changeUser(@RequestBody User editUser) {
        return userService.updateUser(editUser);
    }
    @DeleteMapping("/{userId}")
    public String removeUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId);
    }
}

