package com.example.oreo.service.web.dto;

import java.util.Date;

public class PurchuseAddDto {

    private int clientId;
    private int gameId;
    private int gamePrice;
    private String gameKey;
    private Date date;

    public PurchuseAddDto(int clientId, int gameId, int gamePrice, String gameKey, Date date) {
        this.clientId = clientId;
        this.gameId = gameId;
        this.gamePrice = gamePrice;
        this.gameKey = gameKey;
        this.date = date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(int gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
