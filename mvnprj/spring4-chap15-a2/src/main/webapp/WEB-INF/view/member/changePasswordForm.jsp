<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 암호 변경</title>
</head>
<body>

<form:form commandName="command">
<label for="memberId">회원 ID</label>:
<form:input path="memberId"/>
<form:errors path="memberId" />
<br/>
<label for="currentPassword">현재 암호</label>:
<form:password path="currentPassword"/>
<form:errors path="currentPassword" />
<br/>
<label for="newPassword">새 암호</label>:
<form:password path="newPassword"/>
<form:errors path="newPassword" />
<br/>

<input type="submit" value="암호 변경" />
</form:form>

</body>
</html>