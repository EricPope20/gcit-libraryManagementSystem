/**This class display the various library branches to the user and they choose 
 * Based on their selection. Developer: Eric Ackaah , Date: June/24/2015
 */
package Com.gcit.training.libraryManagement.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarianInfo {
	// data fields
	private static String userString = "";
	private ResultSet rs;
	private LibraryBranch library;
	private Book book;
	Connection conn;
	Scanner scan = new Scanner(System.in);
	
	// constructor
	public LibrarianInfo() {
		
		//creating of one time connection for the class
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//the first menu for the library
	public void lib1Menu() {

		System.out.println("1) Enter Branch you manage");
		System.out.println("2) Quit to previous");
		
		//taking the user input
		int choice = Integer.parseInt(scan.nextLine());
		if (choice == 2) {
			// quit if the user decide to go back to previous menu
			return;
		}
		
		//when the user decide to move on, call the second menu
		lib2Menu();

	}
	
	//second menu
	private void lib2Menu() {
		
		//invoking the display libraries method to show various libraries available
		int count = displayLibraries();
		int libBranch = scan.nextInt();
		scan.nextLine();

		if (libBranch == count) {
			// quit or return to first menu
			lib1Menu();
		}
		
		//keeping the library info for future reference
		saveBranchInfo(libBranch);

		lib3Menu();
	}
	
	//third menu for librarian
	private void lib3Menu() {
		System.out.println("1)Update the details of the Library"
				+ "\n2)Add copies of Book to the Branch\n"
				+ "3)Quit to previous");
		userString = scan.nextLine();

		if (userString.equals("1")) {
			updateQuery();
		} else if (userString.equals("2")) {
			// add copies of book to the branch
			addQuery();
		} else {
			lib2Menu();
		}

		// scan.nextLine();

	}

	private void addQuery() {
		System.out
				.println("Pick the Book you want to add copies of to your branch:");
		int countBooks = displayBooksInLibrary();
		int bookChoice = Integer.parseInt(scan.nextLine());

		if (countBooks == bookChoice) {
			lib3Menu();
		}

		saveBookInfo(bookChoice);
		//variable to hold the book copies
		int numCopies = bookCopies();

		System.out.println("Existing number of copies: " + numCopies);

		System.out.println("Enter new number of copies:");

		int newNumCopies = Integer.parseInt(scan.nextLine());
		
		//add the new copies of the book to the existing 
		updateBookCopies(newNumCopies + numCopies);
		
		lib3Menu();

	}

	private void updateBookCopies(int newNumCopies) {
		Connection upConn;
		try {
			upConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");

			String updateQuery = "update tbl_book_copies set noOfCopies=? where bookId=?";

			PreparedStatement ups = upConn.prepareStatement(updateQuery);
			ups.setInt(1, newNumCopies);
			ups.setInt(2, book.getBookId());

			ups.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ups.setString(1, branchName);
		// ups.setString(2, branchAddress);
		// ups.setInt(3, library.getBranchId());

	}

	// getting the number of book copies
	private int bookCopies() {
		int numCopies = 0;
		try {

			String selectQuery = "select * from tbl_book_copies where bookId=?";

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, book.getBookId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				numCopies = rs.getInt("noOfCopies");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numCopies;
	}

	// method to update
	private void updateQuery() {
		Connection upConn;
		try {
			System.out
					.println("You have chosen to update the Branch with Branch Id: "
							+ library.getBranchId()
							+ " and Branch Name: "
							+ library.getBeranchName());

			System.out
					.println("Enter 'quit' at any prompt to cancel operation.");

			System.out
					.println("Please enter new branch name or enter N/A for no change");
			String branchName = scan.nextLine();
			if (branchName.equals("quit")) {
				lib3Menu();
			}

			System.out
					.println("Please enter new branch address or enter N/A for no change:");
			String branchAddress = scan.nextLine();
			if (branchAddress.equals("quit")) {
				lib3Menu();
			}

			// executing the update
			upConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			String updateQuery = "update tbl_library_branch set branchName=?, branchAddress=? where branchId=?";

			PreparedStatement ups = upConn.prepareStatement(updateQuery);

			ups.setString(1, branchName);
			ups.setString(2, branchAddress);
			ups.setInt(3, library.getBranchId());

			ups.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//display the libraries available for selection
	private int displayLibraries() {
		System.out.println("Here are the available Library Branches");
		System.out.println("---------------------------------------");
		//counter
		int count = 0;
		
		try {
			String selectQuery = "select * from tbl_library_branch";
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();
			
			//want count to start from one to number the library
			count = 1;
			// loop
			while (rs.next()) {
				System.out.println(count + ") " + rs.getString("branchName")
						+ ", " + rs.getString("branchAddress"));
				count++;
			}
			
			System.out.println(count + ") Quit to previous");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	//method to save the branch information
	private void saveBranchInfo(int libBranch) {
		try {
			//moving the cursor in front of the result set
			rs.beforeFirst();

			int count = 1;
			while (rs.next()) {
				if (count == libBranch) {
					int branchId = rs.getInt("branchId");
					String branchName = rs.getString("branchName");
					String branchAddress = rs.getString("branchAddress");

					library = new LibraryBranch();
					library.setBranchId(branchId);
					library.setBeranchName(branchName);
					library.setBranchAddress(branchAddress);

					break;

				}
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//method to display the books in the library
	private int displayBooksInLibrary() {
		int count = 0;
		try {

			String selectQuery = "select * from tbl_book NATURAL JOIN tbl_book_copies NATURAL JOIN tbl_library_branch NATURAL JOIN tbl_book_authors NATURAL JOIN tbl_author where branchId=?";
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, library.getBranchId());
			rs = pstmt.executeQuery();

			count = 1;
			// loop
			while (rs.next()) {
				System.out.println(count + ") " + rs.getString("title")
						+ " by " + rs.getString("authorName"));
				count++;
			}
			System.out.println("\n" + count + ") Quit to Cancel Operation");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	//method to save branch info
	private void saveBookInfo(int bookChoice) {
		try {
			rs.beforeFirst();

			int count = 1;
			while (rs.next()) {
				if (count == bookChoice) {
					int bookId = rs.getInt("bookId");
					String title = rs.getString("title");
					int pubId = rs.getInt("pubId");

					book = new Book();
					book.setBookId(bookId);
					book.setTitle(title);
					book.setPubId(pubId);

					break;

				}
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
