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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {


    private GameService gameService;
    private UserService userService;
    private UserRepository userRepository;
    private GameRepository gameRepository;


    public AdminController(GameService gameService,UserService userService,UserRepository userRepository,GameRepository gameRepository) {
        super();
        this.gameService = gameService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
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

    @RequestMapping(value = "/visible/{personId}",method = RequestMethod.GET)
    public String handleChangeVisibilityOfGame(@PathVariable Integer personId) {
        Game game = gameRepository.findGameById(personId);
        if(game.getVisible())
        {
            game.setVisible(false);
        }
        else
        {
            game.setVisible(true);
        }
        gameRepository.save(game);

        return "redirect:/admin?successVisible";
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
    }


}
