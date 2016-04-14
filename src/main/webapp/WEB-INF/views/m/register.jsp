<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
<div data-role="page" id="page" id="register-merchant-${uuid}">
		<div data-role="header" data-theme="b">
			<h1>用户注册</h1>
			<a data-transition="none" href="<c:url value="/auth/login"/>" class='ui-btn-right ui-btn-back'  data-icon="back" data-theme="b">登录</a>
		</div>
		<div data-role="content">
			<form:form action="submit" method="post"  class="validate" modelAttribute="dto">
				<div data-role="fieldcontain">
					<label for="name">姓名：</label>
					<form:input path="name" placeholder="例：李晓明" class="required" minlength="2"/>
					<form:errors path="name" cssClass="error"/>
				</div>
				
				<%--<div data-role="fieldcontain">
					<label for="provinceId">省份：</label> 
					<form:select path="provinceId" class="required" >
						<form:option value="" label="--- 请选择 ---"/>
   						<form:options items="${provinces}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="provinceId" class="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="regionId">城市：</label> 
					<form:select path="regionId" class="required" >
						<form:option value="" label="--- 请选择 ---"/>
						<form:options items="${regions}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="regionId" class="error"/>
				</div>	--%>
				
				<div data-role="fieldcontain">
					<label for="mobile">手机：</label> 
					<form:input path="mobile"  placeholder="" maxlength="11" minlength="11"   type="number"  class="required mobile validMobile" />
					<form:errors path="mobile" cssClass="error"/>
				</div>
				
				<%--<div data-role="fieldcontain">
					<label for="email">邮箱：</label> 
					<form:input path="email" placeholder="例：abc@163.com" type="email"/>
					<form:errors path="email" cssClass="error"/>
				</div>	--%>
				
				<div data-role="fieldcontain">
					<label for="password">密码：</label> 
					<form:password path="password"  placeholder="请输入一个6位数密码" minlength="6" maxlength="6" class="required"/>
					<form:errors path="password" cssClass="error"/>
				</div>	
				
				<div data-role="fieldcontain">
					<label for="passwordAgain">确认密码：</label> 
					<form:password path="passwordAgain" minlength="6" maxlength="6" class="required" equalTo="#password"/>
					<form:errors path="passwordAgain" cssClass="error"/>
				</div>

				<div data-role="fieldcontain">
					<label for="referrerMobile">推荐人手机号码：</label>
					<form:input path="referrerMobile" placeholder="" maxlength="11" type="number"  class="mobile validReferrerMobile" />
					<form:errors path="referrerMobile" cssClass="error"/>
				</div>
				<%-- <form:hidden path="linkId" /> --%>

				<input id="submit-button" type="submit" value="注册" data-theme="b" />
														
			</form:form>
		</div>

		<script type="text/javascript">
			//加载城市级联
			refreshRegionByProvince();
		</script>
	</div>
</body>
</html>