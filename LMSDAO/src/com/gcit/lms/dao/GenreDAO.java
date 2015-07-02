package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Genre;

public class GenreDAO extends BaseDAO {

	// a method to create the Genre table
	public void create(Genre genre) throws Exception {
		save("insert into tbl_genre (genre_id, genre_name) values(?,?)",
				new Object[] { genre.getGenreId(), genre.getGenreName() });
	}

	// a method updating the genre table
	public void update(Genre genre) throws Exception {
		save("update tbl_genre set genre_name = ? where genre_id = ?",
				new Object[] { genre.getGenreName(), genre.getGenreId() });

	}

	// a method to delete the genre table
	public void delete(Genre genre) throws Exception {
		save("delete from tbl_genre where genre_id = ?",
				new Object[] { genre.getGenreId() });
	}

	// a method to read all information the Genre table
	public List<Genre> readAll() throws Exception {
		return (List<Genre>) read("select * from tbl_genre", null);

	}

	public Genre readOne(int genre_id) throws Exception {
		List<Genre> genre = (List<Genre>) read("select * from tbl_author",
				new Object[] { genre_id });
		if (genre != null && genre.size() > 0) {
			return genre.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<Genre> genre = new ArrayList<Genre>();

		while (rs.next()) {
			Genre a = new Genre();
			a.setGenreId(rs.getInt("genre_id"));
			a.setGenreName(rs.getString("genre_name"));

			genre.add(a);
		}
		return genre;
	}

}
