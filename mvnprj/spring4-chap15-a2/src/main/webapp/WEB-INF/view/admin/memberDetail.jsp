<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보 상세</title>
</head>
<body>

이름: ${member.name} <br/>
락커: 
	<c:if test="${member.locker != null}">
	${member.locker.id}번 (크기: ${member.locker.size})
	</c:if>
	<c:if test="${empty member.locker}">
	없음
	</c:if>
</body>
</html>