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
import java.util.List;

@Controller
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;
    private final GameRepository gameRepository;


    public PlayerController(PlayerRepository playerRepository, PlayerService playerService, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
        this.gameRepository = gameRepository;
    }

    // display game pin
    @RequestMapping("/requestPlayerHomePage")
    public String requestPlayerPage(Model model){

        model.addAttribute("viewGamePin", playerService.displayGamePin());

        return "/PlayerTemplates/Player.html";
    }


    // get game pin and username
    @RequestMapping("/requestPlayerGameInputs")
    public String getPlayerHomePageInputs(@RequestParam(value = "gamePinForPlayer") String gamePinForPlayer,
                                    @RequestParam(value = "gameUsername") String gameUsername,
                                    Player player){
        playerService.savePlayerInputs(player);

        return "redirect:/displayPlayerQuestions";
    }

    // display game questions
    @RequestMapping("/displayPlayerQuestions")
    public String displayQuestions(Model model){

        model.addAttribute("gameQuestions", playerService.displayGameQuestions());

        return "/PlayerTemplates/playerQuestions.html";

    }


    // mapping has errors - to resolve
    @RequestMapping("/submitQuestionAnswers")
    public void questionAnswers(@RequestParam(value = "id", required = false) String[] id,
                                @RequestParam(value = "answer1", required = false) String[] answer1,
                                @RequestParam(value ="answer2", required = false)String[] answer2,
                                @RequestParam(value ="answer3", required = false)String[] answer3,
                                @RequestParam(value ="answer4", required = false)String[] answer4){

        ArrayList<EPlayerAnswerStatus> answerStatus  = playerService.verifyAnswers(id,answer1,answer2,answer3,answer4);

        ArrayList<EPlayerAnswerStatus> listOfCorrectStatus = new ArrayList<>();
        ArrayList<EPlayerAnswerStatus> listOfIncorrectStatus = new ArrayList<>();
        ArrayList<EPlayerAnswerStatus> listOfNoInputStatus = new ArrayList<>();

        for (EPlayerAnswerStatus status: answerStatus) {

            if (status ==EPlayerAnswerStatus.CORRECT){
                listOfCorrectStatus.add(status);
            }else if (status ==EPlayerAnswerStatus.INCORRECT){
                listOfIncorrectStatus.add(status);

            }else if (status==EPlayerAnswerStatus.NO_INPUT){
                listOfNoInputStatus.add(status);
            }
        }


        System.out.println(listOfCorrectStatus.size());
        System.out.println(listOfIncorrectStatus.size());
        System.out.println(listOfNoInputStatus.size());






    }






}
