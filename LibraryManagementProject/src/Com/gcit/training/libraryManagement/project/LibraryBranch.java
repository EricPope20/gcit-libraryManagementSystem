package Com.gcit.training.libraryManagement.project;

public class LibraryBranch {

	private int branchId;
	private String branchName;
	private String branchAddress;

	public LibraryBranch() {

	}

	public LibraryBranch(int branchId, String branchName, String branchAddress) {
		// super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBeranchName() {
		return branchName;
	}

	public void setBeranchName(String beranchName) {
		this.branchName = beranchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

}
