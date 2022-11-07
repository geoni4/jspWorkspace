<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>회원 리스트</h2>
<ul>
  <c:forEach var="m" items="${list}">
  <li> <a href="/jwbook/member/info.do?id=${m.name}">${m.name} - ${m.email}</a></li>
  </c:forEach>
</ul>
</body>
</html>