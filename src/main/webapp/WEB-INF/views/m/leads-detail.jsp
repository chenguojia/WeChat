<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="leads-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>查看线索</h1>
			<a href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form>
				<div data-role="fieldcontain"  class="readonly">
					<label for="leadsNumber">线索编号：</label> 
					<label id="leadsNumber">${leads.number}</label>
				</div>
				<div data-role="fieldcontain"  class="readonly">
					<label for="status">当前状态：</label> 
					<label id="status" >${leads.statusLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="statusChangeTime">最近状态更新时间：</label>
					<label id="statusChangeTime">${leads.statusChangeTime}</label>
				</div>								
				<div data-role="fieldcontain"  class="readonly">
					<label for="merchantNumber">商户编号：</label> 
					<label id="merchantNumber">${leads.merchantNumber}</label>
				</div>
				<div data-role="fieldcontain"  class="readonly">
					<label for="merchantName">商户名称：</label> 
					<label id="merchantName">${leads.merchantName}</label>
					<!--  <input type="text" name="merchantName" id="merchantName" value="${leads.merchantName}" readonly />-->
				</div>
				<div data-role="fieldcontain"  class="readonly">
					<label for="contactName">联系人：</label> 
					<label id="contactName">${leads.merchantContact}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="identity">身份：</label> 
					<label id="identity">${leads.contactPositionLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="mobileNumber">手机号码：</label> 
					<label id="mobileNumber">${leads.contactMobile}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="leadsMemo">线索备注：</label>
					<textarea name="leadsMemo" id="leadsMemo" readonly>${leads.memo}</textarea>
				</div>
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="/m/applyStatus"/>' class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
