<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>
<html>
<head>
</head>
<body>
<div data-role="page" id="leads-status">
	<div data-role="header" data-position="fixed" data-theme="b">
		<h1>融资状态列表</h1>
		<a href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
	</div>
	<div data-role="content">
		<ul data-role="listview" data-filter="true" data-filter-placeholder="请输入搜索条件...">
			<c:forEach var="item" items="${list}">
				<li>
					<a href="<c:url value='/m/applyDetail?id=${item.id}'/>" >
						<h5>线索编号：${item.number}</h5>
						<p>商户编号：${item.merchantNumber}</p>
						<p>商户名称：${item.merchantName}</p>
						<p>状态：${item.statusLabel}</p>
						<c:if test="${item.updated == 1}">
							<span class="ui-li-count ui-btn-up-f ui-btn-corner-all ui-li-count-update">&nbsp;&nbsp;</span>
						</c:if>
					</a>
				</li>
			</c:forEach>

			<!-- 速融记录 -->
			<c:forEach var="instantItem" items="${instantCreditlist}">
				<li>
					<a href="<c:url value='/m/instantCreditDetail?cashadvId=${instantItem.cashadvId}'/>" >
						<h5>保理编号：${instantItem.cashadvId}</h5>
						<p>产品名称：${instantItem.prodName}</p>
						<p>批准资金额度：${instantItem.approveFundingAmount}</p>
						<p>状态：${instantItem.status}</p>
					</a>
				</li>
			</c:forEach>

		</ul>
	</div>
	<div data-role="footer" data-position="fixed" data-theme="c">
		<div data-role="navbar" data-iconpos="left" >
			<ul>
				<li><a href='<c:url value="/m/home"/>'  class="ui-btn-icon-left ui-icon-back" data-ajax="false">返回</a></li>
				<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>