package com.gcit.dao2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.domain02.Author;
import com.gcit.domain02.Book;
import com.gcit.domain02.Genre;


public class BookDAO extends BaseDAO<Book>{

	public BookDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void create(Book book) throws Exception {
		int bookId = saveWithID("insert into tbl_book (title) values(?)",
				new Object[] { book.getTitle()});
		
		for(Author a: book.getAuthors()){
			save("insert into tbl_book_authors (bookId, authorId) values (?,?)", 
				new Object[]{bookId, a.getAuthorId()});
		}
		
		for(Genre g: book.getGenres()){
			save("insert into tbl_book_genres (bookId, genre_id) values (?,?)", 
				new Object[]{bookId, g.getGenreId()});
		}
	}
	
	public void update(Book book) throws Exception {
		save("update tbl_book set title = ? where bookId = ?",
				new Object[] { book.getTitle(), book.getBookId() });
	}
	
	public void delete(Book book) throws Exception {
		save("delete from tbl_book where bookId = ?",
				new Object[] { book.getBookId() });
	}
	
	public List<Book> readAll() throws Exception{
		return (List<Book>) read("select * from tbl_book", null);
		
	}
	
	
	@Override
	public List<Book> extractData(ResultSet rs) throws Exception {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pdao = new PublisherDAO(getConnection());
		AuthorDAO aDao = new AuthorDAO(getConnection());
		GenreDAO gD = new GenreDAO(getConnection());
		
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPublisher(pdao.readOne(rs.getInt("pubId")));
			@SuppressWarnings("unchecked")
			List<Author> authors = (List<Author>) aDao.readFirstLevel("select * from tbl_author where authorId In"
					+ "(select authorId from tbl_book_authors where bookId=?)", new Object[] {rs.getInt("bookId")});
			b.setAuthors(authors);
			
			List<Genre> genres = (List<Genre>) gD.readFirstLevel("select * from tbl_genre where genre_id In"
					+ "(select genre_id from tbl_book_genres where bookId=?)", new Object[] {rs.getInt("bookId")});
			books.add(b);
		}
		
		return books;
	}
	
	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) throws Exception {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pdao = new PublisherDAO(getConnection());
		AuthorDAO aDao = new AuthorDAO(getConnection());
		//GenreDAO gD
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			books.add(b);
		}
		
		return books;
	}

}
