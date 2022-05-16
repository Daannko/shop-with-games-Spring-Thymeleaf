package com.example.oreo.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="purchase",uniqueConstraints = { @UniqueConstraint(columnNames = { "gameKey"}) })
public class Purchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    int clientId;
    int gameId;
    int gamePrice;
    String gameKey;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Purchase()
    {

    }
    public Purchase(int id, int clientId, int gameId, int gamePrice, String gameKey, Date date) {
        this.id = id;
        this.clientId = clientId;
        this.gameId = gameId;
        this.gamePrice = gamePrice;
        this.gameKey = gameKey;
        this.date = date;
    }

    public Purchase(int clientId, int gameId, int gamePrice, String gameKey, Date date) {
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
