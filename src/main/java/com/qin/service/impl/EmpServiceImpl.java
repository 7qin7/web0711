package com.qin.service.impl;

import java.util.List;

import com.qin.dao.IEmpDao;
import com.qin.dao.impl.EmpDaoImpl;
import com.qin.domain.Emp;
import com.qin.domain.Page;
import com.qin.service.IEmpService;

public class EmpServiceImpl implements IEmpService {

private IEmpDao dao = new EmpDaoImpl();
	
	@Override
	public void save(Emp e) {
		dao.save(e);
	}

	@Override
	public void delete(Integer eid) {
		dao.delete(eid);
	}

	@Override
	public void update(Emp e) {
		dao.update(e);	
	}

	@Override
	public List<Emp> find() {
		return dao.find();
	}

	@Override
	public Emp find(Integer eid) {
		return dao.find(eid);
	}

	@Override
	public Page findPageData(int p, int size) {
		int rowCount = dao.getRowCount();
		// p = 1, rowCount = 179, size = 5;
		Page<Emp> page = new Page<>(p,rowCount,size);
		// page.getStartLine: 0;
		List<Emp> list = dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
