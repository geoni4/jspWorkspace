<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
<h2>
<%-- requset.getParamter(파라미터명) 리턴타입 String
    request.getAttribute("속성명, 객체") 리턴타입 Object -> 형변환가능
 --%>
<%=request.getParameter("title") %>
</h2>
</body>
</html>