<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>9장 예제</title>
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script>
		function postXml() {
			var xmlBody = 
				'<?xml version="1.0" encoding="UTF-8" standalone="yes"?>'+
				'<message-list>'+
				'<message><id>1</id><message>메시지</message><creationTime>2014-03-16T13:22:16.767+09:00</creationTime></message><message><id>2</id><message>메시지2</message><creationTime>2014-03-16T13:22:16.767+09:00</creationTime></message>'+
				'</message-list>';
			$.ajax({
				type: "post",
				url: "guestmessage/post.xml",
				contentType: "text/xml",
				data: xmlBody,
				processData: false,
				success: function( response ){
					alert(response);
				},
				error: function(){
					alert( "ERROR", arguments );
				}
			});
		}
	</script>
</head>
<body>
<ul>
<li>HttpMessageConverter:
	<ul>
	<li><a href="mc/simple">/mc/simple</a>: 요청몸체-&gt;String / String-&gt;응답몸체, SimpleConverterController</li>
	<li><a href="guestmessage/list.xml">/guestmessage/list.xml</a>: 자바객체-&gt;XML응답, GuestMessageController.listXml()</li>
	<li><a href="javascript:postXml()">/guestmessage/post.xml</a>: XML요청-&gt;자바객체, GuestMessageController.postXml()</li>
	<li><a href="guestmessage/list.json">/guestmessage/list.json</a>: 자바객체-&gt;JSON응답, GuestMessageController.listJson()</li>
	</ul>
</li>
<li>파일 업로드:
	<ul>
	<li><a href="upload/form">/upload/form</a>: 파일 업로드 폼, UploadController</li>
	<li><a href="upload/form.do">/upload/form.do</a>: 파일 업로드 폼(서블릿3 Part 이용), UploadController2</li>
	</ul>
</li>
</ul>

</body>
</html>
