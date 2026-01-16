package com.booking_API.demo.controller;

import com.booking_API.demo.dto.Users;
import com.booking_API.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserServices userService;
    @PostMapping("/register")
    public ResponseEntity<?> createUsers(@RequestBody Users userData){
        return new ResponseEntity<>(userService.createUser(userData) , HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user){
        return new ResponseEntity<>(userService.verifyUser(user),HttpStatus.OK);
    }
}
