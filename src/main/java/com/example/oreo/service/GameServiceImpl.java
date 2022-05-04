package com.example.oreo.service;

import com.example.oreo.model.Game;
import com.example.oreo.model.Role;
import com.example.oreo.model.User;
import com.example.oreo.repository.GameRepository;
import com.example.oreo.repository.UserRepository;
import com.example.oreo.service.web.dto.GameAddDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameServiceImpl implements GameService{

    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        super();
        this.gameRepository = gameRepository;
    }


    @Override
    public Game add(GameAddDto gameAddDto) {
        Game game = new Game(gameAddDto.getName(),
                gameAddDto.getPrice());
        return gameRepository.save(game);
    }

    @Override
    public List<Game> returnGames() {
        return gameRepository.findAll();
    }

}
