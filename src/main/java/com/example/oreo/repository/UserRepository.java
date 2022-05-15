package com.example.oreo.repository;

import com.example.oreo.model.Game;
import com.example.oreo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
    User findUserById(Integer id);
    List<User> findAll();
    User findUserByUserName(String userName);
    void deleteById(Integer id);
}
