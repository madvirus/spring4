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
<label>주소</label>:
주소1 
<input type="text" name="address.address1" value="${modReq.address.address1}" /> <br/>
주소2
<input type="text" name="address.address2" value="${modReq.address.address2}" /> <br/>
우편번호
<input type="text" name="address.zipcode" value="${modReq.address.zipcode}" /> <br/>

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