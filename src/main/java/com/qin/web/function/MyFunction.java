package com.qin.web.function;

import com.qin.domain.Dept;
import com.qin.service.IDeptService;
import com.qin.service.impl.DeptServiceImpl;

public class MyFunction {
	private static IDeptService deptService = new DeptServiceImpl();
	// 方法必须是被public static修饰的
	public static Dept getDeptByDid(Integer did) {
		return deptService.find(did);
	}
}
