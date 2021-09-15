package com.codeAvengers.quizProject.Controllers;

import com.codeAvengers.quizProject.Model.Game;
import com.codeAvengers.quizProject.Model.QuizMaster;
import com.codeAvengers.quizProject.Repositories.GameRepository;
import com.codeAvengers.quizProject.Service.GameService.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    private final GameService gameService;
    private final GameRepository gameRepository;

    public GameController(GameService gameService, GameRepository gameRepository) {
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }


    // receives user input from the template
    // saves the user input to the database
    @RequestMapping("/requestGameName")
    public String receiveGameName(@RequestParam(value = "gameName") String gameName,
                                  @RequestParam(value = "gamePin") String gamePin,
                                  Game game){

        // pending task - validate game pin
        gameRepository.save(game);

       return "GameTemplates/GameQuestions/questions.html";


    }




}
