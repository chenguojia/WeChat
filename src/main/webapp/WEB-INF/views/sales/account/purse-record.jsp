<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>	
</head>

<body>
<div data-role="page" id="particulars">
        <div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>我的明细</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
  <div data-role="content">
     <div class="purserecord">
       <div class="container">
        <ul class="heading" data-role="none">
        <li>日期</li>
        <li>事项</li>
        <li>钱包余额</li>
        </ul>
      <div class="table">
      	<c:forEach items="${records}" var="item">
      	<ul data-role="none">
        	<li>${item.createDate}</li>
        	<li>
        		<c:if test="${item.action == 1}">
        			获得${item.amount}元(${item.memo})
        		</c:if>
        		<c:if test="${item.action == 2}">
        			提现${item.amount}元(${item.memo})
        		</c:if>
        	</li>
        	<li>余额${item.balance}元</li>
        </ul>
      	</c:forEach>
       </div>
      </div>
    </div>
  </div>
  <div data-role="footer" data-position="fixed" data-theme="c">
	<div data-role="navbar" data-iconpos="left">
		<ul>
			<li><a href="<c:url value="/sales/pointAndLevel"/>" class="ui-btn-icon-left ui-icon-back">返回</a></li>
			<li><a href="<c:url value="/help/list"/>" data-icon="info">发现</a></li>
		</ul>
	</div>
 </div>
</div>
</body>
</html>
