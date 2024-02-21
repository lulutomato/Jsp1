<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11_forEach_list</title>
</head>
<body>
<!--7.자바 객체 컬렉션(리스트) 활용하기 -->
  <h5>자바 객체 컬렉션(리스트) 활용하기</h5>
		<%
			//jdbc로 sql 조회한 결과 List에 활용합니다.
			CustomerVo vo
			= new CustomerVo("momo22","강모모","momo22@daum.net",29,null);
			
		List<CustomerVo> list = List.of (new CustomerVo("momo22","강모모","momo22@daum.net",29,null),
		new CustomerVo("momo11","김모모","momo223@daum.net",30,null),
		new CustomerVo("momo33","임모모","momo224@daum.net",31,null),
		new CustomerVo("momo44","양모모","momo225@daum.net",22,null),
		new CustomerVo("momo55","감모모","momo226@daum.net",44,null));
			
		pageContext.setAttribute("list",list);
		%>
		<!--컬렉션 list 에서 값을 하나씩 가져와 애트리뷰트 이름 vo 에 저장하기  -->
		<c:forEach items="${list }" var="vo" varStatus="status">
		<!-- varStatus 속성 index는 지금처럼 items로 컬렉션 다룰 때 사용합니다 -->
		<c:out value="${status.index }"/>,<c:out value ="${vo }"/>
		<!--vo 에 저장된 객체 속성을 각자 출력하기  -->
		<ul>
		
		<li>인덱스: <c:out value = "${status.index}"/> </li>
		<li>아이디:<c:out value = "${vo.customId}"/> </li>
		<li>이름:<c:out value = "${vo.name}"/> </li>
		<li>이메일:<c:out value = "${vo.email}"/> </li>
		<li>나이:<c:out value = "${vo.age}"/> </li>
		
		</ul>
</c:forEach>
</body>
</html>