package com.qin.service;

import java.util.List;

import com.qin.domain.Dept;
import com.qin.domain.Page;

public interface IDeptService {
	void save(Dept d);
	void delete(Integer did);
	void update(Dept d);
	List<Dept> find();
	Dept find(Integer did);
	
	Page findPageDate(int p,int size);
}
