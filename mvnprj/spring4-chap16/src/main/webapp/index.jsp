<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>인덱스 페이지</title>
	<script type="text/javascript">
	function logout() {
		var form = document.getElementById("logoutForm");
		form.submit();
	}
	</script>
</head>
<body>
<ul>
	<li><a href="<c:url value='/home/main' />">/home/main</a></li>
	<li><a href="<c:url value='/member/main' />">/member/main</a></li>
	<li><a href="<c:url value='/manager/main' />">/manager/main</a></li>
	<li><a href="<c:url value='/admin/main' />">/admin/main</a></li>
	<li><a href="javascript:logout()">/logout</a></li>
</ul>

<form action="<c:url value='/logout' />" id="logoutForm">
</form>
</body>
</html>
