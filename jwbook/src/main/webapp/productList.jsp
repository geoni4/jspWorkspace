<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<title>상품 목록</title>
</head>
<body>
<c:forEach var="p" items="${products}" varStatus="i">
</c:forEach>
<div class="container w-75 mt-5 mx-auto">
    <h2>상품 목록</h2>
    <hr>
    <ul class="list-group">
    <c:forEach var="p" items="${products}" varStatus="i">
      <li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center"><a href='/jwbook/pcontrol?action=info&id=${p.id}' class="text-decoration-none">
        [${i.count}] ${p.name} - ${p.price}</a>
        <a href="/jwbook/pcontrol?action=delete&id=${p.id}"><span class="badge bg-secondary">&times;</span></a>
      </li>
    </c:forEach> 
  </ul>
  <hr>

<button class="btn btn-outline-info mb-3" type="button" data-bs-toggle="collapse" data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">상품 등록</button>
  <div class="collapse" id="addForm">
    <div class="card card-body">
    <form method="post" action="/jwbook/pcontrol?action=insert">
      
      <label class="form-label">아이디</label>
      <input type="text" name="id" class="form-control">
      <label class="form-label">상품명</label>
      <input type="text" name="name" class="form-control">
      <label class="form-label">메이커</label>
      <input type="text" name="maker" class="form-control">
      <label class="form-label">가격</label>
      <input type="text" name="price" class="form-control">
      <button type="submit" class="btn btn-success mt-3">등록</button>
    </form>
    </div>
  </div>
  </div>
</body>
</html>