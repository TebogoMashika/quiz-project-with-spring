package com.codeAvengers.quizProject.Repositories;

import com.codeAvengers.quizProject.Model.LogIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogInRepository extends JpaRepository<LogIn,Long> {
    List<LogIn> findByUsername(String username);

}
