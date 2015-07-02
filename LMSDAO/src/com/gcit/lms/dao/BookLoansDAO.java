package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.BookLoans;

public class BookLoansDAO extends BaseDAO {

	public void create(BookLoans bookLoans) throws Exception {
		save("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate, dateIn) values(?,?,?,?,?,?)",
				new Object[] { bookLoans.getBookId(), bookLoans.getBranchId(),
						bookLoans.getCardNo(), bookLoans.getDateOut(),
						bookLoans.getDueDate(), bookLoans.getDateIn() });
	}

	public void update(BookLoans bookLoans) throws Exception {
		save("update tbl_book_loans set bookId = ?, branchId= ?, cardNo= ?, where bookId= ?, branchId= ?, cardNo= ?",
				new Object[] { bookLoans.getBookId(), bookLoans.getBranchId(),bookLoans.getCardNo() });

	}

	public void delete(BookLoans bookLoans) throws Exception {
		save("delete from tbl_book_loans where bookId = ?, branchId= ?, cardNo= ?",
				new Object[] { bookLoans.getBookId(), bookLoans.getBranchId(), bookLoans.getCardNo() });
	}

	public List<BookLoans> readAll() throws Exception {
		return (List<BookLoans>) read("select * from tbl_book_loans", null);

	}

	public BookLoans readOne(int bookId,int branchId,int cardNo) throws Exception {
		List<BookLoans> bookLoans = (List<BookLoans>) read("select * from tbl_book_loans",
				new Object[] { bookId, branchId, cardNo });
		if (bookLoans != null && bookLoans.size() > 0) {
			return bookLoans.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<BookLoans> bookLoans = new ArrayList<BookLoans>();

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
