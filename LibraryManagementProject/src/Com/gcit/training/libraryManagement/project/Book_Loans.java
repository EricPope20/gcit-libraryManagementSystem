package Com.gcit.training.libraryManagement.project;

public class Book_Loans {
	//data fields
	int bookId;
	int branchId;
	int cardNo;
	
//constructor no parameters
	public Book_Loans(){
		
	}

	public Book_Loans(int bookId, int branchId, int cardNo) {
		super();
		this.bookId = bookId;
		this.branchId = branchId;
		this.cardNo = cardNo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
}
