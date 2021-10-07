package com.codeAvengers.quizProject.Controllers;

import com.codeAvengers.quizProject.Model.LogIn;
import com.codeAvengers.quizProject.Model.QuizMaster;
import com.codeAvengers.quizProject.Repositories.LogInRepository;
import com.codeAvengers.quizProject.Repositories.QuizMasterRepository;
import com.codeAvengers.quizProject.Service.LoginService.LogInService;
import com.codeAvengers.quizProject.Service.LoginService.LogInStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginPageController {

    // attributes to perform dependency injection
    // this are interfaces which extend jpa repository
    private final LogInRepository logInRepository;
    private final QuizMasterRepository quizMasterRepository;
    private final LogInService logInService;


    // Constructor dependency injection
    public LoginPageController(LogInRepository logInRepository, QuizMasterRepository quizMasterRepository, LogInService logInService) {
        this.logInRepository = logInRepository;
        this.quizMasterRepository = quizMasterRepository;
        this.logInService = logInService;
    }

    // receive request from this link - "/QuizHomePage"
    // model attribute is logIn
    // return /LoginPage - (will be directed to this page)
    @RequestMapping(value = "/QuizHomePage")
    public String requestQuizHomePage(){
        return "/QuizHomePage";
    }

    // receive request from this link - "/LoginPage"
    // model attribute is logIn
    // return /LoginPage - (will be directed to this page)
    @RequestMapping(value = "/LoginPage")
    public String requestLogInPage(LogIn logIn){

        return "/LoginPage";
    }

    // receive request from this link - "/userLogInForm"
    // receives the @ModelAttribute("userLogInModel") from the link - "/userLogInForm"
    // LogInStatus - is an enum class that has all our statuses
    // pass username and password to the loginUser method in logInService class
    // displays the error if it exists

    @RequestMapping(value = "/userLogInForm")
    public String loginUserForm(@ModelAttribute("userLogInModel")  LogIn logIn, RedirectAttributes redirectAttributes){

        LogInStatus status = logInService.loginUser(logIn.getUsername(), logIn.getPassword());

        switch (status){
            case SUCCESS -> {
                return "redirect:/QuizMasterHomePage";
            }

            case FAILURE -> {
                redirectAttributes.addFlashAttribute("errorMessage", "Username or Password incorrect please try again");
                return "redirect:/LoginPage" ;
            }
        }

        return null;
    }

    //quizMaster - is a model attribute which will be passed as an object on the registerPage form
    //if we don't pass the model attribute (quizMaster) to the template - the page will give a results binding error
    // do not pass QuizMaster as the is the model - pass the model attribute (quizMaster)
    // receive request from this link - "/registerUser"
    // return "/registerPage" - (will be directed to this page)
    @RequestMapping(value = "/registerUser")
    public String requestRegisterPage( QuizMaster quizMaster){

        // display the registerPage
        return "/registerPage" ;

    }

    // receive request from this link - "/registerUserForm"
    // receives the @ModelAttribute("quizMaster") from the link - "/registerUserForm"
    // LogInStatus - is an enum class that has all our statuses
    // pass firstname, last name and email to the registerUser method in logInService class
    // displays the error if it exists
    // if status is SUCCESS we save the results to the database and redirect user to the /registerUserLogins.html page
    @RequestMapping(value = "/registerUserForm")
    public String registerNewUserForm(@ModelAttribute("quizMaster")  QuizMaster quizMaster, RedirectAttributes redirectAttributes){

        LogInStatus status = logInService.registerUser(quizMaster.getFirstName(), quizMaster.getLastName(), quizMaster.getEmail());

        switch (status){
            case USER_ALREADY_EXISTS -> {
                redirectAttributes.addFlashAttribute("errorMessage", "User already exists");
                return "redirect:/registerUser" ;

            }
            case SUCCESS -> {
                quizMasterRepository.save(quizMaster);

                quizMaster.getLogIn();
                return "redirect:/registerUserLogins.html";
            }
        }

        return null;
    }

    // receive request from this link - {"/registerUserLogins.html", "/registerUserLogins"
    // model attribute is logIn
    // return "/registerUserLogins.html" - (will be directed to this page)
    @RequestMapping({"/registerUserLogins.html", "/registerUserLogins"})
    public String requestRegisterNewUserLoginsPage(LogIn logIn){

        return "/registerUserLogins.html" ;

    }

    // receive request from this link - "/registerNewUserLogInsForm"
    // model attribute is logIn
    // save the model to the database
    // return "/LoginPage" - (will be directed to this page)
    @RequestMapping(value = "/registerNewUserLogInsForm")
    public String newUserLogins(LogIn logIn){

        logInService.saveLogInDetails(logIn);

        return "redirect:/LoginPage" ;

    }

    // receive request from this link - "/QuizMasterHomePage"
    // model attribute is quizMaster
    // return "/quizMasterHome.html" - (will be directed to this page)
    @RequestMapping("/QuizMasterHomePage") // receive request from this link
    public String requestQuizMasterHomePage(QuizMaster quizMaster){

        return "/quizMasterHome.html" ;

    }






}
