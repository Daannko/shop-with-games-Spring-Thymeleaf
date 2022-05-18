package com.example.oreo.service.web;


import com.example.oreo.model.Game;
import com.example.oreo.model.Purchase;
import com.example.oreo.model.User;
import com.example.oreo.repository.GameRepository;
import com.example.oreo.repository.PurchuseRepository;
import com.example.oreo.repository.UserRepository;
import com.example.oreo.service.GameService;
import com.example.oreo.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;


@Controller
@RequestMapping("/profile")
public class ProfileController
{

    private UserRepository userRepository;
    private GameRepository gameRepository;
    private PurchuseRepository purchuseRepository;


    public ProfileController(UserRepository userRepository,GameRepository gameRepository,
                          PurchuseRepository purchuseRepository) {
        super();
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.purchuseRepository = purchuseRepository;
    }

    @GetMapping(value = "")
    public String ShowAddGameForm(Model model)
    {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findUserByUserName(username);
        List<Purchase> purchases = purchuseRepository.findAll();
        List<Game> games= gameRepository.findAll();

        TreeMap<Purchase,Game> gamesInfo = new TreeMap<>();

        for(Purchase entry : purchases)
        {
            if(entry.getClientId() == user.getId())
            {
                for(Game game: games)
                {
                    if(entry.getGameId() == game.getId())
                    {
                        gamesInfo.put(entry,game);
                        break;
                    }
                }

            }
        }

        model.addAttribute("user",user);
        model.addAttribute("gamesInfo",gamesInfo);


        return "profile";
    }

  /*  @PostMapping(value = "{gameId}")
    public String AddPurchuse(@PathVariable Integer gameId)
    {
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        Game game = gameRepository.findGameById(gameId);
        User user = userRepository.findUserByUserName(username);

        int length = 32;
        boolean useLetters = true;
        boolean useNumbers = true;
        String key = RandomStringUtils.random(length, useLetters, useNumbers);

        add(game,user,key);

        return "redirect:/game/"+gameId + "?success";
    }

    public Purchase add(Game game, User user,String key) {
        Purchase purchase  = new Purchase(user.getId(), game.getId(), game.getPrice(), key,new Date());
        return purchuseRepository.save(purchase);
    }
*/
    /*
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
