<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>이벤트 정보</title>
</head>
<body>
이벤트 정보:
<ul>
	<li>ID: ${event.id}</li>
	<li>이름: ${event.name}</li>
</ul>
추천 이벤트:
<ul>
	<c:forEach var="event" items="${recEventList}">
	<li><a href="/spring4-chap07/event/detail?id=${event.id}">${event.name}</a></li>
	</c:forEach>
</ul>

</body>
</html>