<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>13_jdbc_jstl</title>
<style type= "text/css">
 table {width: 700px;}
 td {border : 1px solid gray ; padding: 5px;
 min-width:15rem;}
 th{border : 1px solid gray ; padding: 5px;
 background-color : pink; 


 }

</style>
</head>
<body>
	<h3>2번 소스파일 스크립트릿과 출력식을 jstl과 el로 변경하기</h3>
	<hr>
	<p>TblCustomerDao 메소드로 db접속 및 조회 결과 출력하는 연습입니다.</p>
<hr>
<%
	TblCustomerDao dao = new TblCustomerDao();
	List<CustomerVo> list = dao.allCustomers();
	pageContext.setAttribute("list",list);
%>
	<table>
	<tr>
		
		<th>인덱스</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>나이</th>
		<th>가입 날짜</th>
	</tr>
	<c:forEach items="${list }" var="vo" varStatus="status">
	<tr>
		
		<td><c:out value = "${status.index + 1 }"/></td>
		<td><c:out value = "${fn:toUpperCase(vo.customId)}"/></td>
		
		<td><c:out value = "${vo.name }"/></td>
		<td><c:out value = "${vo.email }"/></td>
		<td><c:out value = "${vo.age }"/></td>
		<td><fmt:formatDate value = "${vo.reg_date }" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
	</tr>
</c:forEach>
</table>
</body>
</html>
<!--교재 422페이지 taglib의 uri 가 다릅니다.(톰캣 버전 차이) -->