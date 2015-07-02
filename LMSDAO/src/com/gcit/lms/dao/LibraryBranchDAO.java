package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO {

	// a method to insert into the library branch table
	public void create(LibraryBranch libBranch) throws Exception {
		save("insert into tbl_library_branch (branchId, branchName, branchAddress) values(?,?,?)",
				new Object[] { libBranch.getBranchId(),
						libBranch.getBranchName(), libBranch.getBranchAddress() });
	}

	// a method to update
	public void update(LibraryBranch libBranch) throws Exception {
		save("update tbl_library_branch set branchName = ? where branchId = ?",
				new Object[] { libBranch.getBranchName(),
						libBranch.getBranchId() });

	}

	// a method to delete
	public void delete(LibraryBranch libBranch) throws Exception {
		save("delete from tbl_library_branch where branchId = ?",
				new Object[] { libBranch.getBranchId() });
	}

	// a method to read all data from the Library Branch table
	public List<LibraryBranch> readAll() throws Exception {
		return (List<LibraryBranch>) read("select * from tbl_library_branch",
				null);

	}

	public LibraryBranch readOne(int branchId) throws Exception {
		List<LibraryBranch> libBranch = (List<LibraryBranch>) read(
				"select * from tbl_libray_branch", new Object[] { branchId });
		if (libBranch != null && libBranch.size() > 0) {
			return libBranch.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<LibraryBranch> libBranch = new ArrayList<LibraryBranch>();

		while (rs.next()) {
			LibraryBranch a = new LibraryBranch();
			a.setBranchId(rs.getInt("branchId"));
			a.setBranchName(rs.getString("branchName"));
			a.setBranchAddress(rs.getString("brancdAddress"));

			libBranch.add(a);
		}
		return libBranch;
	}

}
