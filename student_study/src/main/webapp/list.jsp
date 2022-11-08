<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
ul{
  list-style: none;
}
</style>
</head>
<body>
<table>
<c:if test="${!empty list}">
<ul>
<c:forEach var="student" items="${list}">
	<li><a href="/student_study/student/info.do?seq=${student.id}">${student.id}</a> - ${student.username} - ${student.univ} - ${student.birth}
        - ${student.email}
		
	</li>

</c:forEach>
</ul>
</c:if>
</body>
</html>