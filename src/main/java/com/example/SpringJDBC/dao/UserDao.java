package com.example.SpringJDBC.dao;

import com.example.SpringJDBC.model.User;

import java.util.List;

public interface UserDao {

    public void createUser(User user);

    public User getUserById(int id);

    public void updateUser(User user);

    public void deleteUser(int id);

    public List<User> getAllUsers();
}
