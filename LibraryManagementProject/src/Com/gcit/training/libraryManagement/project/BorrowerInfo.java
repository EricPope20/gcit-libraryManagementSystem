/**this class contains information for the borrower. The class will have a method
 * for checking out book, returning a book. Developer: Eric Ackaah, 6/27/15
 */
package Com.gcit.training.libraryManagement.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BorrowerInfo {
	// data fields
	private int cardNum;

	private int choice;
	private Book_Loans book;
	private LibraryBranch libraryBranch;

	protected BorrowerInfo() {
		Scanner in = new Scanner(System.in);

		// asking user to enter their card number and validating
		System.out.println("Enter the your Card Number:");

		cardNum = Integer.parseInt(in.nextLine());

		while (!isValid(cardNum)) {

			System.out.println("The Card Number you entered is not valid");
			cardNum = Integer.parseInt(in.nextLine());
		}

		System.out.println("What would you like to do...?"
				+ "\n-----------------------------" + "\n1)Check out a book "
				+ "\n2)Return a Book \n3)Quit to Previous");
		choice = Integer.parseInt(in.nextLine());

		// if user choose to check out book
		if (choice == 1) {
			System.out.println("\nPick the Branch you want to check out from: "
					+ "\n-------------------------------------");
			Connection conn;
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/library", "root", "");

				String selectQuery = "select * from tbl_library_branch";

				PreparedStatement pstmt = conn.prepareStatement(selectQuery);
				ResultSet rs = pstmt.executeQuery();

				int count = 1;

				// loop
				while (rs.next()) {
					System.out.println(count + ") "
							+ rs.getString("branchName") + ", "
							+ rs.getString("branchAddress"));
					count++;
				}
				System.out.println(count + ") Quit to previous");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// get the unser input and update the library
		choice = Integer.parseInt(in.nextLine());

		updateLibrary(choice);

		// user picking their choice of branch
		System.out.println("\nPick the Book you want to check out"
				+ "\n----------------------------------");

		// show the books in the chosen library
		Connection conn;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");

			String selectQuery = "select * from tbl_book NATURAL JOIN tbl_book_copies NATURAL JOIN tbl_library_branch NATURAL JOIN tbl_book_authors NATURAL JOIN tbl_author where branchId=?";

			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, libraryBranch.getBranchId());
			ResultSet rs = pstmt.executeQuery();

			int count = 1;

			// loop
			while (rs.next()) {
				System.out.println(count + ") " + rs.getString("title")
						+ " by " + rs.getString("authorName"));
				count++;
			}
			System.out.println(count + ") Quit to Cancel Operation");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		choice = Integer.parseInt(in.nextLine());
		System.out.println("You have checked out sucessfully");
		// saving in the book the user choose to check out
		bookUpdate(choice);
		//checkOut();
		// TODO check if the user doesn't enter number
	}

	// A method save the branch the user want to check out a book from
	private void updateLibrary(int choice) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			
			String selectQuery = "select * from tbl_library_branch";

			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			int count = 1;

			// loop
			while (rs.next()) {
				if (count == choice) {
					int branchId = rs.getInt("branchId");
					String branchName = rs.getString("branchName");
					String branchAddress = rs.getString("branchAddress");

					libraryBranch = new LibraryBranch(branchId, branchName,
							branchAddress);
				}
				count++;
			}
			System.out.println(count + ") Quit to previous");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// A method to save the book the user choose to check out
	private void bookUpdate(int choice) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			String selectQuery = "select * from tbl_book_loans";

			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			int count = 1;

			// loop
			while (rs.next()) {
				if (count == choice) {
					int bookId = rs.getInt("bookId");
					int branchId = rs.getInt("branchId");
					int cardNo = rs.getInt("cardNo");
					// String title = rs.getString("title");
					// int pubId = rs.getInt("pubId");

					book = new Book_Loans(bookId, branchId, cardNo);
				}
				count++;
			}
		} catch (SQLException e) {

		}
	}

	private boolean isValid(int cardNo) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			String selectQuery = "select * from tbl_borrower";
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (cardNo == rs.getInt("cardNo")) {
					return true;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// }

	// method to check out book
	protected void checkOut() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			Statement stmt = conn.createStatement();

			String insertQuery = "insert into tbl_book_loans (bookId,branchId,cardNo,dateOut) values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, book.getBookId());
			pstmt.setInt(2, book.getBranchId());
			pstmt.setInt(3, book.getCardNo());
			pstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			// pstmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));

			stmt.executeUpdate(insertQuery);

			/*
			 * while (rs.next()) { System.out
			 * .println("You check out the book "+ choice); }*
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method to return a book
	protected void returnBook() {

	}
}
