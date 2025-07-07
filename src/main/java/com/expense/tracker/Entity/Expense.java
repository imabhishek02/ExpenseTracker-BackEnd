package com.expense.tracker.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue
    private int id;
    private String expenseName;
    private Long amount;
    private String date;
    private String description;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private Customer user;

}
