package com.example.oreo.service;

import com.example.oreo.model.Game;
import com.example.oreo.service.web.dto.GameAddDto;

import java.util.List;

public interface GameService {

    Game add(GameAddDto gameAddDto);
    List<Game> returnGames();
}
