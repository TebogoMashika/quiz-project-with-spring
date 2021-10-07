package com.codeAvengers.quizProject.Service.GameService;

import com.codeAvengers.quizProject.Repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


}
