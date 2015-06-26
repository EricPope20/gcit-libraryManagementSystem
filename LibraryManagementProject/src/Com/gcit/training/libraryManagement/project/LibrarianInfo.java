/**This class display the various library branches to the user and they choose 
 * Based on their selection. Developer: Eric Ackaah , Date: June/24/2015
 */
package Com.gcit.training.libraryManagement.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibrarianInfo {
	// data fields
	private String userString = "";

	// constructor
	public LibrarianInfo() {
		try {
			// displaying the available branches to the user
			System.out.println("Here are the available Library Branches");
			System.out.println("---------------------------------------");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
			// Statement stmt = conn.createStatement();
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

				break;
			case 2:

			default:
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
