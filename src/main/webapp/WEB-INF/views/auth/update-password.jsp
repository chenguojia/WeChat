<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>修改密码</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form action="<c:url value="/auth/updatePassword"/>" method="post" class="validate">
				<div data-role="fieldcontain">
					<label for="password">新密码：</label> 
					<input type="password" name="password" id="password" value="" minlength="6" maxlength="6" class="required"/>
				</div>
				<div data-role="fieldcontain">
					<label for="passwordAgain">确认新密码：</label> 
					<input type="password" name="passwordAgain" id="passwordAgain" minlength="6" maxlength="6" equalTo="#password" value="" />
				</div>
				<input type="submit" data-theme="b" value="确认">
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/sales/account"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
