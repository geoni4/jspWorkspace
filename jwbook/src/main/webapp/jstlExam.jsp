<%@page import="jwbook.model.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL종합예제</title>
</head>
<body>
<h2>jstl 종합 예제</h2>
<hr/>
<%--
  3단부터 6단까지 구구단 출력하기
  3과 6은 <c:set>으로 선언하여 사용
--%>
<%
  List<Member> members = new ArrayList<Member>();
  
  members.add(new Member("hong", "hong@naver.com"));
  members.add(new Member("kim", "kim@naver.com"));
  members.add(new Member("wang", "wang@naver.com"));
  members.add(new Member("zang", "zang@naver.com"));
  members.add(new Member("kang", "kang@naver.com"));
  members.add(new Member("im", "im@naver.com"));
  members.add(new Member("zzang", "zzang@naver.com"));
   
  request.setAttribute("members", members);
%>
<c:set var="end" value="4"/>
<ul>
<c:forEach var="m" items="${members}" begin="0" end="${end}" varStatus="i">
  <li>${i.index} - ${m.name} - ${m.email}
</c:forEach>
</ul>


<c:set var="start" value="3"/>
<c:set var="end" value="6"/>
<c:forEach var="row" begin="${start}" end="${end}" varStatus="i">
  ${i.index }단
  <c:forEach var="col" begin="1" end="9" varStatus="j">
    ${i.index } x ${j.index } = ${i.index * j.index }
    <c:if test="${!j.last}">
      ,
    </c:if>
  </c:forEach>
  <br/>
</c:forEach>
</body>
</html>





