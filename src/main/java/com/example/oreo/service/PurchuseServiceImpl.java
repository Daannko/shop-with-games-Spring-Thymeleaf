package com.example.oreo.service;

import com.example.oreo.model.Game;
import com.example.oreo.model.Purchase;
import com.example.oreo.model.User;
import com.example.oreo.repository.GameRepository;
import com.example.oreo.repository.PurchuseRepository;

import java.util.Date;

public class PurchuseServiceImpl implements PurchuseService{

    private PurchuseRepository purchuseRepository;

    public PurchuseServiceImpl(PurchuseRepository purchuseRepository) {
        super();
        this.purchuseRepository = purchuseRepository;
    }

    @Override
    public Purchase add(Game game, User user,String key) {
        Purchase purchase  = new Purchase(user.getId(), game.getId(), game.getPrice(), key,new Date());
        return purchuseRepository.save(purchase);
    }
}
