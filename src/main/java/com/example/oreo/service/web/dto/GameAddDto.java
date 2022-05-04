package com.example.oreo.service.web.dto;

public class GameAddDto {

    private String name;
    private int price;

    public GameAddDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public GameAddDto() {}

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
