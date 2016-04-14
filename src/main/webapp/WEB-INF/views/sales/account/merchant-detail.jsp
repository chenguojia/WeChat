<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="merchant-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>查看商户</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back' data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<div data-role="fieldcontain" class="readonly">
				<label for="merchantNumber">商户编号: </label><label id="mid">${m.mid}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="merchantName">商户名称: </label><label id="merchantName">${m.name}</label >
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="contactName">联系人姓名: </label><label id="contactName">${m.contactName}</label> <!--  <input type="text" name="contactName" id="contactName" value="${m.contactName}" readonly />-->
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="identity">身份：</label> <label id="identity">${m.contactPositionLabel}</label> 
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="contactNumber">联系电话：</label><label id="contactNumber">${m.contactMobile}</label> 
			</div>
			<div data-role="fieldcontain" class="readonly">
				<a href="<c:url value="/leads/showSubmitWithMerchant?mid=${m.mid}"/>" class="ui-btn ui-btn-b ui-corner-all">立即申请</a>
			</div>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-rel="back" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
