﻿<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>
</head>
<body>
		<div data-role="page" id="sign-help" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
      <div data-role="header" data-position="fixed" data-theme="b">
        <h1>帮助支持</h1>
        <a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
      </div>
      <div data-role="content">      
      	<ul data-role="listview" data-inset="true">
            <li><a data-transition="none" href="<c:url value='/help/signPolicy'/>" >签约政策</a></li>
	        <li><a data-transition="none" href="<c:url value='/help/signDocument'/>" >签约资料</a></li>
            <li><a data-transition="none" href="<c:url value='/help/signRule'/>" >签约规范</a></li>
    	</ul>              
      </div>
	  <div data-role="footer" data-position="fixed" data-theme="c">
        <div data-role="navbar" data-iconpos="left" >
          <ul>
            <li><a data-transition="none" href="<c:url value="/help/list"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
            <li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
          </ul>
        </div>
      </div>      
    </div>              	
	</body>
</html>