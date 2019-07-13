package com.qin.dao;

import java.util.List;

import com.qin.domain.Dept;

public interface IDeptDao {
	void save(Dept d);
	void delete(Integer did);
	void update(Dept d);
	List<Dept> find();
	Dept find(Integer did);
	
	int getRowCount();
	List<Dept> find(int startLine,int size);
}
