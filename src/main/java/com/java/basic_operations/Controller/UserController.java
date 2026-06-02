package com.java.basic_operations.Controller;

import com.java.basic_operations.Dto.UserDto;
import com.java.basic_operations.entity.User;
import com.java.basic_operations.service.UserMapper;
import com.java.basic_operations.service.UserService;
import com.java.basic_operations.repository.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("v1/users")
    public List<User> GetAllUsersV1()
    {
        return service.findAll();
    }

    @GetMapping("v2/users")
    public List<UserDto> GetAllUsersV2()
    {
        List<User> users = service.findAll();
        return mapper.toDtos(users);
    }

    @GetMapping("/users/{id}")
    public UserDto GetUsersById(@PathVariable int id)
    {
        User userFound = service.findById(id);
        if(userFound == null)
            throw new UserNotFoundException("id:"+id);

        return mapper.toDto(userFound);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> CreateUser(@Valid @RequestBody User user)
    {
        User savedUser = service.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public boolean DeleteUsersById(@PathVariable int id)
    {
        User userFound = service.findById(id);
        if(userFound == null)
            throw new UserNotFoundException("id you entered does not exist:"+id);

        return service.deleteUser(userFound);
    }
}
