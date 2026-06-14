package com.java.basicoperations.service;

import com.java.basicoperations.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User saveUser(User user);

    boolean deleteUser(User user);
}
