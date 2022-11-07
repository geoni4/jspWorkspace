<%@page import="jwbook.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  request.setCharacterEncoding("utf-8");
%>
<%
  Member member = new Member();
  member.setName(request.getParameter("name"));
  member.setEmail(request.getParameter("email"));
%>

<%= member.getName() %>, <%= member.getEmail() %>
</body>
</html>