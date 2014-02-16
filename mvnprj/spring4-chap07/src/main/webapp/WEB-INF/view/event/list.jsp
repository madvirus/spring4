<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>이벤트 목록</title>
</head>
<body>
현재 오픈된 이벤트:
<ul>
	<c:forEach var="event" items="${eventList}">
	<li><a href="/spring4-chap07/event/detail?id=${event.id}">${event.name}</a></li>
	</c:forEach>
</ul>
</body>
</html>