<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %> 
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>我的账户</h1>
			<a data-transition="none" href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
		</div>
		<div data-role="content" class="field">
			<div  class="readonly myaccount">
				<a href="<c:url value='/m/account'/>" class="green">商户信息</a>
				<a href="<c:url value='/m/bankStatementSearch'/>" class="orange"  data-ajax="false">对账查询</a>
				<%--<a href="<c:url value='/m/creditShow'/>" class="blue" data-ajax="false">授信详情</a>--%>
				<a href="<c:url value='/m/showQrCode'/>" class="green">添加商户</a>
				<a href="<c:url value='/m/queryCoupon'/>" class="orange">我的优惠券</a>
				<%-- <a href="<c:url value='/m/creditWait'/>" class="red" data-ajax="false">转圈圈</a> --%>
			</div>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="/m/home"/>'  class="ui-btn-icon-left ui-icon-back"  data-ajax="false">返回</a></li>
					<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
