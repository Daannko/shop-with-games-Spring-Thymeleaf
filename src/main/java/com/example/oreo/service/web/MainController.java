package com.example.oreo.service.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    String home()
    {
        return"index";
    }

}
