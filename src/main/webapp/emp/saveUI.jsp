<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
		<h3>save emp</h3>
		<form action="EmpServlet.do?method=save" method="post">
			员工姓名:<input name="ename" /> <br />
			入职日期:<input name="hiredate" /> <br />
			员工月薪:<input name="sal" /> <br />
			所在部门:
					<select name="did">
						<c:forEach items="${deptList }" var="d">
							<option value="${d.did }">${d.dname }</option>
						</c:forEach>
					</select>
			<button type="submit">GO</button>
		</form>
</body>
</html>