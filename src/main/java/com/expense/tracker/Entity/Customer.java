package com.expense.tracker.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer implements UserDetails {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false,unique = true,updatable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;
    private String name;

   @OneToMany(mappedBy = "user")
   @JsonManagedReference
    private List<Expense> expenseList=new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
