<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>홈 페이지</title>
</head>
<body>
<ul>
	<sec:authorize access="hasAuthority('USER_MANAGER')">
	<li><a href="<c:url value='/admin/usermanager/main' />">
	사용자 관리자</a></li>
	</sec:authorize>

	<sec:authorize access="hasAuthority('USER')">
	<li><a href="<c:url value='/member/main' />">회원메인</a></li>
	</sec:authorize>
	
	<sec:authorize access="!isAuthenticated()">
	<%--
	<li><a href="<c:url value='/spring_security_login' />">로그인</a></li>
	--%>
	<li><a href="<c:url value='/user/loginform' />">로그인</a></li>
	<li><a href="<c:url value='/user/join' />">회원가입</a></li>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
	<li><a href="<c:url value='/user/logout' />">로그아웃</a></li>
	</sec:authorize>
</ul>
</body>
</html>
