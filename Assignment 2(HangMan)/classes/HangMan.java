package eg.edu.alexu.csd.datastructure.hangman.cs70;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class HangMan implements IHangman{

	 String [] Arr= new String[84100];
	 String word;
	 String secword; 
	 int maxguess;
	 char[] temp=new char[50];	
	 int counter=0;
	 String [] Arr2;

	public void Helpingfun() {
	
	Arr2=ReadFile("Dic.txt");
	
	setDictionary(Arr2);
	
	word=selectRandomSecretWord();
	
	secword=String.copyValueOf(temp);
  }

@Override

	public void setMaxWrongGuesses(int max) {
		if(max<0) {
			maxguess=1;
		}
		else {
			maxguess = max;	
		}
		
	}
	
@Override
	public void setDictionary(String[] words) {

	Arr=words;

}
	
	public String[] ReadFile (String file)  {
		
		int counter=0;

		String Line;
		BufferedReader br=null;
		BufferedReader br1=null;
		try {	
			br= new BufferedReader(new FileReader(file));
			while((Line=br.readLine())!=null) {
				counter ++;
			}
			
			String Arr[]=new String[counter];
			br1= new BufferedReader(new FileReader(file));
			for(int i=0;i<counter;i++) {
				Arr[i]=br1.readLine();
			}
			return Arr;
		}
		catch(IOException e) {
			System.out.println("There is an error");
			return null;
		}
}

	@Override
	public String selectRandomSecretWord() {
		int index;
		Random Ind = new Random();
		index = Ind.nextInt(48096);
		String wrd =Arr[index];
		for(int i=0;i<wrd.length();i++) {
			temp[i]='-';
			
		}
		return wrd;
	}

	@Override
	public String guess(char c) throws Exception {
		try {
			if(Character.isLetter(c)) {
				
				for(int i=0 ;i<word.length();i++) {
					
					if(c==word.charAt(i)&&temp[i]=='-') {
						temp[i]=c;
						secword=String.copyValueOf(temp);
						counter++;
						if (counter==word.length()) {
							System.out.println("That's shown for Test :"+ word);
							System.out.println("Congratualtion you win!");
							return null;
						}
						System.out.println(secword);
						System.out.println("That's shown for Test :"+ word);
						System.out.println("Trial Left:"+ maxguess);
						return secword;
					}
					
					}
			}

			System.out.println(secword);
			maxguess--;
			
			if (maxguess!=0) {
				System.out.println("That's shown for Test :"+ word);
				System.out.println("Trials Left:"+ maxguess);
				return secword;
			}
			else {
				System.out.println("Trials Left:"+ maxguess);
				System.out.println("That's shown for Test :"+ word);
				System.out.println("You lost !");
				return null;
			}
			
			

			}
			
			catch(Exception e) {
				maxguess--;
				System.out.println("Error !");
					return null;
			}
			
			
	}
}
