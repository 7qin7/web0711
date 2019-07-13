<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
			$("select:eq(0) option[value=${emp.did}]").prop("selected","selected");
		});
</script>
</head>
<body>
		<h3>update emp</h3>
		<form action="EmpServlet.do?method=update" method="post">
			<input type="hidden" name="eid" value="${emp.eid }"/>
			员工姓名:<input name="ename" value="${emp.ename }"/><br/>
			入职日期:<input name="hiredate" value="${emp.hiredate }" /><br/>
			员工月薪:<input name="sal" value="${emp.sal }" /><br/>
			所在部门：
					<select name="did">
						<c:forEach items="${deptList }" var="d">
							<option value="${d.did }">
								${d.dname }
							</option>
						</c:forEach>
					</select>
					<br />
		<button type="submit">修改</button>
		</form>
</body>
</html>