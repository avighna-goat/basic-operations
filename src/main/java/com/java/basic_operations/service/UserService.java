package com.java.basic_operations.service;

import com.java.basic_operations.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User saveUser(User user);

    boolean deleteUser(User user);
}
