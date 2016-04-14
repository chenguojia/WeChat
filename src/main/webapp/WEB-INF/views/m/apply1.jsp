<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>申请融资</h1>
			<a href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form:form action="apply" method="post" modelAttribute="dto">
				<input type="hidden" name="token" value="${token}"/>
				<div data-role="fieldcontain">
					<label for="mid">商户编号：</label> 
					<form:input path="mid" placeholder="例：898420142146762" readonly="true"/>
					<form:errors path="mid" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="subCode">分店号：</label> 
					<form:input path="subCode" placeholder="例：1, 如不清楚可以留空"/>
					<form:errors path="subCode" cssClass="error"/>
				</div>				
				<div data-role="fieldcontain">
					<label for="name">商户名称：</label> 
					<form:input path="merchantName" placeholder="例：阿里郎烤肉店"/>
					<form:errors path="merchantName" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="contactName">联系人名称：</label> 
					<form:input path="contactName" placeholder="例：李晓明"/>
					<form:errors path="contactName" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="contactMobile">联系手机号：</label> 
					<form:input path="contactMobile" placeholder="例：13965437789"/>
					<form:errors path="contactMobile" cssClass="error"/> 
				</div>
				<div data-role="fieldcontain">
				    <fieldset data-role="controlgroup"  >
   						<legend>联系人身份:</legend>
						<form:radiobuttons path="contactPosition" items="${positions}" itemLabel="name" itemValue="value" />
						<form:errors path="contactPosition" cssClass="error"/> 
					</fieldset>							
				</div>
				<div data-role="fieldcontain">
					<label for="memo">备注：</label> 
					<form:textarea path="memo" rows="5" cols="30" />
				</div>												
				<input type="submit" id="submitButton" data-theme="b" value="确认" />
			</form:form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-rel="back" href="#"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
				</ul>
			</div>
		</div>		
	</div>
</body>
</html>