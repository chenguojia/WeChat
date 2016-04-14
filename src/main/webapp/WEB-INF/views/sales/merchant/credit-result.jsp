<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="credit-result">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>商户额度计算结果</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form id="calcform" method="post">
				<div data-role="fieldcontain" class="readonly">
					<label for="creditRating">授信等级：</label><label id="creditRating">${creditInfo.creditRatingLabel}</label> 
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="creditLineIn90Days">授信额度(三个月)：</label> <label id="creditLineIn90Days">${creditInfo.creditLineIn90DaysLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="feeRate">手续费率：</label> <label id="feeRate">${creditInfo.feeRateLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="paymentWay">还款方式：</label> <label id="paymentWay">${creditInfo.paymentWay}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="maxPaymentPeriod">最长还款期(月)：</label> <label id="maxPaymentPeriod">${creditInfo.maxPaymentPeriod}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="fee">手续费(元)：</label> <label id="fee">${creditInfo.feeLabel}</label>
				</div>									
				<div data-role="fieldcontain" class="readonly">
					<label for="fixedPaymentAmont">日还款额(元)：</label> <label id="fixedPaymentAmont">${creditInfo.fixedPaymentAmontLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
				<a data-transition="none" href="<c:url value='/leads/showSubmit'/>" data-role="button" data-theme="b" >提交新线索</a>
			</div>
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href='<c:url value="/merchant/calculator"/>' class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
