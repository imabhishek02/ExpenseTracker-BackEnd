package com.expense.tracker.Controller;

import com.expense.tracker.Entity.Expense;
import com.expense.tracker.repository.ExpenseRepo;
import com.expense.tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/Expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/addExpense")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
        Expense saveExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(saveExpense, HttpStatus.CREATED);
    }
    @PutMapping("/updateExpense/{id}")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense,@PathVariable int id){
        Expense updatedExpense = expenseService.updateExpense(expense,id);
        return new ResponseEntity<>(updatedExpense,HttpStatus.OK);
    }
    @GetMapping("/getAllExpenses/{userid}")
    public ResponseEntity<List<Expense>> getAllExpenses(@PathVariable Integer userid){
        List<Expense>expenses = expenseService.getAllExpenses(userid);
        return new ResponseEntity<>(expenses,HttpStatus.OK);
    }
}
