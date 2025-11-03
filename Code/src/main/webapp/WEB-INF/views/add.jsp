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
	<header>
	<h1>Code <small>review</small></h1>
	</header>
	
	<h2>Add</h2>
	<form method="post" action="/code/addok.do">
		<table class="vertical">
			<tr>
				<th>언어</th>
				<td>
					<select name="language">
					<c:forEach items="${llist}" var="ldto">
						<option value="${ldto.name}">${ldto.name}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<th>코드</th>
				<td><textarea name="code" required class="full"></textarea></td>
			</tr>
		</table>
		<div>
			<button>쓰기</button>
		</div>
	</form>

</body>
</html>