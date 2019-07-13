package com.qin.dao;

import java.util.List;

import com.qin.domain.Emp;

public interface IEmpDao {
	void save(Emp e);
	void delete(Integer eid);
	void update(Emp e);
	List<Emp> find();
	Emp find(Integer eid);
	
	int getRowCount();
	List find(int startLine,int size);
}
