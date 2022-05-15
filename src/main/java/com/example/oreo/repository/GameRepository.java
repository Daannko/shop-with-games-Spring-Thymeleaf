package com.example.oreo.repository;

import com.example.oreo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {
    Game findGameById(int id);
    List<Game> findAll();
    void deleteByName(String name);
    void deleteById(Integer id);
}