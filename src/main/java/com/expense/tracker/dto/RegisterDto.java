package com.expense.tracker.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDto {
    private int id;
    @NotBlank(message = "this field cannot be blank")
    private String username;
    private String password;
    private String email;
    private String name;
}

