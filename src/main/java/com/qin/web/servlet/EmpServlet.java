package com.qin.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qin.domain.Dept;
import com.qin.domain.Emp;
import com.qin.domain.Page;
import com.qin.service.IDeptService;
import com.qin.service.IEmpService;
import com.qin.service.impl.DeptServiceImpl;
import com.qin.service.impl.EmpServiceImpl;
import com.qin.utils.WebUtils;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDeptService deptService = new DeptServiceImpl();
	
	private IEmpService empService = new EmpServiceImpl();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String method = request.getParameter("method");
		
		if("saveUI".equals(method)) {
			saveUI(request,response);
		} else if("save".equals(method)) {
			save(request,response);
		} else if("findAll".equals(method)) {
			findAll(request,response);
		} else if("delete".equals(method)) {
			delete(request,response);
		} else if("updateUI".equals(method)) {
			updateUI(request,response);
		} else if("update".equals(method)) {
			update(request,response);
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Emp e =  WebUtils.request2bean(request, Emp.class);
		empService.update(e);
		response.sendRedirect("EmpServlet.do?method=findAll");
	}
	private void updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eid = Integer.parseInt(request.getParameter("eid"));
		Emp emp = empService.find(eid);
		List<Dept> deptList = deptService.find();
		
		request.setAttribute("emp", emp);
		request.setAttribute("deptList", deptList);
		
		
		request.getRequestDispatcher("/emp/updateUI.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int eid = Integer.parseInt(request.getParameter("eid"));
		empService.delete(eid);
		response.sendRedirect("EmpServlet.do?method=findAll");
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String ss=request.getParameter("p");
		int p;
		if(ss==null) {
			Integer x=(Integer) session.getAttribute("x");
			if(x!=null) {
				p=x;
			}else {
				p=1;
			}
		}else {
			try {
				p = Integer.parseInt(ss);
			} catch (NumberFormatException e) {
				p = 1;
			}
		}
		session.setAttribute("x", p);
		
		Page<Emp> page = empService.findPageData(p, 5);
		page.setServletName("EmpServlet.do");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/emp/findAllUI.jsp").forward(request, response);
	}
	
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Emp e =  WebUtils.request2bean(request, Emp.class);
		empService.save(e);
		response.sendRedirect("EmpServlet.do?method=findAll");
	}
	private void saveUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Dept> deptList = deptService.find();
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/emp/saveUI.jsp").forward(request, response);
	}

}
