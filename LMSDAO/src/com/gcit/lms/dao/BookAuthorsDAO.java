package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.BookAuthors;


public class BookAuthorsDAO extends BaseDAO{
	
	//method to insert data into the book authors
	public void create(BookAuthors bookAuthors) throws Exception {
		save("insert into tbl_book_authors (bookId, authorId, authorName) values(?,?,?)",
				new Object[] { bookAuthors.getBookId(),bookAuthors.getAuthorId(), bookAuthors.getAuthorName()});
	}

	//method to update
	public void update(BookAuthors bookAuthors) throws Exception {
		save("update tbl_book_authors set bookId = ?, authorId = ?, where bookId = ?, authorId= ?",
				new Object[] { bookAuthors.getBookId(), bookAuthors.getAuthorId()});

	}

	//method to delete
	public void delete(BookAuthors bookAuthors) throws Exception {
		save("delete from tbl_book_authors where bookId = ?, authorId= ?",
				new Object[] { bookAuthors.getBookId(), bookAuthors.getAuthorId() });
	}

	//method to read all data
	public List<BookAuthors> readAll() throws Exception {
		return (List<BookAuthors>) read("select * from tbl_book_authors", null);

	}

	//method to read each data
	public BookAuthors readOne(int bookId) throws Exception {
		List<BookAuthors> bookAuthors = (List<BookAuthors>) read("select * from tbl_book_authors",
				new Object[] { bookId });
		if (bookAuthors != null && bookAuthors.size() > 0) {
			return bookAuthors.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<BookAuthors> bookAuthors = new ArrayList<BookAuthors>();

		while (rs.next()) {
			BookAuthors a = new BookAuthors();
			a.setBookId(rs.getInt("bookId"));
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));

			bookAuthors.add(a);
		}
		return bookAuthors;
	}

}
