package com.qin.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerHandler implements ResultSetHandler {
	
	@Override
	public Object handle(ResultSet rs) {
		// TODO Auto-generated method stub
		Integer i=null;
		try {
			if(rs.next()) {
				i=rs.getInt(1);
			}
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
