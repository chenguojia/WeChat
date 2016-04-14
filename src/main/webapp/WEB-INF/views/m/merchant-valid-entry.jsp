<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>

<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>请输入短号码</h1>
		</div>
		<div data-role="content">
			<form action="merchantValid" method="post">
				<div data-role="fieldcontain">
					<label for="shortKey">请输入短信中的6位校验码:</label> <input id="shortKey" name="shortKey" type="number" data-inline="true" value="" />
				</div>
				
				
				<input type="hidden" name="openId" value="${openId}"/>
				<div data-role="fieldcontain">
					<input id="submit-button" name="submit" type="submit" value="确认" data-theme="b" />
				</div>
				<div data-role="fieldcontain">
					<p>*输入短信中自带的校验码，确认无误之后将跳转到商户信息页面</p>
				</div>
				<div data-role="fieldcontain">
				<img style="width:100%" src="<c:url value="/resources/image/first-apply.jpg"/>"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
