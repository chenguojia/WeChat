﻿<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>查看商户任务</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<div data-role="fieldcontain" class="readonly">
				<label for="taskNumber">任务编号：</label> <label id="taskNumber" >${task.number}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="merchantNumber">商户编号：</label> <label id="merchantNumber">${task.merchantNumber}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="merchantName">商户名称：</label> <label id="merchantName">${task.merchantName}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="merchantName">授信额度：</label> <label id="merchantName">${task.pqFundedAmount}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="status">当前状态：</label> <label id="status">${task.statusLabel}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="contactName">联系人姓名：</label> <label id="contactName">${task.contactName}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="identity">身份：</label> <label id="identity">${task.contactPositionLabel}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="contactNumber">联系电话：</label>  <label id="contactNumber">${task.contactMobile}</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="memo">备注：</label>
				<label id="memo">${task.memo}</label>
			</div>

			<c:if test="${task.statusLabel == '待补件' && !empty task.rfe && fn:length(task.rfe) > 0}">
					<div data-role="collapsible" data-theme="d" data-inset="true">
						<h3>需补件列表：</h3>
						<c:forEach var="file" varStatus="i" items="${task.rfe}">
							<div data-role="collapsible" data-inset="false" data-collapsed-icon="arrow-r" data-expanded-icon="arrow-d"  data-iconpos="right" >
								<h4 class="question-header">${file['title']}</h4>
								<div><p>${file['notes']}</p></div>
							</div>
						</c:forEach>
					</div>
			</c:if>

			<c:if test="${!empty task.memos && fn:length(task.memos) > 0}">
					<div data-role="collapsible" data-theme="d" data-inset="true">
						<h3>备忘录：</h3>
						<c:forEach var="memoObj" items="${task.memos}"  varStatus="i">
							<div data-role="collapsible" data-inset="false" data-collapsed-icon="arrow-r" data-expanded-icon="arrow-d"  data-iconpos="right" >
								<h4 class="question-header">${memoObj['time']}</h4>
								<div><p>${memoObj['note']}</p></div>
							</div>
						</c:forEach>
					</div>
			</c:if>

		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/task/list?group=${group}"/>" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>