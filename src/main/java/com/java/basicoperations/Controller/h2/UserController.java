package com.java.basicoperations.Controller.h2;

import com.java.basicoperations.Dto.UserDto;
import com.java.basicoperations.entity.User;
import com.java.basicoperations.repository.UserNotFoundException;
import com.java.basicoperations.service.UserJpaService;
import com.java.basicoperations.service.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController("h2UserController")
@RequiredArgsConstructor
public class UserController {

    private final UserJpaService jpaservice;
    private final UserMapper mapper;

    @GetMapping("/h2/users")
    public List<User> GetAllUsers() {
        return jpaservice.findAll();
    }

    @GetMapping("/h2/users/{id}")
    public UserDto GetUsersById(@PathVariable int id) {
        User userFound = jpaservice.findById(id).orElse(new User());
        if (userFound.getId() == null)
            throw new UserNotFoundException("id:" + id);

        return mapper.toDto(userFound);
    }

    @PostMapping("/h2/users")
    public ResponseEntity<Void> CreateUser(@Valid @RequestBody User user) {
        User savedUser = jpaservice.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/h2/users/{id}")
    public void DeleteUsersById(@PathVariable int id) {
        jpaservice.deleteById(id);
    }
}
