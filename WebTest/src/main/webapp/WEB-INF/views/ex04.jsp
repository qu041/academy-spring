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
	<!-- ex04.jsp  -->
	<h1>ex04.jsp</h1>
	
	<div><a href="/java/ex04get.do">GET 요청하기</a></div>
	
	<hr>
	
	<form method="POST" action="/java/ex04post.do">
		<button>POST 요청하기</button>
	</form>


</body>
</html>