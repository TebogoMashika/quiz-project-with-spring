package com.codeAvengers.quizProject.LoadData;

import com.codeAvengers.quizProject.Model.LogIn;
import com.codeAvengers.quizProject.Model.QuizMaster;
import com.codeAvengers.quizProject.Repositories.LogInRepository;
import com.codeAvengers.quizProject.Repositories.QuizMasterRepository;
import com.codeAvengers.quizProject.LoginService.LogInService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Data implements CommandLineRunner {

    private final QuizMasterRepository quizMasterRepository;
    private final LogInRepository logInRepository;
    private final LogInService logInService;

    public Data(QuizMasterRepository quizMasterRepository, LogInRepository logInRepository, LogInService logInService) {
        this.quizMasterRepository = quizMasterRepository;
        this.logInRepository = logInRepository;
        this.logInService = logInService;
    }


    @Override
    public void run(String... args) throws Exception {

        QuizMaster quizMaster = new QuizMaster();

        quizMaster.setFirstName("user");
        quizMaster.setLastName("user lastName");
        quizMaster.setEmail("user@gmail.com");

        quizMasterRepository.save(quizMaster);

        System.out.println("registered quiz Master");

        LogIn user = new LogIn();


        user.setUsername("user");
        user.setPassword(1234);
        logInRepository.save(user);

        System.out.println("user logged in");

        //logInService.checkUserIsLoggedIn(user);






    }
}
