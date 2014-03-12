<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head><title><spring:message code="login.form.title"/></title></head>
<body>

<form:form commandName="loginCommand">
<form:hidden path="securityLevel"/>
<form:errors element="div" />
<p>
	<label for="email"><spring:message code="email" /></label>: 
	<input type="text" name="email" id="email" value="${loginCommand.email}">
	<form:errors path="email"/>
</p>
<p>
	<label for="password"><spring:message code="password" /></label>: 
	<input type="password" name="password" id="password">
	<form:errors path="password"/>
</p>
<p>
    <label for="loginType"><spring:message code="login.form.type" /></label>
    <form:select path="loginType" items="${loginTypes}" />

<%-- 	<form:select path="loginType"> --%>
<!-- 		<option value="">--- 선택하세요 ---</option> -->
<%-- 		<form:options items="${loginTypes}"/> --%>
<%-- 	</form:select> --%>

<%-- 	<form:select path="loginType"> --%>
<%-- 		<form:option value="일반회원" /> --%>
<%-- 		<form:option value="기업회원">기업</form:option> --%>
<%-- 		<form:option value="헤드헌터회원" label="헤드헌터" /> --%>
<%-- 	</form:select> --%>
</p>

<input type="submit" value="<spring:message code="login.form.login" />">
</form:form>

<ul>
	<li><spring:message code="login.form.help" /></li>
</ul>
</body>
</html>