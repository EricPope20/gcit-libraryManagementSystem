package com.gcit.lms.dao2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain02.Book;
import com.gcit.lms.domain02.BookLoans;

public class BookLoansDAO extends BaseDAO<BookLoans> {

	public BookLoansDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	// creating the method to insert
	public void create(BookLoans bookLoans) throws Exception {
		save("insert into tbl_book_loans (bookId,branchId,cardNo) values(?,?,?)",
				new Object[] { bookLoans.getBookId(), bookLoans.getBranchId(),
						bookLoans.getCardNo() });
	}

	// a method to update
	public void update(BookLoans bookLoans) throws Exception {
		save("update tbl_book_loans set bookId= ?, where cardNo = ?",
				new Object[] { bookLoans.getBookId(), bookLoans.getCardNo() });
	}

	// to delete
	public void delete(BookLoans bookLoans) throws Exception {
		save("delete from tbl_book_loans where bookId = ?, branchId= ?, cardId= ?",
				new Object[] { bookLoans.getBookId(), bookLoans.getBranchId(),
						bookLoans.getCardNo() });
	}

	public List<BookLoans> readAll() throws Exception {
		return (List<BookLoans>) read("select * from tbl_book_loans", null);

	}

	public BookLoans readOne(int bookId, int branchId, int cardId)
			throws Exception {
		List<BookLoans> bookLoans = (List<BookLoans>) read(
				"select * from tbl_book_loans", new Object[] { bookId,
						branchId, cardId });
		if (bookLoans != null && bookLoans.size() > 0) {
			return bookLoans.get(0);
		}
		return null;
	}

	@Override
	public List<BookLoans> extractData(ResultSet rs) throws Exception {
		List<BookLoans> bookLoans = new ArrayList<BookLoans>();
		BookDAO bDao = new BookDAO(getConnection());

		while (rs.next()) {
			BookLoans a = new BookLoans();
			a.setBookId(rs.getInt("bookId"));
			a.setBranchId(rs.getInt("branchId"));
			a.setCardNo(rs.getInt("cardNo"));
			a.setDateOut(rs.getString("dateOut"));
			a.setDueDate(rs.getString("dueDate"));
			a.setDateIn(rs.getString("dateIn"));
			@SuppressWarnings("unchecked")
			List<Book> books = (List<Book>) bDao.readFirstLevel(
					"select * from tbl_book_loans where bookId In"
							+ "(select cardNo from tbl_book where cardNo= ?)",
					new Object[] { rs.getInt("cardNo") });
			a.setBooks(books);
			bookLoans.add(a);
		}
		return bookLoans;
	}

	@Override
	public List<BookLoans> extractDataFirstLevel(ResultSet rs) throws Exception {
		List<BookLoans> bookLoans = new ArrayList<BookLoans>();
		BookDAO bDao = new BookDAO(getConnection());

		while (rs.next()) {
			BookLoans a = new BookLoans();
			a.setBookId(rs.getInt("bookId"));
			a.setBranchId(rs.getInt("branchId"));
			a.setCardNo(rs.getInt("cardNo"));
			a.setDateOut(rs.getString("dateOut"));
			a.setDueDate(rs.getString("dueDate"));
			a.setDateIn(rs.getString("dateIn"));

			bookLoans.add(a);
		}
		return bookLoans;
	}

}
