<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
	<div data-role="page" id="credit-caculator">
		<div data-role="header" data-theme="b">
			<h1>授信额度计算</h1>
		</div>
		<div data-role="content">
			<form id="calculateForm" action="<c:url value="/merchant/calculate"/> " method="post" class="validate">
				<input type="hidden" name="type" value="merchant"/>
				<div data-role="fieldcontain">
					<label>所在地区：</label>
					<form:select path="calculateInfo.region">
						<form:options items="${regions}" itemLabel="name" itemValue="name" />
					</form:select>
				</div>
				<div data-role="fieldcontain">
					<label for="busType">商户分类代码(MCC)：</label> 
					<input type="number" name="busType" id="busType" value="${calculateInfo.busType}" placeholder="例：1520" class="required" /> （*您商户编号的第8位到第11位）
				</div>
				<div data-role="fieldcontain">
					<label for="monthlyTransDays">月POS机刷卡天数：</label> 
					<input type="number" name="monthlyTransDays" id="monthlyTransDays" value="${calculateInfo.monthlyTransDays}" placeholder="例：24" class="required" />
				</div>
				<div data-role="fieldcontain">
					<label for="dailyTransCount">日平均刷卡笔数：</label> 
					<input type="number" name="dailyTransCount" id="dailyTransCount" value="${calculateInfo.dailyTransCount}" placeholder="例：50" class="required" />
				</div>
				<div data-role="fieldcontain">
					<label for="singleTransAmount">单笔平均刷卡金额(元)：</label> 
					<input type="number" name="singleTransAmount" id="singleTransAmount" value="${calculateInfo.singleTransAmount}" placeholder="例：100"
						class="required" />
				</div>
				<input id="calculateButton" type="submit" data-theme="b" value="计算" />
			</form>
		</div>
	</div>
</body>
</html>
