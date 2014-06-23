<%@ page contentType="text/html; charset=utf-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>인덱스 페이지</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="name"/>님 환영합니다.
</sec:authorize>
<ul>
	<li><a href="<c:url value='/member/main' />">회원 메인</a></li>
	<sec:authorize access="isAuthenticated()">
	<li><a href="<c:url value='/user/logout' />">로그아웃</a></li>
	</sec:authorize>
</ul>
</body>
</html>
