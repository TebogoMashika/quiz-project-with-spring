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

    //@RequestMapping("/QuizMasterHomePage") // receive request from this link
    public void setGamePinX(Model model){

        int x = gameService.getRandomInt(100000, 10000);
        model.addAttribute("GamePinModel", x);

    }

    // receives user input from the template
    // saves the user input to the database
    @RequestMapping("/RequestGameName")
    public void receiveGameName(@RequestParam(value = "gameName") String gameName, Game game){

        gameRepository.save(game);

       //return "/RequestGameName";

       // couple of options for displaying the game pin
            // 1, either display the game pin first then user clicks next to go to the game pin template
            // 2, let the user capture the game pin. like this we will save it same time as we save the game name the go display the sample
    }




}
