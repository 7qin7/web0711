package com.qin.web.function;

import com.qin.domain.Dept;
import com.qin.service.IDeptService;
import com.qin.service.impl.DeptServiceImpl;

public class MyFunction {
	private static IDeptService deptService = new DeptServiceImpl();
	// ���������Ǳ�public static���ε�
	public static Dept getDeptByDid(Integer did) {
		return deptService.find(did);
	}
}
