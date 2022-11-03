<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page isErrorPage ="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오류가 발생하였습니다. 빠른 시간 내에 조치하겠습니다.</h1>
<% out.println(exception.getMessage()); %>
</body>
</html>