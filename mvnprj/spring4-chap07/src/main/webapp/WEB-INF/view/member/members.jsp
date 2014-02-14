<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
</head>
<body>
<ul>
	<c:forEach var="mi" items="${members}">
	<li><a href="/spring4-chap07/members/${mi.id}">${mi.name}</a></li>
	</c:forEach>
</ul>
</body>
</html>