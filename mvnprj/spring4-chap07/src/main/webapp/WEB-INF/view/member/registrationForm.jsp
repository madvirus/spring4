<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body>

<form method="post">
이메일: <input type="text" name="email" /> <br/>
암호: <input type="password" name="password" /> <br/>
암호 확인: <input type="password" name="confirmPassword" /> <br/>
<input type="submit" value="가입" />

</form>
</body>
</html>