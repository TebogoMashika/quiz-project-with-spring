package com.codeAvengers.quizProject.Model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "gameUsername")
    private String gameUsername;

    @Column(name = "gamePinForPlayer")
    private String gamePinForPlayer;

    public Player() {
    }

    public Player(String gameUsername, String gamePinForPlayer) {
        this.gameUsername = gameUsername;
        this.gamePinForPlayer = gamePinForPlayer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameUsername() {
        return gameUsername;
    }

    public void setGameUsername(String gameUsername) {
        this.gameUsername = gameUsername;
    }

    public String getGamePinForPlayer() {
        return gamePinForPlayer;
    }

    public void setGamePinForPlayer(String gamePinForPlayer) {
        this.gamePinForPlayer = gamePinForPlayer;
    }
}
