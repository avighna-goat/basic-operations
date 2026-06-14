package com.java.basicoperations.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birth date should be in past")
    private LocalDate birthDate;

    @Email(message = "Email should be valid")
    private String userEmail;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Long version;
}
