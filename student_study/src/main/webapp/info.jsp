<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보</title>
</head>
<body>
<h2>상세정보</h2>
${student.seq } ${student.name } ${student.school } ${student.birth} ${student.email}<br/>
<a href="/student_study/student/list.do">리스트로 이동하기</a>
</body>
</html>