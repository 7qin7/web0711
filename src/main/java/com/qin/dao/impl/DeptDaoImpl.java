package com.qin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qin.dao.IDeptDao;
import com.qin.domain.Dept;
import com.qin.utils.BeanHandler;
import com.qin.utils.BeanListHandler;
import com.qin.utils.IntegerHandler;
import com.qin.utils.JdbcUtils;

public class DeptDaoImpl implements IDeptDao {

	@Override
	public void save(Dept d) {
		// TODO Auto-generated method stub
		JdbcUtils.update("insert into dept values(null,?)", new Object[] {d.getDname()});
	}

	@Override
	public void delete(Integer did) {
		// TODO Auto-generated method stub
		JdbcUtils.update("delete from dept where did=?", new Object[] {did});
	
	}

	@Override
	public void update(Dept d) {
		// TODO Auto-generated method stub
		JdbcUtils.update("update dept set dname=? where did=?", new Object[] {d.getDname(),d.getDid()});
	}

	@Override
	public List<Dept> find() {
		// TODO Auto-generated method stub
		String sql="select * from dept";
		List<Dept> list=(List<Dept>) JdbcUtils.read(sql,null,new BeanListHandler(Dept.class));
		return list;
	}

	@Override
	public Dept find(Integer did) {
		// TODO Auto-generated method stub
		String sql = "select * from dept where did = ?";
		Dept d =  (Dept) JdbcUtils.read(sql, new Object[] {did}, new BeanHandler(Dept.class));
		return d;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from dept";
		Integer rowCount = (Integer) JdbcUtils.read(sql, null, new IntegerHandler());
		return rowCount;
	}

	@Override
	public List<Dept> find(int startLine, int size) {
		// TODO Auto-generated method stub
		String sql = "select * from dept limit ?,?";
		List<Dept> list = (List<Dept>) JdbcUtils.read(sql, new Object[] {startLine, size}, new BeanListHandler(Dept.class));
		return list;
	}

}
