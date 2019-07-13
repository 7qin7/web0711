package com.qin.service;

import java.util.List;

import com.qin.domain.Emp;
import com.qin.domain.Page;

public interface IEmpService {
	void save(Emp e);
	void delete(Integer eid);
	void update(Emp e);
	List<Emp> find();
	Emp find(Integer eid);
	
	Page findPageData(int p, int size);
}
