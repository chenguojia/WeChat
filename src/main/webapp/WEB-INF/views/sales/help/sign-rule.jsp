<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
</head>
<body>
	<div data-role="page" id="sign-rule">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>签约规范</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<img alt="签约规范样例1" src="<c:url value='/resources/image/sign-rule-a_a.png'/>" class="full-width"/> 
			<img alt="签约规范样例2" src="<c:url value='/resources/image/sign-rule-a_b.png'/>" class="full-width"/>
			<img alt="签约规范样例1" src="<c:url value='/resources/image/sign-rule-b_a.png'/>" class="full-width"/> 
			<img alt="签约规范样例2" src="<c:url value='/resources/image/sign-rule-b_b.png'/>" class="full-width"/>
			<img alt="签约规范样例3" src="<c:url value='/resources/image/sign-rule-c.jpg'/>" class="full-width"/>
			<img alt="签约规范样例4" src="<c:url value='/resources/image/sign-rule-d.jpg'/>" class="full-width"/>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/help/signHelp"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>