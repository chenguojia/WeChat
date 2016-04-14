<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>
</head>
<body>
		<div data-role="page" id="home" style="background:url(<c:url value="/resources/image/bg.png"/>) repeat">
      <div data-role="header" data-theme="b">
        <h1>客户经理工作平台</h1>
      </div>
      <div data-role="content">      
      	<ul data-role="listview" style="margin-top:0px" data-inset="true">
        	<li><a data-transition="none" href="<c:url value='/merchant/criteria'/>" >授信查询</a></li>
			<li><a data-transition="none" href="<c:url value='/merchant/calculator'/>" >计算额度</a></li>
            <li><a data-transition="none" href="<c:url value='/help/support'/>" >帮助支持</a></li>
    		<li><a data-transition="none" href="<c:url value='/help/news'/>" >最新资讯</a></li>
            <li><a data-transition="none" href="<c:url value='/help/contact'/>" >联系我们</a></li>
      	</ul>              
      </div>
      <div data-role="footer" data-position="fixed" data-theme="c">
        <div data-role="navbar" data-iconpos="left">
          <ul>
             <li><a data-transition="none" href="#" class="ui-btn-active ui-state-persist" data-icon="home">主页</a></li>
             <li><a data-transition="none" href="<c:url value='/help/instruction'/>"  data-icon="info">发现</a></li>
          </ul>
        </div>
      </div>
    </div>
	</body>
</html>