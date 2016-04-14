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
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form id="submitForm" action="<c:url value="/leads/update"/>" method="post" class="validate">
				<input type="hidden" id="id" name="id" value="${leads.id}" />
				<div data-role="fieldcontain" class="readonly">
					<label for="leadsNumber">线索编号：</label> 
					<label id="leadsNumber">${leads.number}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="status">当前状态：</label> 
					<label id="status">${leads.statusLabel}</label>
					<input type="hidden" name="status" value="${leads.status}"/>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="merchantNumber">商户编号：</label> 
					<label id="merchantNumber">${leads.merchantNumber}</label>
					<input type="hidden" name="merchantNumber" value="${leads.merchantNumber}"/>
				</div>
				<c:if test="${not empty leads.subCode}"> 
				<div data-role="fieldcontain" class="readonly">
					<label for="subCode">分店号：</label> 
					<label id="subCode">${leads.subCode}</label>
				</div>	
				</c:if>
				<div data-role="fieldcontain" >
					<label for="merchantName">商户名称：</label> 
					<input type="text" name="merchantName" id="merchantName" value="${leads.merchantName}" class="required"/>
				</div>
				<div data-role="fieldcontain">
					<label for="merchantIntention">商户意向：</label> 
					<form:select path="leads.merchantIntention">
						<form:options items="${intentions}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>			
				<div data-role="fieldcontain" style="display:none">
					<label for="taskType">业务类型：</label> 
					<form:select path="leads.taskType">
						<form:options items="${taskTypes}" itemLabel="name" itemValue="value"/>
					</form:select>
				</div>
				<div data-role="fieldcontain">
					<label for="merchantContact">联系人姓名：</label> 
					<input type="text" name="merchantContact" id="merchantContact" value="${leads.merchantContact}" class="required"/>
				</div>
				<div data-role="fieldcontain">
				    <fieldset data-role="controlgroup"  >
   						<legend>身份:</legend>
						<form:radiobuttons path="leads.contactPosition" items="${positions}" itemLabel="name" itemValue="value" class="required"/>
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
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-rel="back" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
