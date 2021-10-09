package com.codeAvengers.quizProject.Service.GameQuestionService;

import com.codeAvengers.quizProject.Model.GameQuestions;
import com.codeAvengers.quizProject.Repositories.GameQuestionsRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {


    private final GameQuestionsRepository gameQuestionsRepository;


    public QuestionService(GameQuestionsRepository gameQuestionsRepository) {
        this.gameQuestionsRepository = gameQuestionsRepository;
    }

    // save questions
    public void saveGameQuestions(GameQuestions gameQuestions){


        gameQuestionsRepository.save(gameQuestions);
    }

}
