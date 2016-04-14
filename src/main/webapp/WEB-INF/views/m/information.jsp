<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>

<body>
<div data-role="page" id="task-detail">
<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>信息填写</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
<div data-role="content">
<div data-role="fieldcontain">
<label for="shortnumber">请输入短信中的4位短号码:</label>
<input id="shortnumber" type="text" value="" />
</div>
<div data-role="fieldcontain">
<a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-b">确认</a>
</div>
<div data-role="fieldcontain">
<p>*输入短信中自带的短号码，确认之后将跳转到个人资料页面，请核实您的资料，如果没有错误或遗漏，请点击注册</p>
</div>
</div>
<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href='#' data-rel="back" class="ui-btn-icon-left ui-icon-back">上一页</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
</div>
</div>
</body>
</html>
