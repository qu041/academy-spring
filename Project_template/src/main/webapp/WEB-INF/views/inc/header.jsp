<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<header>
	<h1>Spring Project</h1>
		<ul>
			<sec:authorize access="isAnonymous()">
			<li><a href="/project/member/add">회원가입</a></li>
			<li><a href="/project/member/login">로그인</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<li><a href="#!" id="btnLogout">로그아웃</a></li>
			</sec:authorize>
		</ul>
	</header>
	
	<form method="post" action="/project/member/logout" id="formLogout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
	<script>
		document.getElementById('btnLogout').onclick = () => {
			document.getElementById('formLogout').submit();
		};
	
	</script>
	
	
</body>
</html>