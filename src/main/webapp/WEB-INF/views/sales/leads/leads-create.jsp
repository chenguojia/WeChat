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
	<div data-role="page" id="leadsCreate">
		<div data-role="header" data-position="fixed" data-theme="b" >
			<h1>提交新线索</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form id="sumitForm" action="<c:url value='/leads/create'/>" method="post" class="validate">
				<input type="hidden" name="token" value="${token}"/>
				<div data-role="fieldcontain">
					<label for="merchantNumber">商户编号：</label> 
					<input type="text" name="merchantNumber" id="merchantNumber" value="${leads.merchantNumber}" maxlength="15" class="required"/>
				</div>
				<div data-role="fieldcontain">
					<label for="subCode">分店号：</label> 
					<input type="text" name="subCode" id="subCode" placeholder="一般为1到9999，如不清楚可以不填" maxlength="4" value="${leads.subCode}" />
				</div>
				<div data-role="fieldcontain">
					<label for="merchantName">商户名称：</label> 
					<input type="text" name="merchantName" id="merchantName" value="${leads.merchantName}" class="required"/>
				</div>
				<div data-role="fieldcontain">
					<label for="merchantIntention">商户意向：</label>
					<form:select path="leads.merchantIntention">
						<form:options items="${intentions}" itemLabel="name" itemValue="value"/>
					</form:select>					
				</div>
				<div data-role="fieldcontain" id="estimate-feedback-days-div">
					<label for="feedbackDate">商户计划答复日：</label>
					<input type="date" id="feedbackDate" name="feedbackDate" value="${leads.feedbackDate}" data-role="datebox" data-options='{"mode": "calbox", "useNewStyle":true}'/>					
				</div>				
				<div data-role="fieldcontain" style="display:none">
					<label for="taskType">业务类型：</label> 
					<form:select path="leads.taskType">
						<form:options items="${taskTypes}" itemLabel="name" itemValue="value"/>
					</form:select>							
				</div>
				<div data-role="fieldcontain">
					<label for="merchantContact">联系人姓名：</label> 
					<input type="text" name="merchantContact" id="merchantContact" class="required"/>
				</div>
				<div data-role="fieldcontain">
				    <fieldset data-role="controlgroup"  >
   						<legend>身份:</legend>
						<form:radiobuttons path="leads.contactPosition" items="${positions}" itemLabel="name" itemValue="value" class="required"/>
					</fieldset>							
				</div>
				<div data-role="fieldcontain">
					<label for="contactMobile">手机号码：</label> 
					<input type="text" name="contactMobile" id="contactMobile" class="required mobile"/>
				</div>
				<div data-role="fieldcontain">
					<label for="memo">备注：</label> <input type="text" name="memo" id="memo" />
				</div>
				<div data-role="fieldcontain">
					<label for="contactMobile">推荐商户手机号码：</label>
					<input type="text" name="referrerCellPhone" id="referrerCellPhone" class="mobile validReferrerMobileWithCrm"/>
					<font color="red">(注：如果此线索为商户转介绍推荐则填写转介商户手机号码，否则不用填写)</font>
				</div>
				<%-- 产品类型 ：关联POS--%>
				<input type="hidden" name="product" value="1"/>
				<input type="button" id="submitButton" data-theme="b" value="确认" />
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="${backUrl}"/>'  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<div class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" style="max-width:400px;" data-theme="a" data-overlay-theme="a" id="popupDialog" data-role="popup">
			<div class="ui-corner-top ui-header ui-bar-a" data-theme="a" data-role="header" data-role="banner">
				<h1 class="ui-title" data-role="heading" >重复线索</h1>
			</div>
			<div class="ui-corner-bottom ui-content" data-role="main">
				<p>您提交的线索商户一个月内已被上报，不能重复提交。</p>
				<a data-theme="a" data-rel="back" data-role="button" href="#" >取&nbsp;&nbsp;消</a>
			</div>
		</div>
		<script type="text/javascript">
			$('#leadsCreate').on('pageinit', function(){
				$('#submitButton').click(function(){
					var m = $('#merchantNumber').val();
					$.getJSON('<c:url value="/leads/isRepeated"/>',{mid : m}, function(flag){
						if(!flag){
							$('#sumitForm').submit();
						}else{
							$('#popupDialog').popup('open');
						}
					});
				});
			});
		</script>		
	</div>
</body>
</html>
