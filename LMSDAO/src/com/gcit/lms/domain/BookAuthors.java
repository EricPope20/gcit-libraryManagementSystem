package com.gcit.lms.domain;

public class BookAuthors {
	private int authorId;
	private int bookId;
	private String authorName;
	
	/**
	 * @return the book_authors
	 */
	public int getAuthorId() {
		return authorId;
	}
	
	/**
	 * @param book_authors the book_authors to set
	 */
	public void setAuthorId(int book_authors) {
		this.authorId = book_authors;
	}
	
	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}
	
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
