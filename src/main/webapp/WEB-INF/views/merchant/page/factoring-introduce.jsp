<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
		<div data-role="header" data-theme="b">
			<h1>商业保理</h1>
		</div>
		<div data-role="content">
	      	<ul data-role="listview" data-inset="true">
	        	<li><a data-transition="none" href="<c:url value='/merchant/page/provide-service'/>" >服务内容</a></li>
	        	<li><a data-transition="none" href="<c:url value='/merchant/page/business-feature'/>" >产品特色</a></li>
	        	<li><a data-transition="none" href="<c:url value='/merchant/page/apply-quanlification'/>" >申请条件</a></li>
	        	<li><a data-transition="none" href="<c:url value='/merchant/page/necessary-documents'/>" >必备资料</a></li>
	      	</ul>    		
		</div>
	</div>
</body>
</html>