package com.example.oreo.repository;

import com.example.oreo.model.Game;
import com.example.oreo.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchuseRepository   extends JpaRepository<Purchase,Integer> {
    List<Purchase> findAll();
}
