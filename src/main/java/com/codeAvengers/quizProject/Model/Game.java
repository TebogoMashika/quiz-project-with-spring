package com.codeAvengers.quizProject.Model;

import javax.persistence.*;

@Entity
@Table (name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "GamePin")
    private int gamePin;

    @Column(name="GameName")
    private String gameName;


    public Game(){
    }

    public Game(int gamePin, String gameName) {
        this.gamePin = gamePin;
        this.gameName = gameName;
    }


    public int getGamePin() {
        return gamePin;
    }

    public void setGamePin(int gamePin) {
        this.gamePin = gamePin;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

}
