<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 목록</title>
</head>
<body>
폴더 트리:
<ul>
	<c:forEach var="folderId" items="${folderIds}">
	<li>${folderId}</li>
	</c:forEach>
</ul>
</body>
</html>