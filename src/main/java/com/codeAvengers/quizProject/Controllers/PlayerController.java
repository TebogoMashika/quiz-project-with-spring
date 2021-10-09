package com.codeAvengers.quizProject.Controllers;

import com.codeAvengers.quizProject.Model.Player;
import com.codeAvengers.quizProject.Repositories.GameRepository;
import com.codeAvengers.quizProject.Repositories.PlayerRepository;
import com.codeAvengers.quizProject.Service.PlayerService.EPlayerAnswerStatus;
import com.codeAvengers.quizProject.Service.PlayerService.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PlayerController  {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;
    private final GameRepository gameRepository;

    // Templates
    private static final String  viewPlayerTemplate= "/PlayerTemplates/Player.html";
    private static final String playerQuestionsTemplate = "/PlayerTemplates/playerQuestions.html";
    private static final String playerResultsTemplate = "/PlayerTemplates/playerResults.html";

    // URLs
    private static final String requestPlayerHomePage = "/requestPlayerHomePage";
    private static final String requestPlayerGameInputs = "/requestPlayerGameInputs";
    private static final String displayPlayerQuestions = "/displayPlayerQuestions";
    private static final String nextQuestion = "/nextQuestion";
    private static final String submitQuestionAnswers = "/submitQuestionAnswers";

    public PlayerController(PlayerRepository playerRepository, PlayerService playerService, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
        this.gameRepository = gameRepository;
    }

    // display game pin
    @RequestMapping(requestPlayerHomePage)
    public String requestPlayerPage(Model model){

        model.addAttribute("viewGamePin", playerService.displayGamePin());

        return viewPlayerTemplate;
    }


    // get game pin and username
    @RequestMapping(requestPlayerGameInputs)
    public String getPlayerHomePageInputs(@RequestParam(value = "gamePinForPlayer") String gamePinForPlayer,
                                    @RequestParam(value = "gameUsername") String gameUsername,
                                    Player player){
        playerService.savePlayerInputs(player);

        return "redirect:/displayPlayerQuestions";
    }

    // display game questions
    @RequestMapping(displayPlayerQuestions)
    public String displayQuestions(Model model){

        // call this method to add the questions into a list
        playerService.getQuestionIDs();

        model.addAttribute("gameQuestions", playerService.displayGameQuestions());

        return playerQuestionsTemplate;

    }

    @RequestMapping(nextQuestion)
    public String displayNextQuestion(Model model,
                                      @RequestParam(value = "id", required = false) Long id,
                                      @RequestParam(value = "correctAnswer", required = false) String correctAnswer,
                                      @RequestParam(value = "userAnswer", required = false) String userAnswer){

        EPlayerAnswerStatus nullResults = playerService.listIsNull();
        playerService.verifyAnswers(correctAnswer, userAnswer);

        if (nullResults == EPlayerAnswerStatus.NULL_RESULTS){


            model.addAttribute("playerCorrectAnswers", playerService.correctAnswers());

            return playerResultsTemplate;

        }else {
            model.addAttribute("gameQuestions", playerService.displayGameQuestions());

            return playerQuestionsTemplate;
        }


    }


}
