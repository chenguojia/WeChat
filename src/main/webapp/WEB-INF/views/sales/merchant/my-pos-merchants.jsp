<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>

<body>
<div data-role="page" id="my-pos-merchants">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>我已领取的商户</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
        <div data-role="content">
           <ul data-role="listview" data-filter="true" data-inset="true" data-filter-placeholder="请输入搜索条件...">
			<c:forEach items="${posMerchants}" var="merchant">
		    <li>
	            	<h5>${merchant.province}-${merchant.prefecture} ${merchant.industry}</h5>
					<p>联系人: ${merchant.contactName} ${merchant.contactGender}</p>
					<p>联系电话: ${merchant.contactMobile}</p>
	            	<p>发布日期: <fmt:formatDate type="date" value="${merchant.publishDate}"/> </p>
         	</li>
			</c:forEach>
           </ul>
        </div>
    <div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" data-rel="back" href="#" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
	</div>
</div>
</body>
</html>
