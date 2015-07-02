package com.gcit.lms.domain;

public class BookGenres {
 private int genre_id;
 private int bookId;
 
/**
 * @return the genre_id
 */
public int getGenre_id() {
	return genre_id;
}

/**
 * @param genre_id the genre_id to set
 */
public void setGenre_id(int genre_id) {
	this.genre_id = genre_id;
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
}
