<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>이벤트 목록</title>
</head>
<body>
<form>
<label><input type="checkbox" name="allType" value="true">전체</label>
<c:forEach var="eventType" items="${eventTypes}">
<label><input type="checkbox" name="types" value="${eventType}">${eventType}</label>
</c:forEach>
시작일:<input type="text" name="from" />~<input type="text" name="to" />
<input type="submit" value="검색" />
</form>
현재 오픈된 이벤트:
<ul>
	<c:forEach var="event" items="${eventList}">
	<li><a href="/spring4-chap07/event/detail?id=${event.id}">${event.name} [${event.type}]</a></li>
	</c:forEach>
</ul>
추천 이벤트:
<ul>
	<c:forEach var="event" items="${recEventList}">
	<li><a href="/spring4-chap07/event/detail?id=${event.id}">${event.name}</a></li>
	</c:forEach>
</ul>
</body>
</html>