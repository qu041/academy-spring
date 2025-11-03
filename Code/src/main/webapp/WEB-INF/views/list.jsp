<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
<script src="https://kit.fontawesome.com/7121714adf.js"></script>
<style>
	table th:nth-child(1) {width: 100px;}
	table th:nth-child(2) {width: auto;}
	table th:nth-child(3) {width: 180px;}
</style>

</head>
<body>
	<!-- list.jsp  -->
	<header>
	<h1>Code <small>review</small></h1>
	</header>
	
	<h2>List</h2>
	
	
	<table>
		<tr>
			<th>언어</th>
			<th>제목</th>
			<th>작성날짜</th>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr>
			<td>
			<i class="${dto.ldto.icon }" style="color:${dto.ldto.color }"></i>
			
			${dto.language }
			</td>
			<td class="left">
				<a href="/code/view.do?seq=${dto.seq}">${dto.subject}</a>
			</td>
			<td>${dto.regdate }</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<button type="button" onclick="location.href='/code/add.do';">쓰기</button>
	</div>
	
</body>
</html>