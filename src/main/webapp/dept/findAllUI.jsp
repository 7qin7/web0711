<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script>
	$(function(){
		$(".del").click(function(){
				return confirm("你确定要删除吗？");
			});
		});
</script>
</head>
<body>
		<h3>dept list</h3>
		
		<a href="dept/saveUI.jsp">继续注册</a>
		<table class="table">
			<tr>
				<td>ID</td>
				<td>部门名称</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${page.list }" var="d">
				<tr>
					<td>${d.did }</td>
					<td>${d.dname }</td>
					<td>
						<a class="del" href="DeptServlet.do?method=delete&did=${d.did }">删除</a>
						|
						<a href="DeptServlet.do?method=updateUI&did=${d.did }">编辑</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">
					<%@ include file="../include/page.jsp" %>
				</td>
			</tr>
		</table>
</body>
</html>