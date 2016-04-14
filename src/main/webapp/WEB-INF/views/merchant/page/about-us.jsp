<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
		<div data-role="header" data-theme="b">
			<h1>关于我们</h1>
		</div>
		<div data-role="content">
	      	<ul data-role="listview" data-inset="true">
	        	<li><a data-transition="none" href="<c:url value='/merchant/page/company-introduction'/>" >卡得万利</a></li>
	        	<li><a data-transition="none" href="<c:url value='/merchant/page/company-qualification'/>" >牌照资质</a></li>
	        	<li><a data-transition="none" href="<c:url value='/merchant/page/contact'/>" >联系方式</a></li>
	      	</ul>    		
		</div>
	</div>
</body>
</html>