package com.codeAvengers.quizProject.Service.PlayerService;

import com.codeAvengers.quizProject.Model.Game;
import com.codeAvengers.quizProject.Model.GameQuestions;
import com.codeAvengers.quizProject.Model.Player;
import com.codeAvengers.quizProject.Repositories.GameQuestionsRepository;
import com.codeAvengers.quizProject.Repositories.GameRepository;
import com.codeAvengers.quizProject.Repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final GameQuestionsRepository gameQuestionsRepository;


  private static final int firstQuestion = 0;



    public PlayerService(PlayerRepository playerRepository, GameRepository gameRepository, GameQuestionsRepository gameQuestionsRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
        this.gameQuestionsRepository = gameQuestionsRepository;
    }

    // store question ID's
    ArrayList<Long> StoreQuestionIDs = new ArrayList<>();

    // store Correct Answers
    ArrayList<String> storeCorrectAnswers  = new ArrayList<>();

    // save the username
    public void savePlayerInputs(Player player){

        playerRepository.save(player);

    }

    // display game pin method
    public List<Game> displayGamePin(){

        return gameRepository.findAll();

    }

    // store game question id method
    public void getQuestionIDs(){

      ArrayList<GameQuestions> databaseResults = (ArrayList<GameQuestions>) gameQuestionsRepository.findAll();

      // add all the id's a list
      for (GameQuestions gameQuestions: databaseResults  )
      {
        Long id = gameQuestions.getId();
        StoreQuestionIDs.add(id);

      }

    }

    // display questions method
    public GameQuestions displayGameQuestions(){

      // get id with index 0 from the list
      // get question by id
      // remove the question we just displayed from the list
      // return the question
      Long questionId = StoreQuestionIDs.get(0);
      GameQuestions displayQuestion = gameQuestionsRepository.getById(questionId);
      StoreQuestionIDs.remove(questionId);

      return displayQuestion;

    }

    // check if th list is null.
    // if true returns a enum status NULL_RESULTS
    public EPlayerAnswerStatus listIsNull(){

      if (StoreQuestionIDs == null || StoreQuestionIDs.size() == 0){

        return EPlayerAnswerStatus.NULL_RESULTS;

      }
      return null;
    }


    public void verifyAnswers(String correctAnswer, String userAnswer){

           // check answers and options
          if (correctAnswer.equals(userAnswer)){
            storeCorrectAnswers.add(userAnswer);
          }

    }

    // return number of correct answers
    public Integer correctAnswers()
    {

      Integer numberOfCorrectAnswers = storeCorrectAnswers.size();

      return numberOfCorrectAnswers;
    }




}
