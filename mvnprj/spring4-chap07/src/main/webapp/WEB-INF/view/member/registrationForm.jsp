<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body>

<spring:hasBindErrors name="memberInfo" />
<form method="post">
<label for="email">이메일</label>: 
<input type="text" name="email" id="email" value="${memberInfo.email}"/>
<form:errors path="memberInfo.email"/> <br/>

<label for="name">이름</label>: 
<input type="text" name="name" id="name" value="${memberInfo.name}" />
<form:errors path="memberInfo.name"/> <br/>

<label for="password">암호</label>: 
<input type="password" name="password" id="password" value="${memberInfo.password}"/>
<form:errors path="memberInfo.password"/> <br/>

<label for="password">확인</label>: 
<input type="password" name="confirmPassword" id="confirmPassword" value="${memberInfo.confirmPassword}"/>
<form:errors path="memberInfo.confirmPassword"/> <br/>

<label>주소</label>:
주소1 
<input type="text" name="address.address1" value="${memberInfo.address.address1}" />
<form:errors path="memberInfo.address.address1"/> <br/>
주소2
<input type="text" name="address.address2" value="${memberInfo.address.address2}" />
<form:errors path="memberInfo.address.address2"/> <br/>
우편번호
<input type="text" name="address.zipcode" value="${memberInfo.address.zipcode}" />
<form:errors path="memberInfo.address.zipcode"/> <br/>

<label>
	<input type="checkbox" name="allowNoti" value="true" ${memberInfo.allowNoti ? 'checked' : '' }/>
	이메일을 수신합니다.
</label>
<br/>
<label for="birthday">생일</label>: 형식: YYYYMMDD, 예: 20140101
<input type="text" name="birthday" id="birthday" value='<fmt:formatDate value="${memberInfo.birthday}" pattern="yyyyMMdd" />'/>
<form:errors path="memberInfo.birthday"/> <br/>

<input type="submit" value="가입" />

</form>
</body>
</html>