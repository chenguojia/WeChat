<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %> 
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>我的账户</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content" class="field">
			<div data-role="fieldcontain" class="readonly">
				<label for="name">姓名：</label><label>${account.name}</label> 
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="username">用户名：</label><label>${user.username}</label> 
			</div>			
			<div data-role="fieldcontain" class="readonly">
				<label for="bankCardNumber">借记卡号：</label><label>${account.bankCardNumberLabel}</label> 
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="bank">开户银行：</label><label>${account.bank}</label> 
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="idNumber">身份证号：</label><label>${account.idNumberLabel}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="mobile">手机号码：</label><label>${account.mobileLabel}</label> 
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="email">电子邮箱：</label><label>${account.email}</label> 
			</div>
			<a data-transition="none" data-role="button" data-theme="c" href="<c:url value="/auth/showUpdatePassword"/>">修改密码</a>
			<a data-transition="none" data-role="button" data-theme="c" href="<c:url value="/sales/new"/>">添加小伙伴</a>
			<%-- <a href="<c:url value="/testUser/queryAllUser"/>" data-role="button" data-theme="c"  data-ajax="false">测试</a> --%>
			
			<sec:authorize ifAllGranted="ROLE_SALES">
				<a data-transition="none" data-role="button" data-theme="c" href="<c:url value="/sales/performance/getPerformance"/>">我的绩效</a>
				<!-- 			
				<a data-transition="none" data-role="button" data-theme="c" href="<c:url value="/sales/new"/>">我的商户</a>
				 -->
			</sec:authorize>

			<%--驻地专员有导出提现报表权限--%>
			<c:if test="${isResidents == 1}">
				<button data-theme="c" id="purseReportBtn">提现报表</button>
			</c:if>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<div class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" style="max-width:400px;min-width:200px;" data-theme="a" data-overlay-theme="a" id="messageBox" data-role="popup">
			<div class="ui-corner-top ui-header ui-bar-a" data-theme="a" data-role="header" data-role="banner">
				<h1 class="ui-title" data-role="heading" id="messageBox-title"></h1>
			</div>
			<div class="ui-corner-bottom ui-content" data-role="main">
				<p id="messageBox-content"></p>
				<a data-theme="b" data-rel="back" data-role="button" data-inline="true" href="#" >确&nbsp;&nbsp;定</a>
			</div>
		</div>
		<script>
			$("#purseReportBtn").click(function(){
				var ua = window.navigator.userAgent.toLowerCase();
				if(ua.match(/MicroMessenger/i) == 'micromessenger'){
					$('#messageBox-content').html("此按钮请在电脑端点击!");
					$('#messageBox').popup('open');
				}else{
					window.location.href = "<c:url value="/background/home"/>";
				}
			});
		</script>
	</div>
</body>
</html>
