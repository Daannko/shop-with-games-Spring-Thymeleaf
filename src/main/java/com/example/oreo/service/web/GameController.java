package com.example.oreo.service.web;


import com.example.oreo.model.Game;
import com.example.oreo.model.User;
import com.example.oreo.repository.GameRepository;
import com.example.oreo.repository.UserRepository;
import com.example.oreo.service.GameService;
import com.example.oreo.service.UserService;
import com.example.oreo.service.web.dto.GameAddDto;
import com.example.oreo.service.web.dto.UserRegistrationDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/game")
public class GameController {


    private GameService gameService;
    private UserService userService;
    private UserRepository userRepository;
    private GameRepository gameRepository;


    public GameController(GameService gameService,UserService userService,UserRepository userRepository,GameRepository gameRepository) {
        super();
        this.gameService = gameService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping(value = "{gameId}")
    public String ShowAddGameForm(@PathVariable Integer gameId, Model model)
    {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("user",userRepository.findUserByUserName(username));
        model.addAttribute("game",gameRepository.findGameById(gameId));
        return "game";
    }

   /* @PostMapping
    public String AddGame(@ModelAttribute("game")GameAddDto gameAddDto)
    {
        gameService.add(gameAddDto);
        return "redirect:/admin?succes";
    }

    @RequestMapping(value = "/delete_game/{personId}",method = RequestMethod.GET)
    public String handleDeleteGame(@PathVariable Integer personId) {
        gameRepository.deleteById(personId);
        return "redirect:/admin?success";
    }
    @RequestMapping(value = "/delete_user/{personId}",method = RequestMethod.GET)
    public String handleDeleteUser(@PathVariable Integer personId) {

        if(userRepository.findUserById(personId).returnRole().equals("ROLE_USER"))
            userRepository.deleteById(personId);
        else
        {
            return "redirect:/admin?fail";
        }
        return "redirect:/admin?successUser";
    }*/


}
