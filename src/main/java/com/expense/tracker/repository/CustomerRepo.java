package com.expense.tracker.repository;

import com.expense.tracker.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);
}
