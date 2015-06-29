package Com.gcit.training.libraryManagement.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Author {
	
	Connection conn;
	
	protected Author() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int authorId;
	private String authorName;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	protected void saveAuthorInfo(){
		try {
			String selectQuery = "select * from tbl_book";
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

			}
			rs.last();

			int authorId = rs.getInt("authorId");
			String authorName = rs.getString("authorName");

			this.authorId = authorId;
			this.authorName = authorName;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
