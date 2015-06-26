/**This class display the various library branches to the user and they choose 
 * Based on their selection. Developer: Eric Ackaah , Date: June/24/2015
 */
package Com.gcit.training.libraryManagement.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibrarianInfo {
	//data fields
	private static final int userChoice = 0;
	//constructor
	public LibrarianInfo(){
		try {
			//displaying the available branches to the user
			System.out.println("Here are the available Library Branches");
			System.out.println("---------------------------------------");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			Statement stmt = conn.createStatement();
			String selectQuery = "select * from tbl_library_branch";
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			//loop
			while(rs.next()){
				System.out.println("Branch Name: " +rs.getString("branchName"));
				System.out.println("Branch Address: " +rs.getString("branchAddress"));
				System.out.println("-----------------------------");
			}
			//making selection
			Scanner scan = new Scanner(System.in);
			System.out.println("Select the Library Branch you want to update:");
			String libBranch = scan.nextLine();
			
			//condition
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}




