<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body>

<form:form method="post" commandName="newUser">
    <label for="name">사용자이름</label>:
    <form:input path="name"/> 
    <form:errors path="name"/> <br/>
    
    <label for="password">암호</label>:
    <form:password path="password"/> 
    <form:errors path="password"/> <br/>
    
    <label for="confirm">암호 확인</label>:
    <form:password path="confirm"/> 
    <form:errors path="confirm"/> <br/>
    
    <input type="submit" value="가입" />
</form:form>

</body>
</html>