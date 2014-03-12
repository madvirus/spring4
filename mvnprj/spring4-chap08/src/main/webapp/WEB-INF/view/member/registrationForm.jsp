<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body>

<form:form commandName="memberInfo">
<p>
	<label for="email">이메일</label>:
	<form:input path="email" /> 
	<form:errors path="email" />
</p>
<p>
	<label for="name">이름</label>: 
	<form:input path="name" />
	<form:errors path="name"/> <br/>
</p>
<p>
	<label for="password">암호</label>: 
	<form:password path="password" />
	<form:errors path="password" /> <br/>
</p>
<p>
	<label for="confirmPassword">확인</label>: 
	<form:password path="confirmPassword" />
	<form:errors path="confirmPassword" /> <br/>
</p>
<p>
	<label>주소</label>:
	주소1 
	<form:input path="address.address1" />
	<form:errors path="address.address1" /> <br/>
	주소2
	<form:input path="address.address2" />
	<form:errors path="address.address2" /> <br/>
	우편번호
	<form:input path="address.zipcode" />
	<form:errors path="address.zipcode" /> <br/>
</p>
<p>
	<form:checkbox path="allowNoti" label="이메일을 수신합니다."/>
</p>
<p>
	<label for="birthday">생일</label>: 형식: YYYYMMDD, 예: 20140101
	<form:input path="birthday" />
	<form:errors path="birthday" /> <br/>
</p>
<p>
	<label for="jobCode">직업</label>:
	<form:select path="jobCode" >
		<option value="">--- 선택하세요 ---</option>
		<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
	</form:select>
</p>
<p>
	<form:label path="favoriteOs">선호 OS</form:label>
	<form:checkboxes items="${favoriteOsNames}" path="favoriteOs"/>
	<form:errors path="favoriteOs" />
</p>
<p>
	<form:label path="tool">주로 사용하는 개발툴</form:label>
	<form:radiobuttons items="${tools}" path="tool" />
</p>
<p>
	<form:label path="allowance">용돈</form:label>: 형식: 2000WON, 10000USD
	<form:input path="allowance" />
	<form:errors path="allowance" />
</p>
<p>
	<form:label path="etc">기타</form:label>
	<form:textarea path="etc" cols="20" rows="3"/>
</p>

<input type="submit" value="가입" />

</form:form>

</body>
</html>