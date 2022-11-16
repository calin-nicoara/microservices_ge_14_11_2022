package com.example.springsecuritydemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String getTest() {
        return "Hello there!";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello admin!";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Hello user!";
    }
}
