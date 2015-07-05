package com.gcit.dao2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class GenreDAO extends BaseDAO<GenreDAO>{

	//constructor
	public GenreDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GenreDAO> extractData(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GenreDAO> extractDataFirstLevel(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
