package com.java.basic_operations.User;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Null(message = "Id is auto-generated, do not provide a value")
    private Integer Id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String Name;

    @Past(message = "Birth date should be in past")
    private LocalDate BirthDate;

    public Integer getId() {
        return Id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        Name = name;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    @JsonProperty("BirthDate")
    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public User(Integer id, String name, LocalDate birthDate) {
        Id = id;
        Name = name;
        BirthDate = birthDate;
    }
}
