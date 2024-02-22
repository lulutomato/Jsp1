<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 전체 조회</title>
<link rel="stylesheet" href="assets/css/customers.css">
</head>
<body>
<h3>구매 전체 조회</h3>
<hr>
<c:forEach items= "${list }" var="vo" varStatus="status">
	<li>
	<ul class = "row">
	<li><c:out value = "${status.index + 1 }"/></li>
	<li><c:out value="${fn:toUpperCase(vo.customid)}"/></li>
	<li><c:out value = "${vo.pcode }"/></li>
	<li><c:out value = "${vo.quantity }"/></li>
	<li><fmt:formatDate value = "${vo.buyDate }" pattern="yyyy-MM-dd a hh:mm:ss"/></li>
	
	</ul>
	</li>



</c:forEach>
</body>
</html>