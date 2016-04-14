<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>    
<html>
<head>
</head>
<body>
		<div data-role="page" id="instruction">
      <div data-role="header" data-position="fixed" data-theme="b">
        <h1>使用说明</h1>
        <a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
      </div>
      <div data-role="content" class="help-div">
      	<h4>如何关注我们的微信账号</h4>
      	<p> 
		可以通过搜索卡得万利的服务账号“卡得万利”，或扫描二维码（如下）来关注卡得万利的服务号
      	</p>
      	<img alt="签约规范样例1" src="<c:url value='/resources/image/qr-code.png'/>" style="max-width:430px" class="full-width"/> 
      </div>
	  <div data-role="footer" data-position="fixed" data-theme="c">
        <div data-role="navbar" data-iconpos="left" >
          <ul>
             <li><a data-transition="none" href="<c:url value="/help/list"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
             <li><a data-transition="none" href="<c:url value="/help/list"/>" class="" data-icon="info">发现</a></li>
          </ul>
        </div>
      </div>      
    </div>              	
	</body>
</html>