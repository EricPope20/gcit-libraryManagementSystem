package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.BookGenres;

public class BookGenresDAO extends BaseDAO {

	// method to insert into the book genres table
	public void create(BookGenres bookgenres) throws Exception {
		save("insert into tbl_book_genres (genre_id, bookId) values(?,?)",
				new Object[] { bookgenres.getGenre_id(), bookgenres.getBookId() });
	}

	// update method
	public void update(BookGenres bookgeneres) throws Exception {
		save("update tbl_book_genres set genre_id = ?, bookId = ?, where genre_id = ?, bookId = ?",
				new Object[] { bookgeneres.getGenre_id(),
						bookgeneres.getBookId() });

	}

	// delete method
	public void delete(BookGenres bookgenres) throws Exception {
		save("delete from tbl_book_genres where genre_id = ?, bookId = ?",
				new Object[] { bookgenres.getGenre_id(), bookgenres.getBookId() });
	}

	// method to read all the data
	public List<BookGenres> readAll() throws Exception {
		return (List<BookGenres>) read("select * from tbl_book_genres", null);

	}

	// reading each data
	public BookGenres readOne(int genre_id) throws Exception {
		List<BookGenres> bookgenres = (List<BookGenres>) read(
				"select * from tbl_book_genres", new Object[] { genre_id });
		if (bookgenres != null && bookgenres.size() > 0) {
			return bookgenres.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<BookGenres> bookgenres = new ArrayList<BookGenres>();

		while (rs.next()) {
			BookGenres a = new BookGenres();
			a.setGenre_id(rs.getInt("genre_id"));
			a.setBookId(rs.getInt("bookId"));

			bookgenres.add(a);
		}
		return bookgenres;
	}
}
