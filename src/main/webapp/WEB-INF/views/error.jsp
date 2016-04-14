<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/script/jqModal.js"/>"></script>
</head>
<body>
	<div data-role="page" id="home" style="background-image: -webkit-radial-gradient(#6facd5,#497bae);
background-image: radial-gradient(#6facd5,#497bae);">
		<!-- <div data-role="header" data-position="fixed" data-theme="b">
			<h1>出错啦</h1>
		</div> -->
		<div class="errorpage"><img src="<c:url value="/resources/image/error.png"/>"/></div>
		<div data-role="content" id="error">
			<p>对不起，我们的系统当前遇到了一些问题，请您稍后重试，如重试再次出错，请致电<a href="callto:400-608-1310">400-608-1310</a>寻求技术帮助。非常感谢您的谅解。</p>
		</div>
	</div>
</body>
</html>