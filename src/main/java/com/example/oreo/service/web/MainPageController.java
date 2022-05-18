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

import java.util.List;
import java.util.Locale;

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
        List<Game> games = gameRepository.findAll();
        quickSort(games,0,games.size()-1);
        model.addAttribute("games",games);
        return "index";
    }

    @PostMapping
    public String index(@RequestParam String text, Model model){

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("user",userRepository.findUserByUserName(username));
        List<Game> games = gameRepository.findAll();
        for(int i =0 ; i < games.size() ; i++)
        {
            if(!games.get(i).getName().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT)))
            {
                games.remove(i);
                i--;
            }
        }


        quickSort(games,0,games.size()-1);

        model.addAttribute("games",games);


        return "index";
    }

    static boolean compareStrings(Game g1,Game g2)
    {

        String s1 = g1.getName(),s2=g2.getName();
        int minLen = s1.length();
        if(minLen> s2.length()) minLen = s2.length();
        for(int i = 0 ; i < minLen ; i++)
        {
            if(s1.charAt(i) < s2.charAt(i))
            {
                return true;
            }
            else if (s1.charAt(i) > s2.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    static void swap(List<Game> list,int i, int j)
    {
        Game temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    static int partition(List<Game> list ,int low, int high)
    {
        Game pivot = list.get(high);
        int i = low -1;

        for(int j = low; j<high-1;j++)
        {
            if(compareStrings(list.get(j),pivot))
            {
                i++;
                swap(list,i,j);
            }
        }
        if(compareStrings(list.get(i+1),list.get(high)))
        swap(list,i+1,high);
        return i+1;
    }

    public void quickSort(List<Game> list,int low,int high)
    {
        if(low<high)
        {
            int pi = partition(list,low,high);
            quickSort(list,low,pi-1);
            quickSort(list,pi+1,high);
        }
    }

}
