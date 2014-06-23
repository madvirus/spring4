<%@ page contentType="text/html; charset=utf-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>

<form action="<c:url value='/user/login'/>" method="post">
    <label for="name">사용자ID</label>:
    <input type="text" name="userid" /> 
    <br/>
    
    <label for="password">암호</label>:
    <input type="password" name="password" /> 
    <br/>
    
    <input type="hidden" name="returl" value="${param.returl}" />
    <input type="submit" value="로그인" />
</form>

</body>
</html>