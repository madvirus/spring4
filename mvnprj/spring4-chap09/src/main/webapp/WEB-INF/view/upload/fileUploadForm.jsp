<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head><title>파일 업로드</title></head>
<body>

<h3>MultipartFile 사용</h3>
<form action="multipartFile" method="POST" enctype="multipart/form-data">
	제목: <input type="text" name="title"><br/> 
	파일: <input type="file" name="f"><br/> 
    <input type="submit" value="전송" /> 
</form>

<hr>
<h3>MultipartHttpServletRequest 사용</h3>
<form action="multipartHttpServletRequest" method="POST" enctype="multipart/form-data">
	제목: <input type="text" name="title"><br/> 
	파일: <input type="file" name="f"><br/> 
    <input type="submit" value="전송" /> 
</form>

<hr>
<h3>커맨드 객체 사용</h3>
<form action="commandObject" method="POST" enctype="multipart/form-data">
	제목: <input type="text" name="title"><br/> 
	파일: <input type="file" name="f"><br/> 
    <input type="submit" value="전송" /> 
</form>

</body>
</html>