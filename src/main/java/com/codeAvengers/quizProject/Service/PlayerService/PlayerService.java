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

    ArrayList<Long> results = new ArrayList<>();

    // save the username
    public void savePlayerInputs(Player player){

        playerRepository.save(player);

    }

    // display game pin method
    public List<Game> displayGamePin(){

        return gameRepository.findAll();

    }

    // store game question id method
    public void storeGameQuestionIDs(){

      ArrayList<GameQuestions> databaseResults = (ArrayList<GameQuestions>) gameQuestionsRepository.findAll();

      // add all the id's a list
      for (GameQuestions gameQuestions: databaseResults  )
      {
        Long id = gameQuestions.getId();
        results.add(id);

      }

    }

    // display questions method
    public GameQuestions displayGameQuestions(){

      // get id with index 0 from the list
      // get question by id
      // remove the question we just displayed from the list
      // return the question
      Long questionId = results.get(0);
      GameQuestions displayQuestion = gameQuestionsRepository.getById(questionId);
      results.remove(questionId);

      return displayQuestion;

    }

    // check if th list is null.
    // if true returns a enum status NULL_RESULTS
    public EPlayerAnswerStatus listIsNull(){

      if (results == null || results.size() == 0){

        return EPlayerAnswerStatus.NULL_RESULTS;

      }

      return null;
    }


    public ArrayList<EPlayerAnswerStatus> verifyAnswers(String[] id, String[] answer1, String[] answer2, String[] answer3, String[] answer4){

        ArrayList<EPlayerAnswerStatus> results = new ArrayList<>();

        // goes through each id and
        for (String val : id){

            // get game question columns by id
           Optional<GameQuestions> databaseResults =  gameQuestionsRepository.findById(Long.parseLong(val));


           // get database results
            String correctAnswer= databaseResults.get().getCorrectAnswer();

            EPlayerAnswerStatus one  = verifyColumn(answer1, correctAnswer);

            EPlayerAnswerStatus two  = verifyColumn(answer2, correctAnswer);

            EPlayerAnswerStatus three  =verifyColumn(answer3, correctAnswer);

            EPlayerAnswerStatus four = verifyColumn(answer4, correctAnswer);


            if (one == EPlayerAnswerStatus.CORRECT || one == EPlayerAnswerStatus.NO_INPUT || one == EPlayerAnswerStatus.INCORRECT ){
              results.add(one);
            }
            if (two == EPlayerAnswerStatus.CORRECT || two == EPlayerAnswerStatus.NO_INPUT || two == EPlayerAnswerStatus.INCORRECT ){
              results.add(one);
            }
            if (three == EPlayerAnswerStatus.CORRECT || three == EPlayerAnswerStatus.NO_INPUT || three == EPlayerAnswerStatus.INCORRECT ){
              results.add(one);
            }
            if (four == EPlayerAnswerStatus.CORRECT || four == EPlayerAnswerStatus.NO_INPUT || four == EPlayerAnswerStatus.INCORRECT ){
              results.add(one);
            }

        }
        return results;
    }

    private EPlayerAnswerStatus verifyColumn(String[] answer, String correctAnswer)
    {
        if (answer != null){

            List<String> answersFromColumn = Arrays.asList(answer);


            if (answersFromColumn.contains(correctAnswer)){

                return EPlayerAnswerStatus.CORRECT;

            }else{
              return EPlayerAnswerStatus.INCORRECT;
            }


        }else if (answer == null){

            return EPlayerAnswerStatus.NO_INPUT;
        }

        return null;
    }




}
