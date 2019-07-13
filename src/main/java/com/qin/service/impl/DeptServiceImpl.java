package com.qin.service.impl;

import java.util.List;

import com.qin.dao.IDeptDao;
import com.qin.dao.impl.DeptDaoImpl;
import com.qin.domain.Dept;
import com.qin.domain.Page;
import com.qin.service.IDeptService;

public class DeptServiceImpl implements IDeptService{
	
	private IDeptDao dao=new DeptDaoImpl();
	@Override
	public void save(Dept d) {
		// TODO Auto-generated method stub
		dao.save(d);
	}

	@Override
	public void delete(Integer did) {
		// TODO Auto-generated method stub
		dao.delete(did);
	}

	@Override
	public void update(Dept d) {
		// TODO Auto-generated method stub
		dao.update(d);
	}

	@Override
	public List<Dept> find() {
		// TODO Auto-generated method stub
		return dao.find();
	}

	@Override
	public Dept find(Integer did) {
		// TODO Auto-generated method stub
		return dao.find(did);
	}

	@Override
	public Page findPageDate(int p, int size) {
		// TODO Auto-generated method stub
		int rc=dao.getRowCount();
		Page<Dept> page=new Page<>(p, rc, size);
		List<Dept> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
