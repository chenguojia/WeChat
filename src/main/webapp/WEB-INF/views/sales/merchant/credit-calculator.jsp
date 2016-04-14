<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="credit-caculator">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>商户额度计算</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form  action="<c:url value="/merchant/calculate"/>" method="post" class="validate">
				<p style="text-align: center;">${errorMessage}</p>			
				<div data-role="fieldcontain">
					<label for="region">所在地区：</label>
					<form:select path="calculateInfo.region">
						<form:options items="${regions}" itemLabel="name" itemValue="value"/>
					</form:select>
				</div>
				<div data-role="fieldcontain">
					<label for="busType">行业分类(MCC码)：</label> 
					<!-- 
					<form:select path="calculateInfo.busType">
						<form:options items="${busTypes}" itemLabel="name" itemValue="value"/>
					</form:select>
					 -->
					<input type="number" name="busType" id="busType" value="${calculateInfo.busType}" placeholder="例：1520" class="required mcc" />
				</div>
				<div data-role="fieldcontain">
					<label for="monthlyTransDays">月POS机交易天数：</label> 
					<input type="number" name="monthlyTransDays" id="monthlyTransDays" value="${calculateInfo.monthlyTransDays}" min="0" max="31" placeholder="例：24" class="required" />
				</div>
				<div data-role="fieldcontain">
					<label for="dailyTransCount">日平均刷卡笔数：</label> 
					<input type="number" name="dailyTransCount" id="dailyTransCount" value="${calculateInfo.dailyTransCount}" placeholder="例：50" class="required" />
				</div>
				<div data-role="fieldcontain">
					<label for="singleTransAmount">单笔平均刷卡金额(元)：</label> 
					<input type="number" name="singleTransAmount" id="singleTransAmount" value="${calculateInfo.singleTransAmount}" placeholder="例：100" class="required" />
				</div>
				
				<input type="submit" data-theme="b" value="计算"/>
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c" >
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
