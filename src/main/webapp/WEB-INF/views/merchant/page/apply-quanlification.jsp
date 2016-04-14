<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
		<div data-role="header" data-theme="b" data-position="fixed">
			<h1>申请条件</h1>
			<a data-transition="none" href='<c:url value="/merchant/page/factoring-introduce"/>' data-icon='arrow-l' class="previous ui-btn ui-btn-right ui-corner-all">返回</a>
		</div>
		<div data-role="content" class="help-div">
	      	<p>凡经当地工商行政管理部门核准登记、具有法人资格的企业单位或个体工商户，只要安装POS机具在6个月以上、最近月连续有刷卡交易，且无法人信用不良、无诉讼记录和无负面新闻，均可申请办理。</p>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
	  
	  </div>
	</div>
</body>
</html>