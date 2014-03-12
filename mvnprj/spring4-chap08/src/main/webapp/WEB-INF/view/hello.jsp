<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Hello</title>
</head>
<body>
<spring:message code="greeting" arguments="${me}, ${greeting}" />
</body>
</html>