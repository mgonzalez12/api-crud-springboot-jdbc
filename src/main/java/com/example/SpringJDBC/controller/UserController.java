package com.example.SpringJDBC.controller;

import com.example.SpringJDBC.dao.UserDao;
import com.example.SpringJDBC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserDao userDao;

    @GetMapping
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userDao.getUserById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        return user;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userDao.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userDao.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deleteUser(@PathVariable int id) {
        User user = userDao.getUserById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        userDao.deleteUser(id);
    }

}
