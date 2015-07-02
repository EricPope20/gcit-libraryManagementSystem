/**Create a library management application on the Command Line which will follow
 *the following protocol.Welcome to the GCIT Library Management System. 
 *Which category of a user are you 1)Librarian 2)Administrator 3)Borrower 
 *take input Based on what the user selects.
 *Developer Eric Ackaah, Date: June/24/16
 */

package Com.gcit.training.libraryManagement.project;

import java.util.Scanner;

public class LibraryManagement {
	// fields for constant recall
	private static int librarian = 1;
	private static final int administrator = 2;
	private static final int borrower = 3;

	//constructor
	public LibraryManagement() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		firstPageReturn();

	}

	static int userStatus;

	// the first page to display
	protected static void firstPageReturn() {
		String userString;

		System.out.println("Welcome to the GCIT Library Management System");
		System.out.println("---------------------------------------------\n1)."
				+ "Librarian \n2).Administrator\n3).Borrower");
		System.out.println("Which category of a user are you.?");

		// getting input
		Scanner in = new Scanner(System.in);
		userStatus = in.nextInt();

		// based on their status this will help determine the class to invoke
		while (userStatus <= 0) {
			if (userStatus == 0) {
				System.out
						.println("Sorry, your category must be between 1 to 3");
				System.out.println("Which category of user are you.?");
				userStatus = in.nextInt();
			}
		}

		// invoking the user category method
		userCategory();
	}

	// the method to determine the user category
	private static void userCategory() {

		Scanner input = new Scanner(System.in);
		String userString = " ";

		// if user is librarian
		if (userStatus == 1) {
			System.out.println("You choose a category of " + librarian
					+ ", Librarian, do you want to continue? (y/n)");
			userString = input.nextLine();

			// if the user decides to move on
			if (userString.toLowerCase().equals("y")) {
				LibrarianInfo librarian = new LibrarianInfo();
				librarian.lib1Menu();
				firstPageReturn();

			}
			if (userString.toLowerCase().equals("n"))
				firstPageReturn();
			// validate
			if (!userString.toLowerCase().equals("y")
					|| !userString.toLowerCase().equals("n")) {
				System.out.println("Sorry you have entered invalid response");

			}
			// firstPageReturn();
		}
		// if the user is administrator
		else if (userStatus == 2) {
			System.out.println("You choose a category of, " + administrator
					+ " Administrator, do you want to continue? (y/n)");
			userString = input.nextLine();
			// if the user decides to move on
			while (userString.toLowerCase().equals("y")) {
				AdministratorInfo myAD = new AdministratorInfo();
				myAD.initialMenu();
				break;

			} // if the input is no
			if (userString.toLowerCase().equals("n"))
				firstPageReturn();
		}

		// if the user is Borrower
		else if (userStatus == 3) {
			System.out.println("You choose a category of, " + borrower
					+ " Borrower, do you want to continue? (y/n)");
			userString = input.nextLine();
			// if the user decides to move on
			while (userString.toLowerCase().equals("y")) {
				BorrowerInfo borr = new BorrowerInfo();
				borr.initialCall();
				break;

			} // if the input is no
			if (userString.toLowerCase().equals("n"))
				firstPageReturn();
		}
	}

}
