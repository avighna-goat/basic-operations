package com.java.basic_operations.Controller;

import com.java.basic_operations.Dto.UserDto;
import com.java.basic_operations.entity.User;
import com.java.basic_operations.repository.UserRepository;
import com.java.basic_operations.service.UserMapper;
import com.java.basic_operations.service.UserService;
import com.java.basic_operations.repository.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
//todo userController has a single responsibility of managing users
// that's why it should have base path on root level like "/api/v1/user"
// all methods+ operation should reflect meaning of action
// f.e. for get just empty path (assuming that you have on root base one)
// for getting by id /{id}
// for versioning better separate by package or controller name, but not mix different versions in single controller
// not use repository from controller, only service
@RestController
public class UserController {

    private final UserService service;
    private final UserMapper mapper;
    private final UserRepository repository;

    //todo try to use Lombok for required fields
    public UserController(UserService service, UserMapper mapper, UserRepository repository) {
        this.service = service;
        this.mapper = mapper;
        this.repository = repository;
    }

    @GetMapping("v1/users")
    public List<User> GetAllUsersV1()
    {
        return service.findAll();
    }

    @GetMapping("h2/users")
    public List<User> GetAllUsersH2()
    {
        return repository.findAll();
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
        User userFound = repository.findById(id).orElse(new User());
        if(userFound.getId() == null)
            throw new UserNotFoundException("id:"+id);

        return mapper.toDto(userFound);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> CreateUser(@Valid @RequestBody User user)
    {
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void DeleteUsersById(@PathVariable int id)
    {
        repository.deleteById(id);
    }
}
