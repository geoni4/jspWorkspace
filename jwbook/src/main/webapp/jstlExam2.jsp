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
<h3>set, out</h3>
<%-- set 변수 선언, out 변수 출력 --%>
<c:set var="product1" value="<h2>애플 아이폰</h2>" />
<c:set var="product2" value="삼성 갤럭시 노트" />
<c:set var="intArray" value="${[1, 2, 3, 4, 5]}" />
<p>
  product1(jstl);
  <c:out value="${product1}" default="Not registered"
          escapeXml="false" />
</p>
<%-- <%=product1 %><br/> --%>
<p>product1(el):${product1}} <br/></p>
<p>intArray[2]:${intArray[2]} <br/></p>

<h3> forEach:배열 출력</h3>

<%-- <% for(int num: intArray){
    out.print(num+"<br/>");
    }
%> --%>

<ul>
  <c:forEach var="num" items="${intArray}" varStatus="i">
    <li>${i.index} : ${num} : ${i.count} : ${i.first} : ${i.last} : ${i.current} </li>
  </c:forEach>
</ul>


<ul>
  <c:forEach var="num" items="${intArray}">
    <li>${num}</li>
  </c:forEach>
</ul>


<hr/>

<h3>if</h3>
<c:set var="checkout" value="true" />
<c:if test="${checkout}">
  <p>주문 제품: ${product2}</p>
</c:if>
<c:if test="${!checkout}">
  <p>체크아웃 상태가 아님!</p>
</c:if>
<hr/>

<%-- <%
  if(list.contains(product2)){}
%> --%>

<c:if test="${!empty product2}">
  <p>
    <b>${product2} 이미 추가됨!!!</b><br/>
  </p>
</c:if>

<hr/>
<h3>choose, when, otherwise</h3>
<c:choose>
  <c:when test="${checkout}">
    <p>주문 제품: ${product2}</p>
  </c:when>
  <c:otherwise>
    <p>체크아웃 상태가 아님!!</p>
  </c:otherwise>
</c:choose>

<hr/><hr/>

<h3>forTokens</h3>
<c:set var="cities" value="Seoul/Tokyo/New york/Toronto" />
<c:forTokens var="city" items="${cities}"
  delims="/" varStatus="i">
  <c:if test="${i.first}">
    도시목록: 
  </c:if>
  ${city}
  <c:if test="${!i.last}">,
  </c:if>
</c:forTokens>
</body>
</html>





