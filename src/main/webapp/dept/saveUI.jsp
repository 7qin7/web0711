<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h3>save dept</h3>
		<form action="../DeptServlet.do?method=save" method="post">
			部门名称：<input name="dname"/><br/>
			<button type="submit">GO</button>
		</form>
</body>
</html>