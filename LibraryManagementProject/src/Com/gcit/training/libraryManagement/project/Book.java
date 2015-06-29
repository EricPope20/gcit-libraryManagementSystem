package Com.gcit.training.libraryManagement.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {

	private int bookId;
	private String title;
	private int pubId;

	Connection conn;

	protected Book() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}

	/** save title and book id of the book we just added. */
	protected void saveBookInfo() {

		try {
			String selectQuery = "select * from tbl_book";
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

			}
			rs.last();

			int bookId = rs.getInt("bookId");
			String title = rs.getString("title");

			this.bookId = bookId;
			this.title = title;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
