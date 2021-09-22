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
        gameQuestions.setOtherAnswers_1("Answer_1");
        gameQuestions.setOtherAnswers_2("Answer_2");
        gameQuestions.setOtherAnswers_3("Answer_3");
        gameQuestions.setOtherAnswers_4("Answer_4");

        gameQuestionsRepository.save(gameQuestions);

        // game questions
        GameQuestions gameQuestions1 = new GameQuestions();
        gameQuestions1.setQuestion("What is the game question");
        gameQuestions1.setCorrectAnswer("correct answer");
        gameQuestions1.setOtherAnswers_1("Answers");
        gameQuestions1.setOtherAnswers_2("Answers");
        gameQuestions1.setOtherAnswers_3("Answers");
        gameQuestions1.setOtherAnswers_4("Answers");

        gameQuestionsRepository.save(gameQuestions1);

        // game questions
        GameQuestions gameQuestion11 = new GameQuestions();
        gameQuestion11.setQuestion("What is the game question");
        gameQuestion11.setCorrectAnswer("correct answer");
        gameQuestion11.setOtherAnswers_1("test1");
        gameQuestion11.setOtherAnswers_2("test2");
        gameQuestion11.setOtherAnswers_3("test1");
        gameQuestion11.setOtherAnswers_4("test1");

        gameQuestionsRepository.save(gameQuestion11);

        System.out.println("saved game questions");



    }
}
