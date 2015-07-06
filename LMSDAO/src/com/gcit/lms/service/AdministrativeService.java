package com.gcit.lms.service;

import java.sql.Connection;

import com.gcit.dao2.AuthorDAO;
import com.gcit.dao2.BookDAO;
import com.gcit.dao2.LibraryBranchDAO;
import com.gcit.domain02.Author;
import com.gcit.domain02.Book;
import com.gcit.domain02.LibraryBranch;

public class AdministrativeService {

	// method to create Author
	public void createAuthor(Author author) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (author == null || author.getAuthorName() == null
					|| author.getAuthorName().length() == 0
					|| author.getAuthorName().length() > 45) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				AuthorDAO adao = new AuthorDAO(conn);
				adao.create(author);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// method to update the author table
	public void updateAuthor(Author author) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (author == null || author.getAuthorName() == null
					|| author.getAuthorName().length() == 0
					|| author.getAuthorName().length() > 45) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				AuthorDAO adao = new AuthorDAO(conn);
				adao.update(author);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// method to delete from the author table
	public void deleteAuthor(Author author) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (author == null) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				AuthorDAO adao = new AuthorDAO(conn);
				adao.delete(author);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// creating the book table
	public void createBook(Book books) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (books == null || books.getTitle() == null
					|| books.getTitle().length() == 0) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				BookDAO bookdao = new BookDAO(conn);
				bookdao.create(books);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// updating the book table
	public void updateBook(Book books) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (books == null || books.getTitle() == null
					|| books.getTitle().length() == 0) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				BookDAO bookdao = new BookDAO(conn);
				bookdao.update(books);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// deleting the book table
	public void deleteBook(Book books) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (books == null) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				BookDAO bookdao = new BookDAO(conn);
				bookdao.delete(books);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// creating the method for branch table
	public void createBranch(LibraryBranch libBranch) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (libBranch == null || libBranch.getBranchName() == null
					|| libBranch.getBranchName().length() == 0
					|| libBranch.getBranchName().length() > 45) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				LibraryBranchDAO library = new LibraryBranchDAO(conn);
				library.create(libBranch);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// a method to update
	public void updateBranch(LibraryBranch libBranch) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (libBranch == null || libBranch.getBranchName() == null
					|| libBranch.getBranchName().length() == 0
					|| libBranch.getBranchName().length() > 45) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				LibraryBranchDAO library = new LibraryBranchDAO(conn);
				library.update(libBranch);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// a method to delete
	public void deleteBranch(LibraryBranch libBranch) throws Exception {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.createConnection();
		try {
			if (libBranch == null) {
				throw new Exception(
						"Author Name cannot be empty or more than 45 Chars");
			} else {
				LibraryBranchDAO library = new LibraryBranchDAO(conn);
				library.delete(libBranch);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
}
