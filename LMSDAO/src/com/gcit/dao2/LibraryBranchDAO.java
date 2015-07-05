package com.gcit.dao2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.domain02.LibraryBranch;
import com.gcit.domain02.Book;
import com.gcit.domain02.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO<LibraryBranch>{

	public LibraryBranchDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	//the create method
	public void create(LibraryBranch libBranch) throws Exception {
		save("insert into tbl_library_branch (branchId) values(?)",
				new Object[] { libBranch.getBranchId() });
	}

	//method to update
	public void update(LibraryBranch libBranch) throws Exception {
		save("update tbl_library_branch set branchName = ? where branchId = ?",
				new Object[] { libBranch.getBranchName(), libBranch.getBranchId() });
	}

	//deleting
	public void delete(LibraryBranch libBranch) throws Exception {
		save("delete from tbl_library_branch where branchId = ?",
				new Object[] { libBranch.getBranchId() });
	}

	//reading all the data in the library branch
	public List<LibraryBranch> readAll() throws Exception {
		return (List<LibraryBranch>) read("select * from tbl_library_branch", null);

	}

	//reading each
	public LibraryBranch readOne(int branchId) throws Exception {
		List<LibraryBranch> libBranch = (List<LibraryBranch>) read("select * from tbl_library_branch",
				new Object[] { branchId });
		if (libBranch != null && libBranch.size() > 0) {
			return libBranch.get(0);
		}
		return null;
	}

	@Override
	public List<LibraryBranch> extractData(ResultSet rs) throws Exception {
		List<LibraryBranch> libBranch = new ArrayList<LibraryBranch>();
		BookDAO bDao = new BookDAO(getConnection());

		while (rs.next()) {
			LibraryBranch a = new LibraryBranch();
			a.setBranchId(rs.getInt("branchId"));
			a.setBranchName(rs.getString("branchName"));
			a.setBranchAddress(rs.getString("branchAddress"));
			@SuppressWarnings("unchecked")
			List<Book> books = (List<Book>) bDao
					.readFirstLevel(
							"select * from tbl_book where bookId In"
									+ "(select bookId from tbl_book_copies where branchId=?)",
							new Object[] { rs.getInt("branchId") });
			a.setBooks(books);
			libBranch.add(a);
		}
		return libBranch;
	}

	@Override
	public List<LibraryBranch> extractDataFirstLevel(ResultSet rs) throws Exception {
		List<LibraryBranch> libBranch = new ArrayList<LibraryBranch>();
		BookDAO bDao = new BookDAO(getConnection());

		while (rs.next()) {
			LibraryBranch a = new LibraryBranch();
			a.setBranchId(rs.getInt("branchId"));
			a.setBranchName(rs.getString("branchName"));
			a.setBranchAddress(rs.getString("branchAddress"));

			libBranch.add(a);
		}
		return libBranch;
	}

}
