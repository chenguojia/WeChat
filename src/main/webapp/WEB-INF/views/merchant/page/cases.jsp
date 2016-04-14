<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
		<div data-role="header" data-theme="b">
			<h1>案例分享</h1>
		</div>
		<div data-role="content">
	      	<ul data-role="listview" data-inset="true">
	        	<li><a data-transition="none" data-tra href="<c:url value='/merchant/page/case-1'/>" >旺季囤货</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-2'/>" >店面装修</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-3'/>" >开立新店</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-4'/>" >缴纳房租</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-5'/>" >发放工资</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-6'/>" >集中付款</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-7'/>" >偿还债务</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-8'/>" >股权收购</a></li>
				<li><a data-transition="none" href="<c:url value='/merchant/page/case-9'/>" >家庭急用</a></li>
	      	</ul>    		
		</div>
	</div>
</body>
</html>