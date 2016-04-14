<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<style type="text/css">
#header {
	border: 1px solid #456f9a;
	background: #5e87b0;
	font-weight: 700;
	text-shadow: 0 1px 0 #3e6790;
	background-image: -webkit-linear-gradient(#5f9cc5, #396b9e);
	background-image: linear-gradient(#6facd5, #497bae);
}

.ui-icon-home {
	border: 1px solid #ddd;
	background: #396b9e;
	background-image: linear-gradient(#5f9cc5, #396b9e);
}

.field .readonly {
	border-bottom: 1px solid rgba(0, 0, 0, .15);
}

.readonly {
	padding-bottom: 5px;
}
</style>
</head>

<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>我的优惠券</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back' data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<div data-role="fieldcontain">
				<label>可用优惠券:</label>
				<div id="one" class="ui-body-d  mycoupon">
					<c:forEach items="${availableCoupons}" var="uc">
						<p>
							<img src="<c:url value="/resources/image/coupons/my_${uc.couponName}_enabled.png"/>" />
							 <label id="code">${uc.couponNumber}</label>
							 <label id="date"><fmt:formatDate type="date" value="${uc.createDate}"/></label>
						</p>
					</c:forEach>
				</div>
			</div>

			<div data-role="fieldcontain">
				<label>已用优惠券:</label>			
				<div id="two" class="mycoupon">
					<c:forEach items="${usedCoupons}" var="uc">
						<p>
							<img src="<c:url value="/resources/image/coupons/my_${uc.couponName}_disabled.png"/>" /> 
							<label id="code">${uc.couponNumber}</label>
							<label id="date"><fmt:formatDate type="date" value="${uc.usedDate}"/></label>
						</p>
					</c:forEach>
				</div>
			</div>	
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/sales/pointAndLevel"/>" data-icon="arrow-l">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
