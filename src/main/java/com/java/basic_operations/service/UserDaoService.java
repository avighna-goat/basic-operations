package com.java.basic_operations.service;

import com.java.basic_operations.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int idCount = 0;

    static{
        users.add(new User(++idCount,"Avi",LocalDate.now().minusYears(20)));
        users.add(new User(++idCount,"Alla",LocalDate.now().minusYears(30)));
        users.add(new User(++idCount,"Reddy",LocalDate.now().minusYears(15)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> Objects.equals(user.getId(),id)).
                findFirst().orElse(null);
    }

    public User saveUser(User user){
        user.setId(++idCount);
        users.add(user);
        return user;
    }

    public boolean deleteUser(User user) {
        return users.removeIf(u -> u.getId() == user.getId());
    }
}
