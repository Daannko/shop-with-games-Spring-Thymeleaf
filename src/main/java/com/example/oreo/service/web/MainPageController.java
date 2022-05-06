package com.example.oreo.service.web;


import com.example.oreo.model.Game;
import com.example.oreo.model.User;
import com.example.oreo.repository.GameRepository;
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
@RequestMapping("/")
public class MainPageController {

    private UserRepository userRepository;
    private GameRepository gameRepository;


    public MainPageController(UserRepository userRepository,GameRepository gameRepository) {
        super();
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public String getUser(Model model){

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("user",userRepository.findUserByUserName(username));
        model.addAttribute("games",gameRepository.findAll());
        return "index";
    }


    @PostMapping
    public String home(Model model)
    {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("user",userRepository.findUserByUserName(username));
        model.addAttribute("games",userRepository.findAll());
        return "index";
    }

}
