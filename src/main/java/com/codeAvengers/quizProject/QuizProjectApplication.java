package com.codeAvengers.quizProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizProjectApplication.class, args);
	}


	// THIS PART GENERATES THE 5 RANDOM NUMBERS FOR THE GAME PIN..

	//int gamePin = getRandomInt(100000, 10000);
	//System.out.println("Your game pin is: " + gamePin);

	/* * returns random integer between minimum and maximum range */
	//public static int getRandomInt(int maximum, int minimum) {
		//return ((int) (Math.random() * (maximum - minimum))) + minimum;
	//}


}