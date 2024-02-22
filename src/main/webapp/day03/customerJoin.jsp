<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/customers.css">
</head>
<body>
<h3>회원 등록</h3>
<hr>
<c:forEach items = "${list }" var= "vo" varStatus="status">
	<li>
	<ul>
	
	
		<li><c:out value = "${fn:toUpperCase(vo.customId)}"/></li> <!--function은 el 안에다가 쓴다  -->
		
		<li><c:out value = "${vo.name }"/></li>
		<li><c:out value = "${vo.email }"/></li>
		<li><c:out value = "${vo.age }"/></li>

 	</ul>
	</li>


</c:forEach>
</body>
</html>