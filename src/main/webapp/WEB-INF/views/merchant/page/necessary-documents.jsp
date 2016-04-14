<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
		<div data-role="header" data-theme="b" data-position="fixed">
			<h1>必备资料</h1>
			<a data-transition="none" href='<c:url value="/merchant/page/factoring-introduce"/>' data-icon='arrow-l' class="previous ui-btn ui-btn-right ui-corner-all">返回</a>
		</div>
		<div data-role="content" class="help-div">
			<ul>
				<li>商业保理申请及协议书原件1份</li>
				<li>营业执照复印件1份</li>
				<li>法人身份证正反面复印件1份</li>
				<li>POS机结算账户证明复印件1份</li>
				<li>过去6个月的银行卡结算账单（电子账单下载1份）</li>
				<li>公司租房合同或产权证复印件1份</li>
				<li>借记卡和信用卡复印件各1份</li>
				<li>法人个人信用报告原件1份</li>
				<li>上述资料需加盖公司印章</li>
			</ul>
		</div>	
	</div>
</body>
</html>