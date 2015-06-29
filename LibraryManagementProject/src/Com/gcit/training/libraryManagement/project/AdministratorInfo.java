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

	private Book book;
	private Author author;

	protected AdministratorInfo() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void initialMenu() {
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

			// if the user decide to add/insert
			if (userChoice == 1) {
				addBookandAuthor();
			}
		}

	}

	// method for author
	private void addBookandAuthor() {
		System.out.println("Enter book title");
		String title = input.nextLine();

		System.out.println("Enter Author name");
		String authorName = input.nextLine();

		addToBook(title);
		addToAuthor(authorName);

		
		book = new Book();
		book.saveBookInfo();
		
		author=new Author();
		author.saveAuthorInfo();
		
		
		
		 addToBookAuthors();
		
	}
	
	//add to author
	private void addToAuthor(String authorName){
		try {
			String createQuery = "insert into tbl_author (authorName) values(?)";

			PreparedStatement pstmt = conn.prepareStatement(createQuery);
			pstmt.setString(1, authorName);

			pstmt.executeUpdate();

			System.out.println("successfully added Author");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// addToBookAuthors();
	private void addToBookAuthors(){
		try {
			String createQuery = "insert into tbl_book_authors values(?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(createQuery);
			pstmt.setInt(1, book.getBookId());
			pstmt.setInt(2, author.getAuthorId());
			pstmt.setString(3, author.getAuthorName());
			
			pstmt.executeUpdate();

			System.out.println("successfully added author");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** add a book to the book table. */
	private void addToBook(String title) {
		try {
			String createQuery = "insert into tbl_book (title) values(?)";

			PreparedStatement pstmt = conn.prepareStatement(createQuery);
			pstmt.setString(1, title);

			pstmt.executeUpdate();

			System.out.println("successfully added book");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
