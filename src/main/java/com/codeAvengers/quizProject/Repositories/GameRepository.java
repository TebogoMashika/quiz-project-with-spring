package com.codeAvengers.quizProject.Repositories;

import com.codeAvengers.quizProject.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
