<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="credit-result">
		<div data-role="header" data-theme="b">
			<h1>授信额度计算结果</h1>
		</div>
		<div data-role="content">
			<form id="calcform" method="post">
				<div data-role="fieldcontain" class="readonly">
					<label for="creditRating">授信等级：</label> <label id="creditRating">${creditInfo.creditRatingLabel}</label>
				</div>			
				<div data-role="fieldcontain" class="readonly">
					<label for="creditLineIn90Days">授信额度(三个月)：</label> <label id="creditLineIn90Days">${creditInfo.creditLineIn90DaysLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="feeRate">手续费率：</label> <label id="feeRate">${creditInfo.feeRateLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="paymentWay">还款方式：</label><label id="paymentWay">${creditInfo.paymentWay}</label> 
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="maxPaymentPeriod">最长还款期（月）：</label> <label id="maxPaymentPeriod">${creditInfo.maxPaymentPeriod}</label>
				</div>		
				<div data-role="fieldcontain" class="readonly">
					<label for="fee">手续费(元)：</label> <label id="fee">${creditInfo.feeLabel}</label>
				</div>					
				<div data-role="fieldcontain" class="readonly">
					<label for="fixedPaymentAmont">日还款额(元)：</label> <label id="fixedPaymentAmont">${creditInfo.fixedPaymentAmontLabel}</label>
				</div>
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="/merchant/calculator?type=merchant"/>' class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a>&nbsp;</a></li>
				</ul>
			</div>
		</div>		
	</div>
</body>
</html>
