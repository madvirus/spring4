<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>에러 발생</title>
</head>
<body>

작업 처리 도중 문제가 발생했습니다.
<%= exception %>

</body>
</html>