package com.expense.tracker.response;

import lombok.Data;


@Data
public class LoginResponse {
    private String token;
    private long expiresIn;
    private int userId;
}

