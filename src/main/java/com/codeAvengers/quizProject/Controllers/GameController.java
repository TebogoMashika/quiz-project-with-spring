package com.codeAvengers.quizProject.Controllers;

import com.codeAvengers.quizProject.Repositories.GameRepository;
import com.codeAvengers.quizProject.Service.GameService.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    private final GameService gameService;
    private final GameRepository gameRepository;

    public GameController(GameService gameService, GameRepository gameRepository) {
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }

    @RequestMapping("/QuizMasterHomePage") // receive request from this link
    public void setGamePinX(Model model){

        int x = gameService.getRandomInt(100000, 10000);
        model.addAttribute("GamePinModel", x);

    }

}
