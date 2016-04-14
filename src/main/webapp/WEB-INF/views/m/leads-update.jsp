<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="leadsUpdate">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>修改线索</h1>
			<a href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form id="submitForm" action="<c:url value="/m/updateApply"/>" method="post" class="validate">
				<input type="hidden" id="id" name="id" value="${leads.id}" />
				<div data-role="fieldcontain" class="readonly">
					<label for="leadsNumber">线索编号：</label> 
					<input type="text" name="leadsNumber" id="leadsNumber" value="${leads.number}" readonly />
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="status">当前状态：</label> 
					<input type="text" name="status" id="status" value="${leads.statusLabel}" readonly />
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="merchantNumber">商户编号：</label> 
					<input type="text" name="merchantNumber" id="merchantNumber" value="${leads.merchantNumber}" readonly />
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="subCode">分店号：</label> 
					<input type="text" name="subCode" id="subCode"  value="${leads.subCode}" readonly />
				</div>				
				<div data-role="fieldcontain" >
					<label for="merchantName">商户名称：</label> 
					<input type="text" name="merchantName" id="merchantName" value="${leads.merchantName}" class="required"/>
				</div>
				<div data-role="fieldcontain">
					<label for="merchantContact">联系人：</label> 
					<input type="text" name="merchantContact" id="merchantContact" value="${leads.merchantContact}" class="required"/>
				</div>
				<div data-role="fieldcontain" >
			    	<fieldset data-role="controlgroup"  >
   						<legend>身份:</legend>
						<form:radiobuttons path="leads.contactPosition" items="${positions}" itemLabel="name" itemValue="value"/>
					</fieldset>	
				</div>				
				<div data-role="fieldcontain">
					<label for="contactNumber">联系电话：</label> 
					<input type="text" name="contactMobile" id="contactMobile" value="${leads.contactMobile}" class="required"/>
				</div>
				<div data-role="fieldcontain">
					<label for="memo">备注：</label>
					<textarea name="memo" id="memo" >${leads.memo}</textarea>
				</div>
				<input id="submitButton" type="submit" data-theme="b" value="确认" />
			</form>
		</div>
	</div>
</body>
</html>
