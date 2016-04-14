<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
		<div data-role="header" data-theme="b" data-position="fixed">
			<h1>服务内容</h1>
			 <a data-transition="none" href='<c:url value="/merchant/page/factoring-introduce"/>' data-icon='arrow-l' class="previous ui-btn ui-btn-right ui-corner-all">返回</a>
		</div>
		<div data-role="content" class="help-div">
	      	<h4>商户通过转让POS机上预期产生的账款（营业收入）及其收款权利的方式，获得临时应急资金。服务内容包括：</h4>
	      	<ul data-role="none">
	      		<li>受让账款：受让商户POS机上预期产生的账款和收款权利</li>
	      		<li>支付对价：向商户一次性支付预支对价款，在账款到期日支付剩余对价款</li>
	      		<li>收款管理：登记公示账款转让协议、锁定POS机收款和关联商户结算账户</li>
	      		<li>结清账款：在按每日回收账款的一定金额/比例，归还预支对价款后，将剩余对价款退还给商户</li>
	      	</ul>
		</div>
	</div>
</body>
</html>