<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="contact">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>联系我们</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content" class="help-div">
			如果您有任何问题，请拨打客户经理服务专线<br>
			<p>021-60200916</p>
			<p>021-60200917</p>
			或发送邮件到官方邮箱：<br> 
			<p>factoring@cardvalue.cn</p>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
