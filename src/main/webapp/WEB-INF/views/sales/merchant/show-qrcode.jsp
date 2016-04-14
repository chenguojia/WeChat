<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="show-qrcode">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>我的商户</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<p><img alt="二维码" src="${url}" class="eighty-percent-width"/></p>
			<p>*商户可以通过微信中的扫一扫功能扫描您的二维码关注卡得万利服务号</p>
			<p>*若您未收到链接，请让商户取消卡得万利服务号关注后再次扫描您的二维码</p>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" data-rel="back" href="#" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
