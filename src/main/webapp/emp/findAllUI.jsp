<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="qin" prefix="q" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script>
	$(function() {
		$(".del").click(function() {
			// 在事件处理函数中，如果返回false，则就当这件事没发生过！！
			return confirm("你确定要删除吗？");
		});
	});
</script>
</head>
<body>
		<h3>emp list</h3>
	
	<a href="EmpServlet.do?method=saveUI">继续注册</a>
	<table class="table">
		<tr>
			<td>eid</td>
			<td>ename</td>
			<td>hiredate</td>
			<td>sal</td>
			<td>did</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="e">
			<tr>
				<td>${e.eid}</td>
				<td>${e.ename}</td>
				<td>${e.hiredate}</td>
				<td>${e.sal}</td>
				<td>
					${q:getDeptByDid(e.did).dname }
				</td>
				<td>
					<a class="del" href="EmpServlet.do?method=delete&eid=${e.eid}">删除</a>
					|
					<a href="EmpServlet.do?method=updateUI&eid=${e.eid}">修改</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<%@ include file="../include/page.jsp" %>				
			</td>
		</tr>
	</table>
</body>
</html>