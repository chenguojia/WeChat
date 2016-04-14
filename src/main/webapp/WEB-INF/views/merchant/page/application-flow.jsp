<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="home">
		<div data-role="header" data-theme="b">
			<h1>公司资质</h1>
			<a href='<c:url value="/merchant/page/support"/>' class='ui-btn-right ui-btn-back' class="ui-btn-icon-left ui-icon-back">返回</a>
		</div>
		<div data-role="content" class="help-div">
	      	<p><img alt="申请流程" src="<c:url value='/resources/image/application-flow.png'/>" class="full-width"/></p>
		</div>
	  <div data-role="footer" data-position="fixed" data-theme="c">
	    <div data-role="navbar" data-position="fixed" data-iconpos="left" >
	      <ul>
	        <li> <a href='<c:url value="/merchant/page/about-us"/>'   class="ui-btn-icon-left ui-icon-back">返回</a> </li>
	        <li></li>
	      </ul>
	    </div>
	  </div>		
	</div>
</body>
</html>