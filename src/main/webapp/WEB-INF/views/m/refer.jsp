<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://dev.jtsage.com/cdn/datebox/latest/jqm-datebox.min.css" /> 
<script type="text/javascript" src="http://dev.jtsage.com/cdn/datebox/latest/jqm-datebox.core.min.js"></script>
<script type="text/javascript" src="http://dev.jtsage.com/cdn/datebox/latest/jqm-datebox.mode.calbox.min.js"></script>
<script type="text/javascript" src="http://dev.jtsage.com/cdn/datebox/i18n/jquery.mobile.datebox.i18n.zh-CN.utf8.js"></script>
</head>
<body>
	<div data-role="page" id="leadsRefer">
		<div data-role="header" data-position="fixed" data-theme="b" >
			<h1>转介申请</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home" data-ajax="false">主页</a>
		</div>
		<div data-role="content">
			<form:form id="sumitForm" action="refer" method="post" class="validate"  modelAttribute="dto">
				<input type="hidden" name="token" value="${token}"/>
				<div data-role="fieldcontain">
					<label for="mid">商户编号：</label> 
					<form:input path="mid" type="number" class="required" maxlength="15"/>
				</div>
				<div data-role="fieldcontain">
					<label for="merchantName">商户名称：</label> 
					<form:input path="merchantName" type="text" class="required" />
				</div>
				<div data-role="fieldcontain">
					<label for="merchantContact">联系人姓名：</label> 
					<form:input path="contactName" type="text" class="required" />
				</div>
				<div data-role="fieldcontain">
					<label for="contactMobile">手机号码：</label> 
					<form:input path="contactMobile" type="number" class="required" />
				</div>				
				<div data-role="fieldcontain">
				    <fieldset data-role="controlgroup"  >
   						<legend>身份:</legend>
						<form:radiobuttons path="contactPosition" items="${positions}" itemLabel="name" itemValue="value" class="required"/>
					</fieldset>							
				</div>
				<div data-role="fieldcontain">
					<label for="loanAmount">申请额度：</label> 
					<form:input path="loanAmount" placeholder="例：10000" type="number" class="required"/>
					<form:errors path="loanAmount" cssClass="error"/>
				</div>				
				<div data-role="fieldcontain">
					<label for="paybackPeriod">还款时间：</label> 
					<select name="paybackPeriod" id="paybackPeriod" class="required">
						<option value="">--- 请选择 ---</option>
						<option value="1">1个月</option>
						<option value="2">2个月</option>
						<option value="3">3个月</option>
					</select>
					<form:errors path="paybackPeriod" cssClass="error"/>
				</div>				
				<div data-role="fieldcontain">
					<label for="memo">备注：</label> <form:textarea path="memo"/>
				</div>
				<input type="hidden" name="product" value="1"/>
				<input type="submit" id="submitButton" data-theme="b" value="确认" />
			</form:form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-rel="back" href="#" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/m/help"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
