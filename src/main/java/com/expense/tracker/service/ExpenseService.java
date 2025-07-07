package com.expense.tracker.service;

import com.expense.tracker.Entity.Customer;
import com.expense.tracker.Entity.Expense;
import com.expense.tracker.Entity.UserLogin;
import com.expense.tracker.repository.CustomerRepo;
import com.expense.tracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private CustomerRepo customerRepo;
    public Expense addExpense(Expense expense) {
        Customer inputUser = expense.getUser();
        Customer customer = customerRepo.findByUsername(inputUser.getUsername());
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        expense.setUser(customer);
        customer.getExpenseList().add(expense);
        return expenseRepo.save(expense);
    }

    public Expense updateExpense(Expense expense,int id) {
        Expense findExpense = expenseRepo.findById(id).orElseThrow(()->new RuntimeException("Invalid expense id"));

            findExpense.setExpenseName(expense.getExpenseName());
            findExpense.setDate(expense.getDate());
            findExpense.setAmount(expense.getAmount());
            findExpense.setDescription(expense.getDescription());
            expenseRepo.save(findExpense);
            return findExpense;
    }
    public List<Expense> getAllExpenses(int Userid) {
        Customer customer = customerRepo.findById(Userid).orElseThrow(()->new RuntimeException("Invalid UserId"));
        List<Expense>AllExpense = customer.getExpenseList();
        return AllExpense;
    }
}
