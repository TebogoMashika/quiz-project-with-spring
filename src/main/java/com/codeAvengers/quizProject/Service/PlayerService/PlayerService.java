package com.codeAvengers.quizProject.Service.PlayerService;

import com.codeAvengers.quizProject.Model.Player;
import com.codeAvengers.quizProject.Repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // validate game pin


    // save the username
    public void savePlayerInputs(Player player){

        playerRepository.save(player);

    }


}
