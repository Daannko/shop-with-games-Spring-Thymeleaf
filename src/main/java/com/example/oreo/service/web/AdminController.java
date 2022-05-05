package com.example.oreo.service.web;


import com.example.oreo.model.Game;
import com.example.oreo.model.User;
import com.example.oreo.repository.GameRepository;
import com.example.oreo.repository.UserRepository;
import com.example.oreo.service.GameService;
import com.example.oreo.service.UserService;
import com.example.oreo.service.web.dto.GameAddDto;
import com.example.oreo.service.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {


    private GameService gameService;
    private UserService userService;
    private UserRepository userRepository;


    public AdminController(GameService gameService,UserService userService,UserRepository userRepository) {
        super();
        this.gameService = gameService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @ModelAttribute("game")
    public GameAddDto gameAddDto(){
        return new GameAddDto();
    }
    @ModelAttribute("user")
    public List<User> getUsers(){
        return userService.returnUsers();
    }


    @GetMapping
    public String ShowAddGameForm(Model model)
    {
        model.addAttribute("game",new GameAddDto());
        model.addAttribute("games", gameService.returnGames());
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }

    @PostMapping
    public String AddGame(@ModelAttribute("game")GameAddDto gameAddDto)
    {
        gameService.add(gameAddDto);
        return "redirect:/admin?succes";
    }

}
