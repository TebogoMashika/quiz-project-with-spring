package com.codeAvengers.quizProject.LoadData;

import com.codeAvengers.quizProject.Model.Game;
import com.codeAvengers.quizProject.Model.LogIn;
import com.codeAvengers.quizProject.Model.QuizMaster;
import com.codeAvengers.quizProject.Repositories.GameRepository;
import com.codeAvengers.quizProject.Repositories.LogInRepository;
import com.codeAvengers.quizProject.Repositories.QuizMasterRepository;
import com.codeAvengers.quizProject.Service.LoginService.LogInService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Data implements CommandLineRunner {

    private final QuizMasterRepository quizMasterRepository;
    private final LogInRepository logInRepository;
    private final LogInService logInService;
    private final GameRepository gameRepository;

    public Data(QuizMasterRepository quizMasterRepository, LogInRepository logInRepository, LogInService logInService, GameRepository gameRepository) {
        this.quizMasterRepository = quizMasterRepository;
        this.logInRepository = logInRepository;
        this.logInService = logInService;
        this.gameRepository = gameRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        QuizMaster quizMaster = new QuizMaster();

        quizMaster.setFirstName("admin");
        quizMaster.setLastName("admin");
        quizMaster.setEmail("admin@gmail.com");


        quizMasterRepository.save(quizMaster);

        System.out.println("registered quiz Master");

        LogIn user = new LogIn();


        user.setUsername("admin");
        user.setPassword(1234);
        logInRepository.save(user);

        System.out.println("user logged in");


        Game newGame = new Game();

        newGame.setGamePin(528);
        newGame.setGameName("NeoQuiz");
        gameRepository.save(newGame);

        System.out.println("Set game details");

    }
}
