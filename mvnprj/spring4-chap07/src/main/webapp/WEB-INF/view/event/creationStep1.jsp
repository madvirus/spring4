<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="net.madvirus.spring4.chap07.event.EventType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>이벤트 생성: ${project}</title>
</head>
<body>

<form:form commandName="eventForm" action="/spring4-chap07/newevent/step2">

<label for="name">이벤트 명</label>: 
<input type="text" name="name" id="name" value="${eventForm.name}"/> 
<form:errors path="name"/><br/>

<label for="type">타입</label>:
<select name="type" id="type">
	<option value="">선택하세요</option>
	<c:forEach var="type" items="<%= EventType.values() %>">
	<option value="${type}" ${eventForm.type == type ? 'selected' : ''}>${type}</option>
	</c:forEach>
</select> 
<form:errors path="type"/><br/>

<label>이벤트 기간</label>: 
<input type="text" name="beginDate" value='<fmt:formatDate value="${eventForm.beginDate}" pattern="yyyyMMdd"/>'/>부터 
<input type="text" name="endDate" value='<fmt:formatDate value="${eventForm.endDate}" pattern="yyyyMMdd"/>'/>까지
<form:errors path="beginDate"/><br/>
<form:errors path="endDate"/><br/>

<input type="submit" value="다음 단계로" />
</form:form>

세션 존재 여부: <%= session.getAttribute("eventForm") != null ? "존재" : "없음" %>
</body>
</html>