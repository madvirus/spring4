<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body>

<form method="post">
<label for="email">이메일</label>: 
<input type="text" name="email" id="email" /> <br/>
<label for="name">이름</label>: 
<input type="text" name="name" id="name" /> <br/>
<label for="password">암호</label>: 
<input type="password" name="password" id="password" /> <br/>
<label for="password">확인</label>: 
<input type="password" name="confirmPassword" id="confirmPassword" /> <br/>
<label>주소</label>:
주소1 
<input type="text" name="address.address1" /> <br/>
주소2
<input type="text" name="address.address2" /> <br/>
우편번호
<input type="text" name="address.zipcode" /> <br/>

<label>
	<input type="checkbox" name="allowNoti" value="true" />
	이메일을 수신합니다.
</label>
<br/>
<input type="submit" value="가입" />

</form>
</body>
</html>