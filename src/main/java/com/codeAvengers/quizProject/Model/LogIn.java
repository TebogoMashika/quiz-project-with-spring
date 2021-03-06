package com.codeAvengers.quizProject.Model;

import javax.persistence.*;
import java.util.Objects;

// table with the name "login" will be created in the database
@Entity
@Table(name = "login")
public class LogIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private Integer password;

    // task pending - improve the one to one relationship
    @OneToOne(mappedBy = "logIn")
    private QuizMaster quizMaster;


    public LogIn() {
    }

    public LogIn(String username, Integer password, QuizMaster quizMaster) {
        this.username = username;
        this.password = password;
        this.quizMaster = quizMaster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public QuizMaster getQuizMaster() {
        return quizMaster;
    }

    public void setQuizMaster(QuizMaster quizMaster) {
        this.quizMaster = quizMaster;
    }
}
