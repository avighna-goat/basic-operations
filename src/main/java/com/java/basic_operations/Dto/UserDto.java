package com.java.basic_operations.Dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
//try to do comlex mapping with different filed names in dto and entity, skipping some fields from entity
public class UserDto {
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birth date should be in past")
    private LocalDate birthDate;
}
