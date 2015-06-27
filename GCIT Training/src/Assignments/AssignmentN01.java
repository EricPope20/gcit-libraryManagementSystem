/**This is the first Assignment in the GCIT Training program that request
 * 1) user is asked a question to guess a number 
 * 2) if the number he guesses is within 10 numbers plus or minus of the
 *  number the java program has, then exit out and give the answer 
 *  3) if the number he guesses is not within 10 numbers, ask the user 
 *  to keep trying and give him more chances. 
 *  4) if he is not able to guess within 5 chances, 
 *  exit and display 'Sorry'
 *  Developer: Eric Ackaah, Date: June/22/15
 */

package Assignments;
import java.util.Scanner;

public class AssignmentN01 {
//declaring some data fields for the user and interval
	static int machineNumber, userGuess;
	int upperBound = machineNumber + 10;
	int lowerBound = machineNumber - 10;
	private Scanner input;
	
	public static void main(String[] args) {
		//instantiating
		AssignmentN01 myAssignment= new AssignmentN01();
		myAssignment.validateInput();
	}
	
	//a method to validating the user input
	public void validateInput(){
		
		input = new Scanner(System.in);
		//generating the random numbers between 0 to 100
		machineNumber = (int)(Math.random() * 101);
	
			System.out.println("Guess any Number from 0 to 100 !");
			while(!input.hasNextInt()){
			String sys = input.next();
			System.out.printf("'%s' is not a valid number ",sys);
			}
			userGuess = input.nextInt();
		
		//the user has only five times of checking their input
		userGuess = 1;
		int counter = 1;
		while(userGuess != machineNumber && counter < 5){
		
		   //condition to check if the input is in range
			if (userGuess <= lowerBound && userGuess >= upperBound) 
				/*(userGuess >= machineNumber && userGuess <= upperBound))**/{
				System.out.println("Your guess is in the range, the number is " +
						machineNumber);
				break;
			}
			
			
				//if not in range
				if(userGuess > machineNumber || userGuess > upperBound){
					System.out.println("Your guess is out of the range");
					System.out.println("Guess any Number from 0 to 100 !");
					userGuess = input.nextInt();
					
				}
				else if(userGuess < machineNumber || userGuess < lowerBound){
					System.out.println("Your guess is out of the range");
					System.out.println("Guess any Number from 0 to 100 !");
					userGuess = input.nextInt();
					
				} 
				
			counter++;
    
		if(counter == 5)
			System.out.println("Sorry, non of your guess was in the range "
					+ "the number is " + machineNumber);
	
  }
}	
}
