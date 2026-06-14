package com.java.basicoperations.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@jakarta.persistence.Entity(name = "user_details")
public class User extends BaseEntity {

    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birth date should be in past")
    private LocalDate birthDate;

    private String email;

    private String internalNotes;
}
