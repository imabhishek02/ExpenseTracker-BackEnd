package com.expense.tracker.Controller;

import com.expense.tracker.Entity.Customer;
import com.expense.tracker.dto.RegisterDto;
import com.expense.tracker.dto.LoginDto;
import com.expense.tracker.response.LoginResponse;
import com.expense.tracker.service.AuthenticationService;
import com.expense.tracker.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/expenseTracker")
public class CustomerController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public CustomerController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Customer> register(@Valid @RequestBody RegisterDto registerUserDto) {
        Customer registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginUserDto) {
        Customer authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        loginResponse.setUserId(authenticatedUser.getId());

        return ResponseEntity.ok(loginResponse);
    }}
