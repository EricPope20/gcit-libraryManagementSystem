package com.gcit.lms.dao2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain02.Book;
import com.gcit.lms.domain02.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower> {

	public BorrowerDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	// method to insert to the borrower table
	public void create(Borrower borrower) throws Exception {
		save("insert into tbl_borrower (cardNo) values(?)",
				new Object[] { borrower.getCardNo() });
	}

	// a method to update the borrower table
	public void update(Borrower borrower) throws Exception {
		save("update tbl_borrower set name = ? where cardNo = ?", new Object[] {
				borrower.getName(), borrower.getCardNo() });
	}

	// a method to delete from borrower
	public void delete(Borrower borrower) throws Exception {
		save("delete from tbl_borrower where cardNo = ?",
				new Object[] { borrower.getCardNo() });
	}

	// a method to read all from borrower
	public List<Borrower> readAll() throws Exception {
		return (List<Borrower>) read("select * from tbl_borrower", null);

	}

	// reading each
	public Borrower readOne(int cardNo) throws Exception {
		List<Borrower> borrower = (List<Borrower>) read(
				"select * from tbl_borrower", new Object[] { cardNo });
		if (borrower != null && borrower.size() > 0) {
			return borrower.get(0);
		}
		return null;
	}

	@Override
	public List<Borrower> extractData(ResultSet rs) throws Exception {
		List<Borrower> borrower = new ArrayList<Borrower>();
		BookDAO bDao = new BookDAO(getConnection());

		while (rs.next()) {
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setName(rs.getString("name"));
			a.setAddress(rs.getString("address"));
			a.setPhone(rs.getString("phone"));
			@SuppressWarnings("unchecked")
			List<Book> books = (List<Book>) bDao
					.readFirstLevel(
							"select * from tbl_book where bookId In"
									+ "(select bookId from tbl_book_loans where cardNo= ?)",
							new Object[] { rs.getInt("cardNo") });
			a.setBooks(books);
			borrower.add(a);
		}
		return borrower;
	}

	@Override
	public List<Borrower> extractDataFirstLevel(ResultSet rs) throws Exception {
		List<Borrower> borrower = new ArrayList<Borrower>();
		BookDAO bDao = new BookDAO(getConnection());

		while (rs.next()) {
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setName(rs.getString("name"));
			a.setAddress(rs.getString("address"));
			a.setPhone(rs.getString("phone"));

			borrower.add(a);
		}
		return borrower;
	}

}
