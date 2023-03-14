package com.example.SpringMvcTest.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String display(@RequestParam("name") String name, @RequestParam("pass") String pass, Model m)
    {
        //read the provided form data
//        String name=req.getParameter("name");
//        String pass=req.getParameter("pass");
        if(pass.equals("admin"))
        {
            String msg="Hello "+ name;
            //add a message to the model
            m.addAttribute("message", msg);
            return "hello";
        }
        else
        {
            String msg="Sorry "+ name+". You entered an incorrect password";
            m.addAttribute("message", msg);
            return "hello2";
        }
    }

}
