<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
<div data-role="page" id="task-detail">
	<div data-role="header" data-position="fixed" data-theme="b">
		<h1>我的商户</h1>
		<a data-transition="none" href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
	</div>
	<div data-role="content" class="field">
		<div data-role="fieldcontain" class="readonly">
			<label>姓名：</label><label>${userInfo.name}</label>
		</div>
		<div data-role="fieldcontain" class="readonly">
			<label>手机号码：</label><label>${userInfo.mobile}</label>
		</div>
		<!-- 如果认证了则显示 -->
		<c:if test="${authStatus == '已认证' }">
			<div data-role="fieldcontain" class="readonly">
				<label>所在省份：</label><label>${userInfo.provinceName}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label>所在城市：</label><label>${userInfo.regionName}</label>
			</div>
		</c:if>
		<div data-role="fieldcontain" class="readonly">
			<label>邮箱：</label><label>${userInfo.email}</label>
		</div>
		<div data-role="fieldcontain" class="readonly">
			<label>认证状态：</label>
			<label>
				<c:if test="${authStatus == '已认证' }"><a href='<c:url value="/m/accountAuthenticationShow?isView=1"/>' data-ajax="false">${authStatus }</a></c:if>
				<c:if test="${authStatus != '已认证' }">${authStatus }</c:if>
			</label>
		</div>

		<!-- 如果认证了则显示 -->
		<c:if test="${authStatus == '已认证' }">
			<div data-role="fieldcontain" class="readonly">
				<label>商户编号：</label><label>${merchant.mid}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label>商户名称：</label><label>${merchant.name}</label>
			</div>
		</c:if>
	</div>
	<div data-role="footer" data-position="fixed" data-theme="c">
		<div data-role="navbar" data-iconpos="left">
			<ul>
				<li><a href='<c:url value="/m/myAccount"/>'  class="ui-btn-icon-left ui-icon-back"  data-ajax="false">返回</a></li>
				<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>
