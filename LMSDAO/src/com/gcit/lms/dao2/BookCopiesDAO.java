package com.gcit.lms.dao2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain02.BookCopies;
import com.gcit.lms.domain02.Publisher;

public class BookCopiesDAO extends BaseDAO<BookCopies>{

	public BookCopiesDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	//create method
	public void create(BookCopies bookCopies) throws Exception {
		save("insert into tbl_book_copies (bookId, branchId, noOfCopies) values(?, ?, ?)",
				new Object[] { bookCopies.getBookId(),
						bookCopies.getBranchId(),
						bookCopies.getNoOfCopies() });
	}

	//updating method
	public void update(BookCopies bookCopies) throws Exception {
		save("update tbl_book_copies set bookId= ?, branchId=?, noOfCopies=? where bookId= ?, branchId= ?",
				new Object[] { bookCopies.getBookId(),
						bookCopies.getBranchId(),
						bookCopies.getNoOfCopies() });

	}

	//delete method
	public void delete(BookCopies bookCopies) throws Exception {
		save("delete from tbl_book_copies where bookId = ?, branchId= ?",
				new Object[] { bookCopies.getBookId(),bookCopies.getBranchId() });
	}

	//reading all the informations in the table
	public List<BookCopies> readAll() throws Exception {
		return (List<BookCopies>) read("select * from tbl_book_copies", null);

	}

	public BookCopies readOne(int bookId, int branchId) throws Exception {
		List<BookCopies> bookCopies = (List<BookCopies>) read(
				"select * from tbl_book_copies where bookId= ?, branchId= ?",
				new Object[] { bookId, branchId });
		if (bookCopies != null && bookCopies.size() > 0) {
			return bookCopies.get(0);
		}
		return null;
	}

	@Override
	public List<BookCopies> extractData(ResultSet rs) throws Exception {
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

	@Override
	public List extractDataFirstLevel(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
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
