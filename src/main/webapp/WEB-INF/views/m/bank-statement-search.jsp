<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %> 
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
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>对账单查询</h1>
			<a data-transition="none" href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content" class="field">
			<form id="sumitForm" action="<c:url value='/m/bankStatementList'/>" method="post"  class="validate">
			
				<div data-role="fieldcontain" id="estimate-feedback-days-div">
					<label for="feedbackDate">保理编号：</label>
					<select name="baoliId" id="baoliId" class="required">
						<c:forEach items="${baoliIdModels}" var="baoliItem">
							<option value="${baoliItem.cashadv_id }">${baoliItem.cashadv_id }</option>
						</c:forEach>
					</select>
				</div>	
				<div data-role="fieldcontain" id="estimate-feedback-days-div">
					<label for="feedbackDate">开始日期：</label>
					<input type="date" id="beginDate" name="beginDate" value="" data-role="datebox" data-options='{"mode": "calbox", "useNewStyle":true}'  class="required"/>					
				</div>	
				<div data-role="fieldcontain" id="estimate-feedback-days-div">
					<label for="feedbackDate">结束日期：</label>
					<input type="date" id="endDate" name="endDate" value="" data-role="datebox" data-options='{"mode": "calbox", "useNewStyle":true}'  class="required"/>					
				</div>	
				<div data-role="fieldcontain" class="readonly">
					<input type="submit" data-theme="b" value="查询">
				</div>
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="/m/account"/>'  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
