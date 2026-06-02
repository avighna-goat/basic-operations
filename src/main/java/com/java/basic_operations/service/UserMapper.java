package com.java.basic_operations.service;

import com.java.basic_operations.Dto.UserDto;
import com.java.basic_operations.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    List<UserDto> toDtos(List<User> users);
}
