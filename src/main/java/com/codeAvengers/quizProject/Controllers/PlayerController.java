package com.codeAvengers.quizProject.Controllers;

import com.codeAvengers.quizProject.Model.Player;
import com.codeAvengers.quizProject.Repositories.GameRepository;
import com.codeAvengers.quizProject.Repositories.PlayerRepository;
import com.codeAvengers.quizProject.Service.PlayerService.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        return "/PlayerTemplates/Player.html";
    }


}
