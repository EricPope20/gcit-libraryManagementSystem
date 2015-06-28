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

	// constructor
	public LibrarianInfo() {
		try {
			// displaying the available branches to the user
			System.out.println("Here are the available Library Branches");
			System.out.println("---------------------------------------");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			String selectQuery = "select * from tbl_library_branch";

			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			int count = 1;
			// loop
			while (rs.next()) {
				System.out.println(count + ") " + rs.getString("branchName")
						+ ", " + rs.getString("branchAddress"));
				count++;
			}
			System.out.println(count + ") Quit to previous");

			// making selection
			Scanner scan = new Scanner(System.in);
			System.out
					.println("Select the Library Branch you want to update based on their number");
			int libBranch = scan.nextInt();
			scan.nextLine();

			// using switch condition to take the user input
			switch (libBranch) {
			case 1:

				System.out
						.println("You selected the University Library,"
								+ "do you want to:\n1) Update the details of the Library"
								+ "\n2)Add copies of Book to the Branch\n"
								+ "3)Quit to previous");
				userString = scan.nextLine();
				
				// update the details of the library
				if (userString == "1") {
					scan.nextLine();
					updateQuery();
				}
				// add add copies of book to the branch
				else if (userString.equals(2)) {

				}

				// return to previous page
				else if (userString.equals(3)) {

				}
				break;
			case 2:

			default:
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// method to update
	private static void updateQuery() {
		Scanner userScan = new Scanner(System.in);
		Connection upConn;
		try {
			System.out.println("You have chosen to update the Branch "
					+ "with Branch Id:1 and Branch Name:University Library");
			
			System.out.println("Please enter new branch name or enter N/A for no change");
			userString = userScan.nextLine();
			
			//if the user enter a new name
			
			upConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			String updateQuery = "update tbl_library_branch branchName= ?";
			PreparedStatement ups = upConn.prepareStatement(updateQuery);
			ups.setString(1, userString);
			int execute = ups.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
