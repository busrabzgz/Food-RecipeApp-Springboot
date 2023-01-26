package com.example.yemekTarifi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/index")
    public String index(){
        return "welcome to index page";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "here is dashboard! login is succesful";
    }

    @GetMapping("/admin")
    public String admin(){
        return " here is admin page ";
    }
}
