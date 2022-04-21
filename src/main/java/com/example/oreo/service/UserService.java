package com.example.oreo.service;

import com.example.oreo.model.User;
import com.example.oreo.service.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    User save(UserRegistrationDto registrationDto);

}
