<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보 수정</title>
</head>
<body>

<form method="post">
<input type="hidden" name="id" value="${modReq.id}" />
<label for="email">이메일</label>: 
<input type="text" name="email" id="email" value="${modReq.email}"/> <br/>
<label for="name">이름</label>: 
<input type="text" name="name" id="name" value="${modReq.name}"/> <br/>
<label>
	<input type="checkbox" name="allowNoti" value="true" 
		<c:if test='${modReq.allowNoti}'>checked='checked'</c:if> />
	이메일을 수신합니다.
</label>
<br/>
<label for="currentPassword">현재 암호</label>: 
<input type="password" name="currentPassword" id="currentPassword" /> <br/>
<input type="submit" value="수정" />

</form>
</body>
</html>