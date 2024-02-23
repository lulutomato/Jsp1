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
<link rel="stylesheet"    href="assets/css/register.css" >
</head>
<body>
<div class = "contents-wrap">
<h3 style="text-align:center;">고객 등록</h3>
<hr>
		<form action="productdel.cc" method="post">
		 <ul class="join-wrap" >
              <li>상품명</li>
              <li>
                <input name="userid" type="text"
                  placeholder="상품명을 입력해 주세요." />
              </li>
              </ul>
		<button class="del-btn">삭제</button>
		</form>
		</div>
</body>
</html>