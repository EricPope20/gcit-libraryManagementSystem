package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Publisher;

public class PublisherDAO extends BaseDAO {

	// a method to insert into the publisher table
	public void create(Publisher pub) throws Exception {
		save("insert into tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) values(?,?,?,?)",
				new Object[] { pub.getPublisherId(), pub.getPublisherName(),
						pub.getPublisherAddress(), pub.getPublisherPhone() });
	}

	// a method to update the publisher table
	public void update(Publisher pub) throws Exception {
		save("update tbl_publisher set publisherName = ? where publisherId = ?",
				new Object[] { pub.getPublisherName(), pub.getPublisherId() });

	}

	// a method to delete a row from the table
	public void delete(Publisher pub) throws Exception {
		save("delete from tbl_publisher where publisherId = ?",
				new Object[] { pub.getPublisherId() });
	}

	public List<Publisher> readAll() throws Exception {
		return (List<Publisher>) read("select * from tbl_publisher", null);

	}

	public Publisher readOne(int publisherId) throws Exception {
		List<Publisher> pub = (List<Publisher>) read(
				"select * from tbl_publisher", new Object[] { publisherId });
		if (pub != null && pub.size() > 0) {
			return pub.get(0);
		}
		return null;
	}

	@Override
	public List extractData(ResultSet rs) throws Exception {
		List<Publisher> pub = new ArrayList<Publisher>();

		while (rs.next()) {
			Publisher a = new Publisher();
			a.setPublisherId(rs.getInt("publisherId"));
			a.setPublisherName(rs.getString("publisherName"));
			a.setPublisherAddress(rs.getString("publisherAddress"));
			a.setPublisherPhone(rs.getString("publisherNumber"));

			pub.add(a);
		}
		return pub;
	}
}
