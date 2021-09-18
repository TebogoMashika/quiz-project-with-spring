package com.codeAvengers.quizProject.Service.PlayerService;

import com.codeAvengers.quizProject.Model.Game;
import com.codeAvengers.quizProject.Model.GameQuestions;
import com.codeAvengers.quizProject.Model.Player;
import com.codeAvengers.quizProject.Repositories.GameQuestionsRepository;
import com.codeAvengers.quizProject.Repositories.GameRepository;
import com.codeAvengers.quizProject.Repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final GameQuestionsRepository gameQuestionsRepository;



    public PlayerService(PlayerRepository playerRepository, GameRepository gameRepository, GameQuestionsRepository gameQuestionsRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
        this.gameQuestionsRepository = gameQuestionsRepository;
    }

    // validate game pin


    // save the username
    public void savePlayerInputs(Player player){

        playerRepository.save(player);

    }

    // display game pin
    public List<Game> displayGamePin(){

        return gameRepository.findAll();

    }

    // display game questions

    public List<GameQuestions> displayGameQuestions(){

        return gameQuestionsRepository.findAll();
    }


}
