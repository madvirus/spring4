<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<ul>
<li>메시지 출력:
	<ul>
	<li><a href="auth/login">/auth/login</a>: &lt;spring:message&gt; 태그, loginForm.jsp, LoginController</li>
	</ul>
</li>
<li>폼 및 에러 메시지:
	<ul>
	<li><a href="member/regist">/member/regist</a>: 폼, 에러 메시지, registrationForm.jsp, RegistrationController</li>
	</ul>
</li>
<li>커스텀 뷰:
	<ul>
	<li><a href="file/1">/file/1</a>: 파일 다운로드, DownloadView, DownloadController.download()</li>
	<li><a href="pagestat/rank">/pagestat/rank</a>: 엑셀 다운로드, PageRankView, PageRankStatController.pageRank()</li>
	<li><a href="pagestat/rankreport">/pagestat/rankreport</a>: PDF 다운로드, PageReportView, PageRankStatController.pageRankReport()</li>
	</ul>
</li>
<li>로케일 변경:
	<ul>
	<li><a href="changeLanguage?lang=en">/changeLanguage?lang=en</a>: LocaleResolver 예, LocaleChangeController.change(), lang 파라미터로 변경</li>
	<li><a href="auth/login?lang=en">/auth/login?lang=en</a>: LocaleChangeInterceptor 예, lang으로 변경 후, lang 없이 확인</li>
	</ul>
</li>
</ul>

</body>
</html>
