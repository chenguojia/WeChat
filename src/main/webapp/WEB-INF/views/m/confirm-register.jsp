<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home">
		<div data-role="header" data-theme="b">
			<h1>欢迎您</h1>
		</div>
		<div data-role="content" class="help-div">
			<p>商户首次使用出现，这里是商户告知部分。</p>
			<p>如果希望绑定为商户用户，请点击以下按钮。</p>
			<a href="<c:url value='/m/register'/>" data-role="button" data-icon="arrow-r" data-theme="b">绑定为商户</a>
		</div>
	</div>
</body>
</html>