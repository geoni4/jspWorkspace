<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
<table>
<c:forEach var="student" items="${list}">
<tr>
	<td>${student.seq}</td>
	<td>${student.name}
		<a href="/student_study/student/info.do?seq=${student.seq}">상세정보로 이동하기</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>