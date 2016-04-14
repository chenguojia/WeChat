<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="register-merchant-${uuid}">
		<div data-role="header" data-theme="b">
			<h1>注册商户</h1>
		</div>
		<div data-role="content">
			<form:form action="submit" method="post" modelAttribute="dto">
				<div data-role="fieldcontain">
					<label for="mid">商户编号：</label> 
					<form:input path="mid" placeholder="例：898420142146762" type="number"/>
					<form:errors path="mid" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="merchantName">商户名称：</label> 
					<form:input path="merchantName" placeholder="例：上海市普陀区静安面包房长寿路店"/>
					<form:errors path="merchantName" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="contactName">联系人名称：</label> 
					<form:input path="contactName" placeholder="例：李晓明"/>
					<form:errors path="contactName" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="contactMobile">联系手机：</label> 
					<form:input path="contactMobile" placeholder="例：13966778899" type="number"/>
					<form:errors path="contactMobile" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
				    <fieldset data-role="controlgroup"  >
   						<legend>身份:</legend>
						<form:radiobuttons path="contactPosition" items="${positions}" itemLabel="name" itemValue="value"/>
						<form:errors path="contactPosition" cssClass="error"/>
					</fieldset>							
				</div>				
				<div data-role="fieldcontain">
					<label for="provinceId">经营省区：</label> 
					<form:select path="provinceId" >
   						<form:options items="${provinces}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="provinceId" class="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="regionId">经营地市：</label> 
					<form:select path="regionId" >
						<form:options items="${regions}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="regionId" class="error"/>
				</div>				
				<form:hidden path="openId" />
				<form:hidden path="linkId" />
				<input id="submit-button" name="submit" type="submit" value="注册" data-theme="b" />												
			</form:form>
		</div>
		<script type="text/javascript">
			$("#register-merchant-${uuid}").on("pageinit",function(){
				refreshRegionByProvince();
				$("#register-merchant-${uuid} #mid").change(function(){
					var mid = $("#register-merchant-${uuid} #mid").val();
					if(mid.length == 15){
						$.getJSON('<c:url value="/merchant/findMerchantName"/>', {mid:mid}, function(data){
							$("#register-merchant-${uuid} #merchantName").val(data['merchantName']);
						});
					}
				});
			});
		</script>
	</div>
</body>
</html>