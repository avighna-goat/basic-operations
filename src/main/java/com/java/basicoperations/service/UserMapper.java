package com.java.basicoperations.service;

import com.java.basicoperations.Dto.UserDto;
import com.java.basicoperations.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "email", target = "userEmail")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);
}
