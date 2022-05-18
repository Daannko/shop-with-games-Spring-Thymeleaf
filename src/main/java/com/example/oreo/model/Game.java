package com.example.oreo.model;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    String name;
    Integer price;
    String description;
    Boolean visible;

    public Game(int id, String name, Integer price,String description,Boolean visible) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.visible = visible;
    }

    public Game(String name, Integer price,String description,Boolean visible) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.visible = visible;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Game() {

    }

    public Game(String game_user) {
        super();
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
