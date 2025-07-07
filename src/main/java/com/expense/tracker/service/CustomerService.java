package com.expense.tracker.service;

import com.expense.tracker.Entity.Customer;
import com.expense.tracker.Entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expense.tracker.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public Customer registerUser(Customer customer) {
      Customer savedCustomer = customerRepo.save(customer);
      return savedCustomer;
    }
    public String loginUser(UserLogin userLogin){
        Customer checkUser = customerRepo.findByUsername(userLogin.getUsername());
        if(checkUser!=null ){
            if(checkUser.getPassword().equals(userLogin.getPassword())){
                return "Successfully Logged in!";
            }return "Incorrect Password";

        }else{
            return  "Invalid UserName";
        }
    }
}
