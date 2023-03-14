package com.example.SpringMvcTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller2 {

    @GetMapping("/hello2/hello")
    public String RR()
    {
        return "hello2";
    }
}
