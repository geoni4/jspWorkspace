<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
<h2>상품 목록</h2>

<table border="1">
<tr>
  <th>번호</th><th>상품명</th><th>가격</th>
</tr>
<c:forEach var="p" items="${products}" varStatus="i">
  <tr>
    <td>${i.count}</td><td><a href='/jwbook/pcontrol?action=info&id=${p.id}'/>${p.name}</td><td>${p.price}</td>
  </tr>
</c:forEach>

</table>
</body>
</html>