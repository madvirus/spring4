<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head><title><spring:message code="login.form.title"/></title></head>
<body>

<form:form commandName="loginCommand">
<form:errors element="div" />
<label for="email"><spring:message code="email" /></label>: 
<input type="text" name="email" id="email" value="${loginCommand.email}">
<form:errors path="email"/> <br>

<label for="password"><spring:message code="password" /></label>: 
<input type="password" name="password" id="password">
<form:errors path="password"/> <br>
<br/>

<input type="submit" value="<spring:message code="login.form.login" />">

</form:form>

<ul>
	<li><spring:message code="login.form.help" /></li>
</ul>
</body>
</html>