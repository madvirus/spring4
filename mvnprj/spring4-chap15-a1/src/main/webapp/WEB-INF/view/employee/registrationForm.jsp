<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>직원 등록</title>
</head>
<body>

<form:form commandName="newEmployee">
<label for="number">사번</label>:
<form:input path="number"/>
<form:errors path="number" />
<br/>
<label for="name">이름</label>:
<form:input path="name"/>
<form:errors path="name" />
<br/>
<label for="homeAddr1">집주소1</label>:
<form:input path="homeAddress.addr1" id="homeAddr1"/>
<form:errors path="homeAddress.addr1" />
<br/>
<label for="homeAddr2">집주소2</label>:
<form:input path="homeAddress.addr2" id="homeAddr2"/>
<form:errors path="homeAddress.addr2" />
<br/>
<label for="homeZipCode">우편번호</label>:
<form:input path="homeAddress.zipCode" id="homeZipCode"/>
<form:errors path="homeAddress.zipCode" />
<br/>
<label for="birtyYear">태어난 연도</label>:
<form:input path="birtyYear"/>
<form:errors path="birtyYear" />
<br/>
<label for="teamId">팀 번호</label>:
<form:input path="teamId"/>
<form:errors path="teamId" />
<br/>
<label for="joinedDate">입사일</label>:
<form:input path="joinedDate"/>
<form:errors path="joinedDate" />
<br/>

<input type="submit" value="등록" />
</form:form>

</body>
</html>