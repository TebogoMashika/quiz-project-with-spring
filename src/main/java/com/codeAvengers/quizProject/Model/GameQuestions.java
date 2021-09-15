package com.codeAvengers.quizProject.Model;

import javax.persistence.*;

@Entity
@Table(name = "Questions")
public class GameQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "question")
    private String question;
    @Column(name = "CorrectAnswer")
    private String CorrectAnswer;
    @Column(name = "OtherAnswers_1")
    private String OtherAnswers_1;
    @Column(name = "OtherAnswers_2")
    private String OtherAnswers_2;
    @Column(name = "OtherAnswers_3")
    private String OtherAnswers_3;
    @Column(name = "OtherAnswers_4")
    private String OtherAnswers_4;

    public GameQuestions() {
    }

    public GameQuestions(String question, String correctAnswer, String otherAnswers_1, String otherAnswers_2, String otherAnswers_3, String otherAnswers_4) {
        this.question = question;
        CorrectAnswer = correctAnswer;
        OtherAnswers_1 = otherAnswers_1;
        OtherAnswers_2 = otherAnswers_2;
        OtherAnswers_3 = otherAnswers_3;
        OtherAnswers_4 = otherAnswers_4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public String getOtherAnswers_1() {
        return OtherAnswers_1;
    }

    public void setOtherAnswers_1(String otherAnswers_1) {
        OtherAnswers_1 = otherAnswers_1;
    }

    public String getOtherAnswers_2() {
        return OtherAnswers_2;
    }

    public void setOtherAnswers_2(String otherAnswers_2) {
        OtherAnswers_2 = otherAnswers_2;
    }

    public String getOtherAnswers_3() {
        return OtherAnswers_3;
    }

    public void setOtherAnswers_3(String otherAnswers_3) {
        OtherAnswers_3 = otherAnswers_3;
    }

    public String getOtherAnswers_4() {
        return OtherAnswers_4;
    }

    public void setOtherAnswers_4(String otherAnswers_4) {
        OtherAnswers_4 = otherAnswers_4;
    }
}
