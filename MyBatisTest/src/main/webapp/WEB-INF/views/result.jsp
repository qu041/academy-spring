<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result.jsp</title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body class="wide">
	<!-- result.jsp  -->
	<h1>쿼리 결과</h1>
	
	<div>
		<c:choose>
        <c:when test="${result == 1}">result:성공</c:when>
        <c:when test="${result == 0}">result:실패</c:when>
        <c:otherwise>결과 없음</c:otherwise>
    </c:choose>
	</div>
	
	<div>name: ${name }</div>
	
	<div>dto: ${dto }</div>
	
	<div>names: ${names }</div>
	
</body>
</html>