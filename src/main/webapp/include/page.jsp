<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<span style="color:red;font-size:30px;">
	${page.p }
</span>
/
${page.maxPage}
<a href="${page.servletName }?method=findAll&p=1">首页</a>
<a href="${page.servletName }?method=findAll&p=${page.prev }">上一页</a>
<c:forEach begin="${page.startPage }" end="${page.endPage }" var="x">
	<c:if test="${x==page.p }">
		<span style="color:red;">${x }</span>
	</c:if> 
	<c:if test="${x!=page.p }">
		<a href="${page.servletName }?method=findAll&p=${x }">${x }</a>
	</c:if>
</c:forEach>
<a href="${page.servletName }?method=findAll&p=${page.next }">下一页</a>
<a href="${page.servletName }?method=findAll&p=${page.maxPage }">末页</a>
<form action="${page.servletName }?method=findAll" method="post" style="display: inline;">
	跳到第<input size="1" type="text" name="p" />页
	<button type="submit">GO</button>
</form>

共【${page.rowCount }】条记录