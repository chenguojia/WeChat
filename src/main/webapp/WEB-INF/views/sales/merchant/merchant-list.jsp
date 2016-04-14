<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>	
</head>
<body>
	<div data-role="page" id="merchant-list">
      <div data-role="header" data-position="fixed" data-theme="b">
        <h1>我的商户</h1>
 		<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>      
      </div>
        <div data-role="content">
        <div class="infocontent">
        <p class="information">当前已添加了<span>${totalActiveMerchantNumber}</span>位有效商户, 您已添加了<span>${userActiveMerchantNumber}</span>位有效商户</p>
        </div>
        <ul data-role="listview" data-filter="true" data-inset="true" data-filter-placeholder="请输入搜索条件...">
     		<c:forEach var="item" items="${list}">
				<li>
					<a href="<c:url value='/sales/showMerchant?id=${item.id}'/>" >
					    <p class="status"><img src="<c:url value="/resources/image/nearby/star.png"/>"/></p>
						<h5 class="number">商户编号：${item.mid}</h5>
						<p>商户名称:${item.name}</p>
						<p>联系人:${item.contactName}</p>
						<p>状态:${item.activeStatusLabel}</p>
					</a>
				</li>
			</c:forEach>
		</ul>
						
        </div>
      		<div data-role="footer" data-position="fixed" data-theme="c">
        <div data-role="navbar" data-iconpos="left" >
          <ul>
            <li><a href='<c:url value="/sales/myMerchant"/>'  class="ui-btn-icon-left ui-icon-back">返回</a></li>
            <li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
          </ul>
        </div>
    	</div>
</div>
</body>
</html>
