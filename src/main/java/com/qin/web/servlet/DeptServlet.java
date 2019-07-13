package com.qin.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qin.domain.Dept;
import com.qin.domain.Page;
import com.qin.service.IDeptService;
import com.qin.service.impl.DeptServiceImpl;
import com.qin.utils.WebUtils;

/**
 * Servlet implementation class DeptServlet
 */
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IDeptService service=new DeptServiceImpl();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String method = request.getParameter("method");
		
		if("save".equals(method)) {
			save(request, response);
		} else if("findAll".equals(method)) {
			findAll(request, response);
		} else if("delete".equals(method)) {
			delete(request, response);
		} else if("updateUI".equals(method)) {
			updateUI(request, response);
		} else if("update".equals(method)) {
			update(request, response);
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Dept d=WebUtils.request2bean(request, Dept.class);
		service.update(d);
		
		response.sendRedirect("DeptServlet.do?method=findAll");
	}
	private void updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer did = Integer.parseInt(request.getParameter("did"));
		Dept dept = service.find(did);
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("/dept/updateUI.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer did = Integer.parseInt(request.getParameter("did"));
		service.delete(did);
		// 重定向
		response.sendRedirect("DeptServlet.do?method=findAll");
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ss=request.getParameter("p");
		if(ss==null) {
			ss="1";
		}
		int p;
		try {
			p=Integer.parseInt(ss);
		}catch(NumberFormatException e){
			p=1;
		}
		
		Page page=service.findPageDate(p, 5);
		page.setServletName("DeptServlet.do");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/dept/findAllUI.jsp").forward(request, response);
	}
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Dept d = WebUtils.request2bean(request, Dept.class);
		service.save(d);
		
		// 重定向
		response.sendRedirect("DeptServlet.do?method=findAll");
	}

}
