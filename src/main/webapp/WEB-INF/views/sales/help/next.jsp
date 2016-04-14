<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>
</head>
<body>
		<div data-role="page" id="next">
      <div data-role="header" data-position="fixed" data-theme="b">
        <h1>即将推出</h1>
        <a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
      </div>
      <div data-role="content">      
      	在即将发布的下一个版本中，您将会体验到：<br>
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