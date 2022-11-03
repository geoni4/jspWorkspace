<%@page import="jwbook.Todo"%>
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
<h1>Todo list 페이지</h1>
<c:forEach var="todo" items="${todolist}">
  ${todo.tno},
  ${todo.title},
  ${todo.todoContent},
  ${todo.dueDate},
  ${todo.endDate }<br/>

</c:forEach>
<hr/>
<%
  List<Todo> todoList = (List<Todo>)request.getAttribute("todolist");
for(int i =0;i<todoList.size();i++){
  Todo todo = todoList.get(i); %>
  
  <%=todo.getTno() + ", "%>
  <%=todo.getTitle() + ", "%>
  <%=todo.getTodoContent() + ", "%>
  <%=todo.getDueDate() + ", "%>
  <%=todo.getEndDate() + "<br/>"%>
<%}%>
</body>
</html>