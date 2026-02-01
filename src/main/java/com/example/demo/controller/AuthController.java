package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user){

        return userService.signUp(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){

        Optional<User> check= userService.login(user.getEmail(), user.getPassword());

        if(check.isPresent()){
            return "Login Succesful";
        }
        return "Invalid Credential";
    }

    @GetMapping("/me")
    public String me(){
        return "This is /me endpoint (will secure later)";
    }


}

//POST /api/signup
//→ Controller
//→ Service
//→ Repository
//→ DB
//
//POST /api/login
//→ Controller
//→ Service
//→ Repository
//→ DB















