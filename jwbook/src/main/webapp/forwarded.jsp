<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${user.name}<br/>
${requestScope.user.name }<br/>
${sessionScope.user.name }<br/>
${applicationScope.user.name }<br/>
</body>
</html>