<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h3>update dept</h3>
		<form action="DeptServlet.do?method=update" method="post">
			<input type="hidden" name="did" value="${dept.did }"/><br/>
			部门名：<input name="dname" value="${dept.dname }"/><br/>
			<button type="submit">GO</button>
		</form>
</body>
</html>