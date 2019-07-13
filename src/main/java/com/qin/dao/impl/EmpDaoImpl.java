package com.qin.dao.impl;

import java.util.List;

import com.qin.dao.IEmpDao;
import com.qin.domain.Emp;
import com.qin.utils.BeanHandler;
import com.qin.utils.BeanListHandler;
import com.qin.utils.IntegerHandler;
import com.qin.utils.JdbcUtils;

public class EmpDaoImpl implements IEmpDao {

	@Override
	public void save(Emp e) {
		// TODO Auto-generated method stub
		String sql = "insert into emp values(null, ?,?,?,?)";
		JdbcUtils.update(sql, new Object[] {e.getEname(), e.getHiredate(),e.getSal(),e.getDid()});
	}

	@Override
	public void delete(Integer eid) {
		// TODO Auto-generated method stub
		String sql = "delete from emp where eid = ?";
		JdbcUtils.update(sql, new Object[] {eid});
	}

	@Override
	public void update(Emp e) {
		// TODO Auto-generated method stub
		String sql = "update emp set ename = ?, hiredate=?,sal=?,did=? where eid=?";
		JdbcUtils.update(sql, new Object[] {e.getEname(), e.getHiredate(),e.getSal(),e.getDid(), e.getEid()});
	}

	@Override
	public List<Emp> find() {
		// TODO Auto-generated method stub
		String sql = "select * from emp";
		return (List<Emp>) JdbcUtils.read(sql, null, new BeanListHandler(Emp.class));
	}

	@Override
	public Emp find(Integer eid) {
		// TODO Auto-generated method stub
		String sql = "select * from emp where eid = ?";
		return (Emp) JdbcUtils.read(sql, new Object[] {eid}, new BeanHandler(Emp.class));
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from emp";
		return (Integer) JdbcUtils.read(sql, null, new IntegerHandler());
	}

	@Override
	public List find(int startLine, int size) {
		// TODO Auto-generated method stub
		String sql = "select * from emp limit ?,?";
		return (List<Emp>) JdbcUtils.read(sql, new Object[] {startLine, size}, new BeanListHandler(Emp.class));
	}

}
