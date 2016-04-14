<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="leads-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>查看速融申请详情</h1>
			<a href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
		</div>
		<div data-role="content">
			<form>
				<div data-role="fieldcontain"  class="readonly">
					<label for="cashadvId">产品名称：</label> 
					<label id="cashadvId">${instantCreditModel.prodName}</label>
				</div>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="cashadvId">保理编号：</label> 
					<label id="cashadvId">${instantCreditModel.cashadvId}</label>
				</div>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="processor">机构：</label> 
					<label id="processor">${processorLabel}</label>
				</div>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="creationDate">创建日期：</label> 
					<label id="creationDate">${instantCreditModel.creationDate}</label>
				</div>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="fundingProduct">还款方式：</label> 
					<label id="fundingProduct">${instantCreditModel.fundingProduct}</label>
				</div>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="approveFundingAmount">批准融资额度：</label> 
					<label id="approveFundingAmount">${instantCreditModel.approveFundingAmount}</label>
				</div>
				
				<%-- <div data-role="fieldcontain"  class="readonly">
					<label for="approveFundingPeriod">批准融资期限：</label> 
					<label id="approveFundingPeriod">${instantCreditModel.approveFundingPeriod}</label>
				</div> --%>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="unpaidAmount">未还金额：</label> 
					<label id="unpaidAmount">${instantCreditModel.unpaidAmount}</label>
				</div>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="totalPaid">已还金额：</label> 
					<label id="totalPaid">${instantCreditModel.totalPaid}</label>
				</div>
				
				<div data-role="fieldcontain"  class="readonly">
					<label for="status">状态：</label> 
					<label id="status">${instantCreditModel.status}</label>
				</div>
				
				<c:if test="${instantCreditModel.status == '上传资料' || instantCreditModel.status == '审核中' || instantCreditModel.status == '待补件'  || instantCreditModel.status == '已补件'}">
					<a href="<c:url value='/m/closeFinancing?cashadvId=${instantCreditModel.cashadvId}'/>" data-theme="c" data-role="button" data-ajax="false">放弃申请</a>
				</c:if> 
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="/m/applyStatus"/>' class="ui-btn-icon-left ui-icon-back"  data-ajax="false">返回</a></li>
					<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
