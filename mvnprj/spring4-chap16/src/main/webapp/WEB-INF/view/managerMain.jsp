<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>매니저 메인</title>
</head>
<body>
매니저(연결 계정: <sec:authentication property="name"/>) 메인 화면입니다.
<a href="<c:url value='/index'/>">[/index로 가기]</a>
</body>
</html>
