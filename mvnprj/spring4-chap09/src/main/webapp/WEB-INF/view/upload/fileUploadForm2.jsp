<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head><title>파일 업로드</title></head>
<body>

<hr>
<h3>서블릿3 Part 사용</h3>
<form action="servletPart.do" method="POST" enctype="multipart/form-data">
	제목: <input type="text" name="title"><br/> 
	파일: <input type="file" name="f"><br/> 
    <input type="submit" value="전송" /> 
</form>

</body>
</html>