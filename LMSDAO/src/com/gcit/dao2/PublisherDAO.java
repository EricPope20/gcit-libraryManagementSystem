package com.gcit.dao2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcit.domain02.Author;
import com.gcit.domain02.Publisher;

public class PublisherDAO extends BaseDAO<Publisher> {

	public PublisherDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void create(Publisher publisher) throws Exception {
		save("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values(?, ?, ?)",
				new Object[] { publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone() });
	}

	public void update(Publisher publisher) throws Exception {
		save("update tbl_publisher set publisherName = ?, publisherAddress=?, publisherPhone=? where publisherId = ?",
				new Object[] { publisher.getPublisherName(),  publisher.getPublisherAddress(), publisher.getPublisherPhone(), publisher.getPublisherId() });

	}

	public void delete(Publisher publisher) throws Exception {
		save("delete from tbl_publisher where publisherId = ?",
				new Object[] { publisher.getPublisherId() });
	}

	public List<Publisher> readAll() throws Exception{
		return (List<Publisher>) read("select * from tbl_publisher", null);
		
	}

	public Publisher readOne(int publisherId) throws Exception {
		List<Publisher> publishers = (List<Publisher>) read("select * from tbl_publisher where publisherId= ?", new Object[] {publisherId});
		if(publishers!=null && publishers.size()>0){
			return publishers.get(0);
		}
		return null;
	}

	@Override
	public List<Publisher> extractData(ResultSet rs) throws Exception {
		List<Publisher> publishers =  new ArrayList<Publisher>();
		
		while(rs.next()){
			Publisher a = new Publisher();
			a.setPublisherId(rs.getInt("publisherId"));
			a.setPublisherName(rs.getString("publisherName"));
			a.setPublisherAddress(rs.getString("publisherAddress"));
			a.setPublisherPhone(rs.getString("publisherPhone"));
			
			publishers.add(a);
		}
		return publishers;
	}

	@Override
	public List extractDataFirstLevel(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
List<Publisher> publishers =  new ArrayList<Publisher>();
		
		while(rs.next()){
			Publisher a = new Publisher();
			a.setPublisherId(rs.getInt("publisherId"));
			a.setPublisherName(rs.getString("publisherName"));
			a.setPublisherAddress(rs.getString("publisherAddress"));
			a.setPublisherPhone(rs.getString("publisherPhone"));
			
			publishers.add(a);
		}
		return publishers;
	}
	
	

}
