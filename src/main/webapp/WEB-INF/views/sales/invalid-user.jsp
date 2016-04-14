<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/script/jqModal.js"/>"></script>
</head>
<body>
	<div data-role="page" id="invalid-user">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>温馨提示</h1>
		</div>
		<div data-role="content">
			<p>很抱歉，您当前的微信用户已经绑定到商户身份。</p>
			<p>您可以返回到微信界面，在菜单中使用商户的相应功能。</p>
		</div>
	</div>
</body>
</html>