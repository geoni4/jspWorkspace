<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 폼 만들기 예제</title>
<style>
h2{
  border-radius: 5px;
  background-color: wheat;
  text-align:center;
  padding: 15px 0;
}
#regform{
  padding: 15px 20px;
  border-radius: 10px;
  margin: auto;
  width: 50%;
  background-color: SandyBrown;

</style>
</head>
<body>
<h2>회원가입</h2>
<hr/>
<div id="regform">    
  <form method="post" name="form1" action="regResult.jsp">
    <label>이름</label>
    <input name='name' value="일지매" size='40'> <br/>
    <hr/>
    <label>이메일</label>
    <input type="email" name='email' value="il@daum.net" size='40'> <br/>
    <button type="submit">가입</button>
  </form>
</div>
<div>
  <h3>가입 정보</h3>
  <hr/>
    이름: <span id='rname'></span>
    이메일: <span id='remail'></span>
</div>


<script>
function signUp(){
	alert('가입할까요?');
	document.getElementById('regform').style.display="none";
	document.getElementById('rname').innerHTML = document.form1.name.value;
	document.getElementById('remail').innerHTML = document.form1.email.value;
	document.getElementById('result')
			.setAttribute('style', 'display:block; background-color: Khaki;');
}
</script> 
</body>
</html>