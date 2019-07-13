package com.qin.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	
	public static<T> T request2bean(HttpServletRequest request,Class clazz) {
		try {
			Object obj=clazz.newInstance();
			Field[] fields=clazz.getDeclaredFields();
			for(Field f:fields) {
				f.setAccessible(true);
				String fieldName=f.getName();
				String value=request.getParameter(fieldName);
				if(value!=null) {
					if(f.getType() == Integer.class || f.getType() == int.class) {
						f.set(obj, Integer.parseInt(value));
					} else if(f.getType() == Date.class) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						f.set(obj, sdf.parse(value));
					} else if(f.getType() == Double.class || f.getType() == double.class ) {
						f.set(obj, Double.parseDouble(value));
					} else if(f.getType() == String.class ) {
						// 把f所代表的属性，当做obj对象的属性，赋值为value
						f.set(obj, value);
					}
				}
			}
			return (T) obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
