<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>홈 메인</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="name"/>님,
</sec:authorize>
홈 메인 화면입니다.
<a href="<c:url value='/index'/>">[/index로 가기]</a>
</body>
</html>
