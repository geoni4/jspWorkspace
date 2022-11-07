<%@page import="jwbook.model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member List</h1>
<%--  <% 
  List<Member> mList = (List<Member>)request.getAttribute("mlist"); 
 %>
 <%
  for(Member m : mList){
%>
<%=m.getName() %>, <%=m.getEmail() %>
<br/>
<%} %> --%>

<hr/>

<c:forEach var="m" items="${mlist}">
${m.name}, ${m.email} <br/><%-- out.print(m.getName() +", " + m.getEmail()) --%>
</c:forEach>

</body>
</html>