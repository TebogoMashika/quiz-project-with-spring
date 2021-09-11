package com.codeAvengers.quizProject.Repositories;

import com.codeAvengers.quizProject.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
