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
		<h1>${isView != '1' ? '会员认证&授信' : '会员认证信息' }</h1>
		<a data-transition="none" href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
	</div>
	<div data-role="content">
		<form:form action="accountAuthentication" method="post"  class="validate" modelAttribute="dto" data-ajax="false" id="submitForm">
			<div data-role="fieldcontain"  class="${!empty merchant && !empty merchant.name ? 'readonly' : ''}">
				<label for="merchantName">店铺名称：</label>
				<form:input path="merchantName" placeholder="例：上海市普陀区静安面包房长寿路店" class="required" readonly="${!empty merchant && !empty merchant.name}" value="${merchant.name}"  />
				<form:errors path="merchantName" cssClass="error"/>
			</div>

			<div data-role="fieldcontain"  class="${!empty merchant && !empty merchant.mid ? 'readonly' : ''}">
				<label for="mid">POS机商编：</label>
				<form:input path="mid" placeholder="多个商编请用英文逗号分开" class="required" minlength="15" readonly="${!empty merchant && !empty merchant.mid}"  value="${merchant.mid}${!empty merchant && !empty merchant.otherMid ? ',' : ''}${merchant.otherMid }" />
				<form:errors path="mid" cssClass="error"/>
			</div>

			<div data-role="fieldcontain"  class="${!empty merchant && !empty merchant.address ? 'readonly' : ''}">
				<label for="address">店铺地址：</label>
				<form:input path="address" placeholder="例：上海市浦东新区被张家浜路88号" class="required" readonly="${!empty merchant && !empty merchant.address}"  value="${merchant.address}" />
				<form:errors path="address" cssClass="error"/>
			</div>

			<div data-role="fieldcontain"  class="${!empty merchant && !empty merchant.contactName ? 'readonly' : ''}">
				<label for="contactName">法人姓名：</label>
				<form:input path="contactName" placeholder="例：李晓明" class="required"  minlength="2"  value="${!empty merchant ? merchant.contactName : userInfo.name} "  readonly="${!empty merchant && !empty merchant.contactName }" />
				<form:errors path="contactName" cssClass="error"/>
			</div>

			<c:if test="${empty merchant }">
				<div data-role="fieldcontain">
					<label for="provinceId">法人所在省份：</label>
					<form:select path="provinceId" class="required" >
						<form:option value="" label="--- 请选择 ---"/>
						<form:options items="${provinces}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="provinceId" class="error"/>
				</div>

				<div data-role="fieldcontain">
					<label for="regionId">法人所在城市：</label>
					<form:select path="regionId" class="required" >
						<form:option value="" label="--- 请选择 ---"/>
						<form:options items="${regions}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="regionId" class="error"/>
				</div>
			</c:if>

			<div data-role="fieldcontain"  class="${!empty merchant ? 'readonly' : ''}">
				<label for="contactMobile">法人电话：</label>

				<c:if test="${empty merchant }">
					<div class="ui-grid-a">
						<div class="ui-block-a">
							<form:input path="contactMobile" placeholder="例：13966778899"  maxlength="11" minlength="11" type="number"  class="required mobile"   value="${!empty merchant ? merchant.contactMobile : userInfo.mobile}"  readonly="${!empty merchant}"  />
						</div>
						<div class="ui-block-b">
							<input type="button" id="checkCodeBtn" data-mini="true" data-theme="b" value="获取验证码">
						</div>
					</div>
				</c:if>

				<c:if test="${!empty merchant }">
					<form:input path="contactMobile" placeholder="例：13966778899"  maxlength="11" minlength="11" class="required mobile"   value="${!empty merchant ? merchant.contactMobile : userInfo.mobile}"  readonly="${!empty merchant}"  />
				</c:if>

				<form:errors path="contactMobile" cssClass="error"/>
			</div>

			<c:if test="${empty merchant }">
				<div data-role="fieldcontain">
					<label for="checkCode">验证码：</label>
					<form:input path="checkCode" class="required" minlength="4" maxlength="4"/>
					<form:errors path="checkCode" cssClass="error"/>
				</div>
			</c:if>

			<c:if test="${empty merchant }">
				<div data-role="fieldcontain">
					<label for="email">邮箱：</label>
					<form:input path="email" placeholder="例：abc@163.com" type="email"/>
					<form:errors path="email" cssClass="error"/>
				</div>
			</c:if>

			<div data-role="fieldcontain"  class="${!empty merchant ? 'readonly' : ''}">
				<fieldset data-role="controlgroup"  >
					<legend>身份:</legend>
					<form:radiobuttons path="contactPosition" class="required" items="${positions}" itemLabel="name" itemValue="value" disabled="${!empty merchant}"  />
					<form:errors path="contactPosition" cssClass="error"/>
				</fieldset>
			</div>
			<div data-role="fieldcontain"  class="${!empty merchant && dto.processorId != '330'  ? 'readonly' : ''}">
				<fieldset data-role="controlgroup"  >
					<legend>收单机构:</legend>
					<form:radiobuttons path="processorId" class="required" items="${processorIds}" itemLabel="name" itemValue="value" disabled="${!empty merchant && dto.processorId != '330'  ? 'true' : 'false'}"  />
					<form:errors path="processorId" cssClass="error"/>
				</fieldset>
				<!-- 不是认证查看页面时，则显示提示信息 -->
				<c:if test="${isView != '1' }">
					<font color="red">收单机构为您的POS机申请机构，如果没有您对应的收单机构请选择卡得万利！</font>
				</c:if>
			</div>

			<!-- 不是认证查看页面时，则显示 -->
			<c:if test="${isView != '1' }">
				<div data-role="fieldcontain">
					<label for="loanAmount">预计申请额度：</label>
					<form:input path="loanAmount" placeholder="例：10000" type="number" class="required"/>
					<form:errors path="loanAmount" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="paybackPeriod">预计还款时间：</label>
					<select name="paybackPeriod" id="paybackPeriod" class="required">
						<option value="">--- 请选择 ---</option>
						<%--<option value="1">1个月</option>--%>
						<option value="2">2个月</option>
						<option value="3">3个月</option>
					</select>
					<form:errors path="paybackPeriod" cssClass="error"/>
				</div>

				<!-- 第一次认证时，出现同意条款 -->
				<c:if test="${empty merchant }">
					<div data-role="fieldcontain" class="agree">
						<input id="agreeClause" name="authorization " type="checkbox" checked="checked">
						<label for="agreeClause">同意授权卡得万利使用注册商户的交易流水数据</label>
						<label><a id="showClause" href="###">查看条款</a></label>
					</div>
				</c:if>

				<input id="submit-button" name=submit-button type="submit" value="提交" data-theme="b" />
			</c:if>

			<!-- 如果是查看页面 ，并且是网站同步过来的用户认证信息，第一次进入修改则显示提交按钮 -->
			<c:if test="${isView == '1' }">
				<c:if test="${!empty merchant && empty merchant.mid}">
					<input id="submit-button" name=submit-button type="button" value="提交" data-theme="b " />
				</c:if>
			</c:if>

		</form:form>
	</div>
	<div data-role="footer" data-position="fixed" data-theme="c">
		<div data-role="navbar" data-iconpos="left">
			<ul>
				<li><a href='<c:url value="${isView != '1' ? '/m/home' : '/m/account' }"/>'  class="ui-btn-icon-left ui-icon-back" data-ajax="false">返回</a></li>
				<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
			</ul>
		</div>
	</div>

	<!-- 条款查看 -->
	<div class="overlay"></div>
	<div class="agreement" style="top: 35%; left:2%;">
		<div data-role="fieldcontain" class="agreementcontainer">
			<h3>卡得万利商户授权协议</h3>
			<p>尊敬的用户，欢迎您首次登录卡得万利商业保理官方微信服务号商户中心。</p>
			<p>卡得万利商业保理（上海）有限公司（以下简称卡得万利）是国家商业保理试点企业和政府中小企业服务机构，致力于激活百万商户的亿万账款资源，推动金融创新，最终实现小微商户融资无门槛。</p>
			<p>为了及时、有效地为您提供融资服务，贵方授权允许我们调取您POS机历史交易流水记录用于保理业务的预授信额度的核定，同时卡得万利有责任对您的交易记录进行保密处理。</p>
			<p>免责声明：如发生在进入、浏览和使用本微信服务号或从本微信服务号下载任何内容而导致病毒或其他破坏性程序对您的电脑系统以及其他任何软件、硬件、IT系统或财产的损害或损失，我方将不承担任何责任。</p>
		</div>
		<div data-role="fieldcontain" class="closeagreement">
			<input id="closeBtn" name="submit" type="submit" value="关闭"/>
		</div>
	</div>


	<script type="text/javascript">
		//显示条款div
		$("#showClause").click(function(){
			$(".overlay").toggle();
			$(".agreement").toggle();
		});
		//关闭遮罩层
		$("#closeBtn").click(function(){
			$(".agreement").toggle();
			$(".overlay").toggle();
		});

		//提交
		$("#submit-button").click(function(){
			if($("#submitForm").valid()) {
				//提交后禁用按钮,防止重复提交
				$("#submit-button").button('disable');
				$("#submit-button").button('refresh');
				$("#submitForm").submit();
			}
		});

		$("#agreeClause").click(function(){
			if($("input[type='checkbox'][id='agreeClause']").is(':checked')){
				$("#submit-button").button('enable');
				$("#submit-button").button('refresh');
			}else{
				$("#submit-button").button('disable');
				$("#submit-button").button('refresh');
			}

		});

		//启用短信验证功能
		enableMobileMessageCheck("#contactMobile","#checkCodeBtn");

		//加载城市级联
		refreshRegionByProvince();

	</script>
</div>
</body>
</html>