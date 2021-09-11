package com.codeAvengers.quizProject.Controllers;

import com.codeAvengers.quizProject.Model.Player;
import com.codeAvengers.quizProject.Repositories.PlayerRepository;
import com.codeAvengers.quizProject.Service.PlayerService.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;


    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

    @RequestMapping("/requestPlayerHomePage")
    public String requestPlayerPage(){

        return "/PlayerTemplates/Player.html";
    }

    @RequestMapping("/requestPlayerGameInputs")
    public String getPlayerHomePageInputs(@RequestParam(value = "gamePinForPlayer") String gamePinForPlayer,
                                    @RequestParam(value = "gameUsername") String gameUsername,
                                    Player player){
        playerService.savePlayerInputs(player);

        return "/PlayerTemplates/Player.html";
    }


}
