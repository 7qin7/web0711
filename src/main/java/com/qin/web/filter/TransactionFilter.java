package com.qin.web.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.qin.utils.JdbcUtils;

/**
 * Servlet Filter implementation class TransfactionFilter
 */
public class TransactionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			chain.doFilter(request, response);
			//提交事务
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(null, null, conn);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
}

