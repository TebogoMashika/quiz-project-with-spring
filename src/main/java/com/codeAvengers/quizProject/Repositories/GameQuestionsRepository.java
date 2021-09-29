package com.codeAvengers.quizProject.Repositories;

import com.codeAvengers.quizProject.Model.GameQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameQuestionsRepository extends JpaRepository<GameQuestions,Long> {
  //void findById(String[] );
}
