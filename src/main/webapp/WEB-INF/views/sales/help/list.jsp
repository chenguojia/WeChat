<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>    
<html>
<head>
</head>
<body>
<div data-role="page" id="list" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
  <div data-role="header" data-position="fixed" data-theme="b">
    <h1>发现</h1>
    <a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
   </div> 
  <div data-role="content"> 
     <ul data-role="listview" data-inset="true">
		<li><a data-transition="none" href="<c:url value='/help/signHelp'/>" ><img src="<c:url value="/resources/image/helpsign.png"/>" alt="help" class="ui-li-icon ui-corner-none"/>签约帮助</a></li>
		<li><a data-transition="none" href="<c:url value='/help/question'/>" ><img src="<c:url value="/resources/image/myaccount.jpg"/>" alt="questions" class="ui-li-icon ui-corner-none"/>常见问题</a></li>
        <li><a data-transition="none" href="<c:url value='/help/instruction'/>" ><img src="<c:url value="/resources/image/introduction.png"/>" alt="introduction" class="ui-li-icon ui-corner-none"/>使用说明</a></li>
        <li><a data-transition="none" href="<c:url value='/help/contact'/>" ><img src="<c:url value="/resources/image/contact.png"/>" alt="contact" class="ui-li-icon ui-corner-none"/>联系我们</a></li>
        <!-- 
        <li><a href="<c:url value='/help/next'/>" >即将推出</a></li>
         -->
     </ul>   
  </div>
  <div data-role="footer" data-position="fixed" data-theme="c">
    <div data-role="navbar" data-iconpos="left" >
      <ul>
        <li><a data-transition="none" href="<c:url value="/"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
        <li><a data-transition="none" href="#" class="ui-btn-active ui-state-persist" data-icon="info">发现</a></li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>
