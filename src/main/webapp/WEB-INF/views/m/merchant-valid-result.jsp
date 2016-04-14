<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="merchant-valid">
		<div data-role="header" data-theme="b">
			<h1>请查看您的商户信息</h1>
		</div>
		<div data-role="content">
			<div data-role="fieldcontain">
				<label for="mid">商户编号：</label> 
				<label>${link.mid}</label>
			</div>
			<div data-role="fieldcontain">
				<label for="merchantName">商户名称：</label> 
				<label>${merchantName}</label>
			</div>
			<div data-role="fieldcontain">
				<label for="contactName">联系人：</label> 
				<label>${link.contactName}</label>
			</div>
			<div data-role="fieldcontain">
				<label for="contactMobile">联系手机：</label> 
				<label>${link.contactMobile}</label>
			</div>
			<div data-role="fieldcontain">
				<label for="salesName">客户经理：</label> 
				<label>${sales.name}</label>
			</div>
			<div data-role="fieldcontain">
				<img style="width:100%"  src="<c:url value="/resources/image/first-apply.jpg"/>"/>
			</div>
		</div>
	</div>
</body>
</html>