<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
<h2>상품정보 수정</h2>
<hr/>
<form method="post" action="/jwbook/pcontrol?action=update">
<ul>
     <li><label class="form-label">상품코드</label>
      <input type="text" name="id" value='${p.id}' readonly class="form-control"></li>
      <li><label class="form-label">상품명</label>
      <input type="text" name="name"  value='${p.name}' autofocus class="form-control"></li>
      <li><label class="form-label">메이커</label>
      <input type="text" name="maker"  value='${p.maker}' class="form-control"></li>
      <li><label class="form-label">가격</label>
      <input type="text" name="price"  value='${p.price}' class="form-control"></li>
      <li><label class="form-label">등록일자</label>
      <input type="text" name="price"  value='${p.regdate}' readonly class="form-control"></li>
      <button type="submit" class="btn btn-success mt-3">수정하기</button>
      <button type="reset">초기화</button>
</ul>
<div>
<a href="/jwbook/pcontrol?action=info&id=${p.id}">리스트로 돌아가기</a>
</div>
</body>
</html>