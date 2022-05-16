package com.example.oreo.service;

import com.example.oreo.model.Game;
import com.example.oreo.model.Purchase;
import com.example.oreo.model.User;
import com.example.oreo.service.web.dto.GameAddDto;
import org.springframework.stereotype.Repository;

public interface PurchuseService {

    Purchase add(Game game,User user,String key);
}
