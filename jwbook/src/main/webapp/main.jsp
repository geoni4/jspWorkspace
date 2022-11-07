<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main페이지</title>
</head>
<body>
<h1>메인 페이지</h1>
<%-- title명으로 My Homepage값이 전달됨 --%>
<jsp:include page="header.jsp" >
  <jsp:param value="My Homepage" name="title"/> 
</jsp:include>

</body>
</html>