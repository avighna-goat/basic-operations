package com.java.basicoperations.Controller.v2;

import com.java.basicoperations.Dto.UserDto;
import com.java.basicoperations.entity.User;
import com.java.basicoperations.repository.UserNotFoundException;
import com.java.basicoperations.service.UserMapper;
import com.java.basicoperations.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("v2UserController")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @GetMapping("/api/v2/users")
    public List<UserDto> GetAllUsers() {
        List<User> users = service.findAll();
        return mapper.toDtoList(users);
    }

    @GetMapping("/api/v2/users/{id}")
    public UserDto GetUsersById(@PathVariable int id) {
        User userFound = service.findById(id);
        if (userFound == null)
            throw new UserNotFoundException("id:" + id);

        return mapper.toDto(userFound);
    }
}
