<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 정보 수정</title>
</head>
<body>

<form:form commandName="modReq">
<input type="hidden" name="id" value="${modReq.id}" />
<label for="email">이메일</label>: 
<input type="text" name="email" id="email" value="${modReq.email}"/> 
<form:errors path="email"/><br/>

<label for="name">이름</label>: 
<input type="text" name="name" id="name" value="${modReq.name}"/> 
<form:errors path="name"/><br/>

<label for="address1">주소1</label>: 
<input type="text" id="address1" name="address.address1" value="${modReq.address.address1}" /> 
<form:errors path="address.address1"/><br/>
<label for="address2">주소2</label>:
<input type="text" id="address2" name="address.address2" value="${modReq.address.address2}" />
<form:errors path="address.address2"/><br/>
<label for="zipcode">우편번호</label>:
<input type="text" id="zipcode" name="address.zipcode" value="${modReq.address.zipcode}" /> <br/>

<label>
	<input type="checkbox" name="allowNoti" value="true" ${modReq.allowNoti ? 'checked' : ''} />
	이메일을 수신합니다.
</label>
<br/>
<label for="currentPassword">현재 암호</label>: 
<input type="password" name="currentPassword" id="currentPassword" /> 
<form:errors path="currentPassword"/><br/>
<input type="submit" value="수정" />
</form:form>
</body>
</html>