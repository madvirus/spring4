<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>18장 예제</title>
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script>
		function postJson() {
			var jsonBody = 
				'{"name": "최범균"}';
			$.ajax({
				type: "post",
				url: "hello.json",
				contentType: "application/json",
				data: jsonBody,
				processData: false,
				success: function( response ){
					alert(JSON.stringify(response));
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
<li>
	<ul>
	<li><a href="hello?name=bkchoi">/hello?name=bkchoi</a>: HelloController.greeting()</li>
	<li><a href="javascript:postJson()">/hello.json</a>: HelloController.greetingJson()</li>
	</ul>
</li>
</ul>

</body>
</html>
