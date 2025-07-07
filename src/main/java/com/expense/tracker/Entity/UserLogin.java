package com.expense.tracker.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserLogin {
    private String username;
    private String password;

}
