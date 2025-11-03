<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<!-- add.jsp  -->
	<h2>회원 가입</h2>
	<form method="post" action="/project/member/addok">
	<table class="vertical">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" required></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" required></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" required></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" name="age" min="1" max="120" required></td>
		</tr>
	</table>
	<div>
		<button>가입하기</button>
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

</body>
</html>