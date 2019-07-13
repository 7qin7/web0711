package com.qin.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BeanListHandler implements ResultSetHandler {
	
	private Class clazz;//Emp.class
	
	public BeanListHandler(Class clazz) {
		this.clazz=clazz;
	}
	@Override
	public Object handle(ResultSet rs) {
		// TODO Auto-generated method stub
		
		try {
			List list=new ArrayList();
			while(rs.next()) {
				Object obj=clazz.newInstance();
				Field[] fields=clazz.getDeclaredFields();
				for(Field f:fields) {
					f.setAccessible(true);
					String fieldName=f.getName();
					if(f.getType()==Integer.class||f.getType()==int.class) {
						f.set(obj, rs.getInt(fieldName));
					}else if(f.getType() == String.class ) {
						f.set(obj,rs.getString(fieldName));
					} else if(f.getType() == Date.class ) {
						f.set(obj,rs.getDate(fieldName));
					} else if(f.getType() == Double.class ) {
						f.set(obj,rs.getDouble(fieldName));
					}
				}
				list.add(obj);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

}
