<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 주문 목록</title>
</head>
<body>
${member.name}님의 주문 목록:
<ul>
	<c:forEach var="order" items="${orders}">
	<li><a href="/spring4-chap07/members/${order.memberId}/orders/${order.id}">${order.id}</a></li>
	</c:forEach>
</ul>
</body>
</html>