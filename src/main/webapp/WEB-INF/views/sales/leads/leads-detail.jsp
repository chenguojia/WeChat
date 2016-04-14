<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="leads-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>查看线索</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form>
				<div data-role="fieldcontain"  class="readonly">
					<label for="leadsNumber">线索编号：</label> 
					<label>${leads.number}</label> 
				</div>
				<div data-role="fieldcontain"  class="readonly">
					<label for="leadsNumber">融资产品：</label> 
					<label>${leads.productTitle}</label> 
				</div>

				<c:if test="${!empty leads.pqFundedAmount && leads.pqFundedAmount != ''}">
					<div data-role="fieldcontain"  class="readonly">
						<label for="leadsNumber">授信额度：</label>
						<label>${leads.pqFundedAmount}</label>
					</div>
				</c:if>

				<div data-role="fieldcontain" class="readonly">
					<label for="statusChangeTime">最近状态更新时间：</label>
					<label id="statusChangeTime">${leads.statusChangeTime}</label>
				</div>		
				<div data-role="fieldcontain"  class="readonly">
					<label for="status">当前状态：</label> 
					<label>${leads.statusLabel}</label>
				</div>
				<div data-role="fieldcontain"  class="readonly">
					<label for="merchantNumber">商户编号：</label> 
					<label>${leads.merchantNumber}</label>
				</div>
				<div data-role="fieldcontain"  class="readonly">
					<label for="merchantName">商户名称：</label> 
					<label>${leads.merchantName}</label>
				</div>
				<div data-role="fieldcontain"  class="readonly">
					<label for="contactName">联系人：</label> 
					<label>${leads.merchantContact}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="identity">身份：</label> 
					<label>${leads.contactPositionLabel}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="mobileNumber">手机号码：</label> 
					<label>${leads.contactMobile}</label>
				</div>
				<div data-role="fieldcontain" class="readonly">
					<label for="leadsMemo">线索备注：</label>
					<label>${leads.memo}</label>
				</div>
				<c:if test="${!empty leads.memos && fn:length(leads.memos) > 0}">
					<div data-role="fieldcontain" class="readonly">
						<div data-role="collapsible" data-theme="d" data-inset="true">
							<h3>备忘录</h3>
							<c:forEach var="memoObj" items="${leads.memos}"  varStatus="i">
								<div data-role="collapsible" data-inset="false" data-collapsed-icon="arrow-r" data-expanded-icon="arrow-d"  data-iconpos="right" >
									<h4 class="question-header">${memoObj['time']}</h4>
									<div><p>${memoObj['note']}</p></div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>


				<a href="<c:url value='/leads/edit?id=${leads.id}'/>"  data-role="button">修改</a>
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="/leads/list?status=${status}"/>' class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
