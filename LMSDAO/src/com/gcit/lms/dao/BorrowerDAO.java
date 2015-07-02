package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Borrower;

public class BorrowerDAO extends BaseDAO {

	//a method to insert into the borrower table 
	public void create(Borrower borrower) throws Exception {
		save("insert into tbl_borrower (cardNo, name, address, phone, noOfBorrower) values(?,?,?,?,?)",
				new Object[] { borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone(),borrower.getNoOfBorrower() });
	}

	//a method to update
	public void update(Borrower borrower) throws Exception {
		save("update tbl_borrower set name = ? where cardNo = ?",
				new Object[] { borrower.getName(), borrower.getCardNo()});

	}

	// a method to delete
	public void delete(Borrower borrower) throws Exception {
		save("delete from tbl_borrower where cardNo = ?",
				new Object[] { borrower.getCardNo() });
	}

	//this method read all the data in the borrower table
	public List<Borrower> readAll() throws Exception {
		return (List<Borrower>) read("select * from tbl_borrower", null);

	}

	//this method read each individual data in the borrower table
	public Borrower readOne(int cardNo) throws Exception {
		List<Borrower> borrower = (List<Borrower>) read("select * from tbl_borrower",
				new Object[] { cardNo });
		if (borrower != null && borrower.size() > 0) {
			return borrower.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<Borrower> borrower = new ArrayList<Borrower>();

		while (rs.next()) {
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setName(rs.getString("name"));
			a.setAddress(rs.getString("address"));
			a.setPhone(rs.getString("phone"));
			a.setNoOfBorrower(rs.getInt("noOfBorrower"));
			borrower.add(a);
		}
		return borrower;
	}


}
