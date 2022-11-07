<%@page import="jwbook.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
  Member user=new Member();
  user.setName("홍길동");
  
  // pageContext, request, session, application에 속성으로 저장을 하면
  // EL로 해당 객체를 사용할 수 있다.
  pageContext.setAttribute("user", user);
%>
</head>
<body>
<%-- EL은 request로 attribute를 적용해야..  --%>
${10 + 20}<br/>
${10 * 20}<br/>
${true && false }<br/>
${10 >= 20 }<br/>
${user.name}<br/>
${user.name == "홍길동" ? "교수": "학생" }<br/>


</body>
</html>