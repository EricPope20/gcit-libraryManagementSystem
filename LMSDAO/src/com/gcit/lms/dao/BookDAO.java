package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Book;

public class BookDAO extends BaseDAO {

	// method creating the book table to insert into
	public void create(Book book) throws Exception {
		save("insert into tbl_book (bookId, title, pubId) values(?,?,?)",
				new Object[] { book.getBookId(), book.getTitle(),
						book.getPublisher()});
	}

	// method updating the book title table
	public void update(Book book) throws Exception {
		save("update tbl_book set title = ? where bookId = ?",
				new Object[] { book.getTitle(),book.getBookId() });
	}

	//method to delete the book table
	public void delete(Book book) throws Exception {
		save("delete from tbl_book where bookId = ?",
				new Object[] { book.getBookId() });
	}

	// method to read all the book information from the book table
	public List<Book> readAll() throws Exception {
		return (List<Book>) read("select * from tbl_book", null);

	}

	//method to read each layer of the book
	public Book readOne(int bookId) throws Exception {
		List<Book> book = (List<Book>) read("select * from tbl_book",
				new Object[] { bookId });
		if (book != null && book.size() > 0) {
			return book.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<Book> book = new ArrayList<Book>();

		while (rs.next()) {
			Book a = new Book();
			a.setBookId(rs.getInt("bookId"));
			a.setTitle(rs.getString("title"));

			book.add(a);
		}
		return book;
	}

}
