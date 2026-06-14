package com.java.basicoperations.service;

import com.java.basicoperations.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
//todo it should be Service
//  create interface for repository operations and separate repository for inMemory implementation and inject it there with qualifier
// rename ot to UserServiceInMemoryImpl
// create separate service with Database repository impl
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    private static int idCount = 0;

    static {
        users.add(User.builder().id(++idCount).name("Avi").birthDate(LocalDate.now().minusYears(20)).email("avi@example.com").createdDate(LocalDateTime.now()).internalNotes("Internal notes for Avi").build());
        users.add(User.builder().id(++idCount).name("Alla").birthDate(LocalDate.now().minusYears(30)).email("alla@example.com").createdDate(LocalDateTime.now()).internalNotes("Internal notes for Alla").build());
        users.add(User.builder().id(++idCount).name("Reddy").birthDate(LocalDate.now().minusYears(15)).email("reddy@example.com").createdDate(LocalDateTime.now()).internalNotes("Internal notes for Reddy").build());
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        return users.stream().filter(user -> Objects.equals(user.getId(), id)).
                findFirst().orElse(null);
    }

    @Override
    public User saveUser(User user) {
        user.setId(++idCount);
        user.setCreatedDate(LocalDateTime.now());
        users.add(user);
        return user;
    }

    @Override
    public boolean deleteUser(User user) {
        return users.removeIf(u -> u.getId() == user.getId());
    }
}
