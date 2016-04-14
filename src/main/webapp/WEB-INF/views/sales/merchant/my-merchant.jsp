<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="mymerchant" style="background-image: -webkit-radial-gradient(#fff, #376d9b); background-image: radial-gradient(#fff, #376d9b);">
		<div class="ui-title">我的商户</div>
		<div data-role="content">
			<ul data-role="none" class="Homepage">
				<li class="new" style="background-color: #cf4020"><a data-transition="none" href="<c:url value="/sales/keyMerchantList"/>"><img src="<c:url value="/resources/image/recommend.png"/>" alt="recommend" /><span>白名单商户<sup>热</sup></span></a></li>
				<li class="new" style="background-color: #ED636e"><a data-ajax="false" data-transition="none" href="<c:url value="/sales/aroundMerchants"/>"><img src="<c:url value="/resources/image/position.png"/>" alt="position" /><span>周边商户</span></a></li>
				<li style="background-color: #2f88f0"><a data-transition="none" href="<c:url value='/sales/showQrCode'/>"><img src="<c:url value="/resources/image/myshop.png"/>" alt="myshop" /><span>添加商户</span></a></li>
				<li style="background-color: #10798f"><a data-transition="none" href="<c:url value="/sales/merchantList"/>"><img src="<c:url value='/resources/image/list.png'/>" alt="list" /><span>商户列表</span></a></li>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value='/'/>" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value='/help/list'/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
