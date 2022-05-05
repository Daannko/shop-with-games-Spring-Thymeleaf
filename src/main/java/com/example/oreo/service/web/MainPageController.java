package com.example.oreo.service.web;


import com.example.oreo.model.User;
import com.example.oreo.repository.UserRepository;
import com.example.oreo.service.GameService;
import com.example.oreo.service.UserService;
import com.example.oreo.service.web.dto.GameAddDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class MainPageController {

    private UserRepository userRepository;


    public MainPageController(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

/*    @ModelAttribute("game")
    public GameAddDto gameAddDto(){
        return new GameAddDto();
    }
    @ModelAttribute("user")
    public User getUser(){

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }



        return userRepository.findByUserName("daniel");
    }*/


    @PostMapping
    public String home(Model model)
    {
        User user = userRepository.findUserByUserName("daniel");
        model.addAttribute("userInfo",user);
        return "index";
    }

}
