package com.codeAvengers.quizProject.Controllers;

import com.codeAvengers.quizProject.Model.GameQuestions;
import com.codeAvengers.quizProject.Repositories.GameQuestionsRepository;
import com.codeAvengers.quizProject.Service.GameQuestionService.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionsController {

    private final GameQuestionsRepository gameQuestionsRepository;
    private final QuestionService questionService;

    public QuestionsController(GameQuestionsRepository gameQuestionsRepository, QuestionService questionService) {
        this.gameQuestionsRepository = gameQuestionsRepository;
        this.questionService = questionService;
    }

    //@RequestMapping("/requestGameQuestions")
    //public String requestQuestionsPage(){

       // return "/templates/GameTemplates/GameQuestions/questions.html";

    //}


    @RequestMapping("/submitQuestions")
    public String submitQuestions(@RequestParam(value = "question") String question,
                                  @RequestParam(value = "CorrectAnswer") String CorrectAnswer,
                                  @RequestParam(value = "OtherAnswers_1") String OtherAnswers_1,
                                  @RequestParam(value = "OtherAnswers_2") String OtherAnswers_2,
                                  @RequestParam(value = "OtherAnswers_3") String OtherAnswers_3,
                                  @RequestParam(value = "OtherAnswers_4") String OtherAnswers_4,
                                  GameQuestions gameQuestions){

        questionService.saveGameQuestions(gameQuestions);

        return "/GameTemplates/GameQuestions/questions.html";

    }



}
