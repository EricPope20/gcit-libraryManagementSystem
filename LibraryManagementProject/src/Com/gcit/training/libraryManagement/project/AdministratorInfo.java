/**
 * 
 */
package Com.gcit.training.libraryManagement.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdministratorInfo {
	int userChoice;
	int authorId;
	String authorName;
	Connection conn;
	Scanner input;
	protected AdministratorInfo() {
		input = new Scanner(System.in);
		// displaying the functions of the administrator
		System.out
				.println("Hello!, what would you like to do:\n------------------------------------"
						+ "\n1)Add/Update/Delete Book and Author "
						+ "\n2)Add/Update/Delete Publishers "
						+ "\n3)Add/Update/Delete Library Branches "
						+ "\n4)Add/Update/Delete Borrowers \n5)Over-ride Due Date for a Book Loan");

		// accepting the user input
		userChoice = Integer.parseInt(input.nextLine());

		// checking if the user want to add or update or delete book & author
		if (userChoice == 1) {
			System.out
					.println("What do you want to do:\n1)Add, \n2)Update \n3)Delete Book and Author");
			userChoice = Integer.parseInt(input.nextLine());
			
			//if the user decide to add/insert 
			if(userChoice == 1){
				addBookandAuthor();
			}
		}

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			Statement stmt = conn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// method for author
	private void addBookandAuthor() {
			try {
				//Statement stmt = conn.createStatement();
				System.out.println("Enter a new Author id, this must be a number:");
				userChoice = Integer.parseInt(input.nextLine());
				System.out.println("Enter a new Author Name:");
				String authName = input.nextLine();
				String createQuery = "insert into tbl_author (authorId, authorName) values?";
				PreparedStatement pstmt = conn.prepareStatement(createQuery);
				pstmt.setInt(1, userChoice);
				pstmt.setString(2, authName);
				
				pstmt.executeUpdate(createQuery);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//stmt.executeUpdate(createQuery);
	}

	// method for book
	private void book() {

	}

	// method for publisher
	private void publisher() {

	}

	// method for library branch
	private void libraryBranches() {

	}

	// method for borrowers
	private void borrowers() {

	}
}
