package com.java.basicoperations.service;

import com.java.basicoperations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaService extends JpaRepository<User, Integer> {
}
