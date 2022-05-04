package com.example.oreo.service;

import com.example.oreo.model.Game;
import com.example.oreo.model.User;
import com.example.oreo.service.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    User save(UserRegistrationDto registrationDto);
    List<User> returnUsers();
}
