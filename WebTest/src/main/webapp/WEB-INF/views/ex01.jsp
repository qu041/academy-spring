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
	<!-- ex01.jsp  -->
	<h1>ex01.jsp</h1>
	
	<div>name: ${pageContextScope.name}</div>
	<div>name: ${requestScope.name}</div>
	<div>name: ${sessionScope.name}</div>
	<div>name: ${applicationScope.name}</div>

</body>
</html>