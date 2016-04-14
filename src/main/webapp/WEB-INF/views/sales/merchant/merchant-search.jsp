<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>
</head>
<body>
	<div data-role="page" id="merchant-search">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>查询商户额度信息</h1>
			 <a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form id="searchForm" action="<c:url value='/merchant/search'/>" method="post" class="validate">
				<div data-role="fieldcontain">
					<label for="number">商户编号：</label> 
					<input type="number" name="number" id="number" placeholder="请输入正确的商户编号" value="${number}" class="required mid"/>
				</div>
				<input  type="submit" data-theme="b" value="搜索"/>
			</form>
			<br>
			<p><a data-transition="none" data-role="button" data-theme="c" href="<c:url value='/merchant/calculator'/>">没有商编? 直接计算</a></p>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>" 
						data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>	
</body>
</html>
