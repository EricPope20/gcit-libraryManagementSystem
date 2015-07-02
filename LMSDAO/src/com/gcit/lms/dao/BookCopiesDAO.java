package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.BookCopies;

public class BookCopiesDAO extends BaseDAO {

	// method to insert in to the book copies table
	public void create(BookCopies bookCopies) throws Exception {
		save("insert into tbl_book_copies (bookId, branchId, noOfCopies) values(?,?,?)",
				new Object[] { bookCopies.getBookId(),
						bookCopies.getBranchId(), bookCopies.getNoOfCopies() });
	}

	// method to update the table
	public void update(BookCopies bookCopies) throws Exception {
		save("update tbl_book_copies set bookId = ?, branchId, where bookId = ?, branchId= ?",
				new Object[] { bookCopies.getBookId(), bookCopies.getBranchId() });

	}

	// method to delete
	public void delete(BookCopies bookCopies) throws Exception {
		save("delete from tbl_book_copies where bookId = ?, branchId = ?",
				new Object[] { bookCopies.getBookId(), bookCopies.getBranchId() });
	}

	// reading all data
	public List<BookCopies> readAll() throws Exception {
		return (List<BookCopies>) read("select * from tbl_book_copies", null);

	}

	// reading each data individually
	public BookCopies readOne(int bookId) throws Exception {
		List<BookCopies> bookCopies = (List<BookCopies>) read(
				"select * from tbl_book_copies", new Object[] { bookId });
		if (bookCopies != null && bookCopies.size() > 0) {
			return bookCopies.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<BookCopies> bookCopies = new ArrayList<BookCopies>();

		while (rs.next()) {
			BookCopies a = new BookCopies();
			a.setBookId(rs.getInt("bookId"));
			a.setBranchId(rs.getInt("branchId"));
			a.setNoOfCopies(rs.getInt("noOfCopies"));

			bookCopies.add(a);
		}
		return bookCopies;
	}

}
