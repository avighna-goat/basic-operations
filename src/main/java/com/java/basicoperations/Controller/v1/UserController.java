package com.java.basicoperations.Controller.v1;

import com.java.basicoperations.entity.User;
import com.java.basicoperations.repository.UserNotFoundException;
import com.java.basicoperations.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController("v1UserController")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/api/v1/users")
    public List<User> GetAllUsers() {
        return service.findAll();
    }

    @PostMapping("/api/v1/users")
    public ResponseEntity<Void> CreateUser(@Valid @RequestBody User user) {
        User savedUser = service.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/api/v1/users/{id}")
    public boolean DeleteUsersById(@PathVariable int id) {

        User userFound = service.findById(id);
        if (userFound == null)
            throw new UserNotFoundException("id you entered does not exist:" + id);

        return service.deleteUser(userFound);
    }
}
