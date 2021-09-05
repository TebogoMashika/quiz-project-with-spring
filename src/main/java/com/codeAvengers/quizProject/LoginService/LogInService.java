package com.codeAvengers.quizProject.LoginService;

import com.codeAvengers.quizProject.Model.LogIn;
import com.codeAvengers.quizProject.Model.QuizMaster;
import com.codeAvengers.quizProject.Repositories.LogInRepository;
import com.codeAvengers.quizProject.Repositories.QuizMasterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// service class - will be picked up on the start as part of the component
// has all the business logic
@Service
public class LogInService {

    // attributes to perform dependency injection
    // this are interfaces which extend jpa repository
    private final LogInRepository logInRepository;
    private final QuizMasterRepository quizMasterRepository;

    // Constructor dependency injection
    public LogInService(LogInRepository logInRepository, QuizMasterRepository quizMasterRepository) {
        this.logInRepository = logInRepository;
        this.quizMasterRepository = quizMasterRepository;
    }


    // log in user method
    public LogInStatus loginUser(String username, Integer password){

        List<LogIn> dataBaseResults  = logInRepository.findByUsername(username);

        for (LogIn user: dataBaseResults){

            String databaseUsername = user.getUsername();
            Integer databasePassword = user.getPassword();

            if (databaseUsername.equals(username) && databasePassword.equals(password)){
                return LogInStatus.SUCCESS;

            }else {
                return LogInStatus.FAILURE;

            }

        }

        return null;
    }

    // register user method
    public LogInStatus registerUser(String firstname, String lastname, String email){

        List<QuizMaster> dataBaseResults = quizMasterRepository.findAll();

        for (QuizMaster user: dataBaseResults){

            String resultsFirstname = user.getFirstName();
            String resultsLastname = user.getLastName();
            String resultsEmail = user.getEmail();

            if (resultsFirstname.equals(firstname) && resultsLastname.equals(lastname) && resultsEmail.equals(email)){
                return LogInStatus.USER_ALREADY_EXISTS;
            }else {
                return LogInStatus.SUCCESS;
            }
        }


        return null;
    }


}
