package Com.gcit.training.libraryManagement.project;

public class LibraryBranch {

	private int branchId;
	private String beranchName;
	private String branchAddress;

	public LibraryBranch() {

	}

	public LibraryBranch(int branchId, String branchName, String branchAddress) {
		// super();
		this.branchId = branchId;
		this.beranchName = beranchName;
		this.branchAddress = branchAddress;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBeranchName() {
		return beranchName;
	}

	public void setBeranchName(String beranchName) {
		this.beranchName = beranchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

}
