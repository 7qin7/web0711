package com.qin.utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class BeanHandler implements ResultSetHandler {
	
	
	private Class clazz;
	public BeanHandler(Class clazz) {
		this.clazz=clazz;
	}
	@Override
	public Object handle(ResultSet rs) {
		// TODO Auto-generated method stub
		Object obj=null;
		try {
			if(rs.next()) {
				obj=clazz.newInstance();
				Field[] fields=clazz.getDeclaredFields();
				for(Field f:fields) {
					f.setAccessible(true);
					String fieldName = f.getName();
					if(f.getType() == Integer.class || f.getType() == int.class) {
						f.set(obj, rs.getInt(fieldName));
					}else if(f.getType() == Double.class || f.getType() == double.class) {
						f.set(obj,rs.getDouble(fieldName));
					} else if(f.getType() == String.class ) {
						f.set(obj,rs.getString(fieldName));
					} else if(f.getType()==Date.class) {
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						f.set(obj, sdf.parse(rs.getString(fieldName)));
					}
				}
			}
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

}
