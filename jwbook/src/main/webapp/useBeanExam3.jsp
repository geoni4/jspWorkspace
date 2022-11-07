<%@page import="jwbook.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usebean</title>
</head>
<body>
<%
  request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="jwbook.model.Member" scope="request"/>
<jsp:setProperty property="*" name="member"/>
이름: <jsp:getProperty property="name" name="member"/><br>
이메일: <jsp:getProperty property="email" name="member"/><br>

</body>
</html>