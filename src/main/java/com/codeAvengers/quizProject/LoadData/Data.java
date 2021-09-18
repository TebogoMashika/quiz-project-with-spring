package com.codeAvengers.quizProject.LoadData;

import com.codeAvengers.quizProject.Model.Game;
import com.codeAvengers.quizProject.Model.GameQuestions;
import com.codeAvengers.quizProject.Model.LogIn;
import com.codeAvengers.quizProject.Model.QuizMaster;
import com.codeAvengers.quizProject.Repositories.GameQuestionsRepository;
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
    private final GameQuestionsRepository gameQuestionsRepository;

    public Data(QuizMasterRepository quizMasterRepository, LogInRepository logInRepository, LogInService logInService, GameRepository gameRepository, GameQuestionsRepository gameQuestionsRepository) {
        this.quizMasterRepository = quizMasterRepository;
        this.logInRepository = logInRepository;
        this.logInService = logInService;
        this.gameRepository = gameRepository;
        this.gameQuestionsRepository = gameQuestionsRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // register quiz master
        QuizMaster quizMaster = new QuizMaster();
        quizMaster.setFirstName("admin");
        quizMaster.setLastName("admin");
        quizMaster.setEmail("admin@gmail.com");

        quizMasterRepository.save(quizMaster);

        System.out.println("registered quiz Master");

        // register login details
        LogIn registerLoginDetails = new LogIn();

        registerLoginDetails.setUsername("admin");
        registerLoginDetails.setPassword(1234);

        // set the id of the quiz master logged in
        registerLoginDetails.setQuizMaster(quizMaster);

        // save logged in details
        logInRepository.save(registerLoginDetails);

        System.out.println("user registered username and password");


        Game newGame = new Game();

        newGame.setGamePin(528);
        newGame.setGameName("NeoQuiz");

        gameRepository.save(newGame);

        Game xGame = new Game();

        xGame.setGamePin(1234);
        xGame.setGameName("testGame");

        gameRepository.save(xGame);

        System.out.println("Set game pin and name");

        // game questions
        GameQuestions gameQuestions = new GameQuestions();
        gameQuestions.setQuestion("What is the game question");
        gameQuestions.setCorrectAnswer("correct answer");
        gameQuestions.setOtherAnswers_1("Answers_1");
        gameQuestions.setOtherAnswers_2("Answers_2");
        gameQuestions.setOtherAnswers_3("Answers_3");
        gameQuestions.setOtherAnswers_4("Answers_4");

        gameQuestionsRepository.save(gameQuestions);

        System.out.println("saved game questions");



    }
}
