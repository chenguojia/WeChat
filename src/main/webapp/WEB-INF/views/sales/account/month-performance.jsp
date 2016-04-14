<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="month-performance">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>提成统计</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<div data-role="fieldcontain" class="readonly">
				<label for="name">上月提成：</label> <input type="text" name="name" id="name" value="${lastMonthPerformance}" readonly />
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="bankCardNumber">本月提成：</label> <input type="text" name="bankCardNumber" id="bankCardNumber" value="${currentMonthPerformance}" readonly />
			</div>
			<span style="color: red;">*以上为税前劳务报酬，实发数已按税法代扣代缴</span>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>