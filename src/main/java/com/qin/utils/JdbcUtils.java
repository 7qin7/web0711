package com.qin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

public class JdbcUtils {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/maven0711";
	private static String user="root";
	private static String pwd="";
	
	private static ThreadLocal<Connection> tl=new ThreadLocal<>();
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn=tl.get();
		if(conn==null) {
			conn=DriverManager.getConnection(url, user, pwd);
			tl.set(conn);
		}
		return conn;
	}
	
	public static void free(ResultSet rs,Statement stmt,Connection conn) {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
					try {
						if(stmt!=null)stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
							try {
								if(conn!=null)conn.close();
								tl.remove();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
			}
	}
	//该方法专门封装insert delete update
	public static void update(String sql,Object[] params) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.free(null, ps, null);
		}
	}
	
	//该方法专门封装查询操作
	//sql:select * from emp limit ?,?
	//params:[0,5]
	//rsh:BeanListHandler(Emp.class);
	public static Object read(String sql,Object[] params,ResultSetHandler rsh) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			if(params!=null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs=ps.executeQuery();
			//处理结果集，交给用户，留一个接口
			Object obj=rsh.handle(rs);
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(rs, ps, null);
		}
	}
}
