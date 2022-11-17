package com.example.demoforkubernetes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoResource {

    @GetMapping
    public String getTEst() {
        return "Test";
    }
}
