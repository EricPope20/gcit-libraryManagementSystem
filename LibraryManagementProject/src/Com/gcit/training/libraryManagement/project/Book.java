package Com.gcit.training.libraryManagement.project;

public class Book {
	//data fields
	int bookId;
	String title;
	int pubId;
	
//constructor no parameters
	public Book(){
		
	}

public Book(int bookId, String title, int pubId) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.pubId = pubId;
}

public int getBookId() {
	return bookId;
}

public void setBookId(int bookId) {
	this.bookId = bookId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public int getPubId() {
	return pubId;
}

public void setPubId(int pubId) {
	this.pubId = pubId;
}
	
}
