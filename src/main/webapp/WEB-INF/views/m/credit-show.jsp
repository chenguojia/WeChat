<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<style type="text/css">
   .ui-page-theme-a .ui-listview .ui-body-inherit{
   background-color:#f6f6f6;
   }
      .ui-page-theme-a .ui-listview  a.ui-btn{
   background-color:#fff;
   }
</style>
</head>
<body>
	<div data-role="page" id="task-status">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>授信详情</h1>
			 <a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
		</div>
		<div data-role="content">
			<h5>${titleMsg}</h5>
			<ul data-role="listview" data-inset="true" >
				<c:forEach items="${websiteCreditModel.results}" var="item">
					<c:if test="${item.prodName == '速融'}">
						<%--<li><a href="<c:url value='/m/instantCreditShow?entryType=2'/>" data-ajax="false">
							<h5>${item.prodName}</h5>
							<p>授信额度：${item.credit}</p>
						<span class="extra">
							可申请
						</span>
						</a></li>--%>
					</c:if>
					<c:if test="${item.prodName != '速融'}">
						<li>
							<h5>${item.prodName}</h5>
							<p>授信额度：${item.credit}</p>
							<span class="extra">
								需网站申请
							</span>
						</li>
					</c:if>
				</c:forEach>
			</ul>
			<a href="<c:url value="/m/showApply"/>"  data-role="button" data-theme="b" data-ajax = "false">提交线索</a>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/m/myAccount"/>"  class="ui-btn-icon-left ui-icon-back"  data-ajax="false">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		
	</div>
</body>
</html>