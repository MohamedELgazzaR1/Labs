package eg.edu.alexu.csd.datastructure.hangman.cs70;

import java.util.Scanner;

public class Testing {
	 
	public static void main(String[] args) {
	try {
		char guessed;
		int guess;
		HangMan Test=new HangMan();					//ASSIGNING OBJECT FROM THE CLASS
		
		Scanner input=new Scanner(System.in);
		System.out.println("Please Enter number of guesses");			//TAKING THE MAXIMUM NUMBER OF WRONG GUESSES 								
		guess=input.nextInt();	
		
		Test.setMaxWrongGuesses(guess);							
		
		Test.Helpingfun();
		
		while(true) {
			
			System.out.println("Please Enter your Guess");					//TAKING IN THE GUESSED CHARACTER
			guessed=input.next().charAt(0);							
			guessed = Character.toLowerCase(guessed);	
			if(Test.guess(guessed) == null) {								
				break;														// CASE OF ENDING THE GAME
			}
		}
		
	}
	
	catch(Exception e) {
	System.out.println("invalid");	
	}
	}
	}
