<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>
</head>
<body>
<div data-role="header" data-position="fixed" data-theme="b">
  <h1>线索状态</h1>
  <a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
 </div> 
<div data-role="content">
  <ul data-role="listview" data-inset="true">
  	<c:forEach var="item" items="${list}">
  		<li> 
  			<a href="<c:url value='/leads/list?status=${item.status}'/>" >
  				${item.statusLabel}
  				<span class="ui-li-count">${item.count}</span>
  				 <c:if test="${item.updateCount > 0 }">
  					<span class="ui-li-count ui-btn-up-f ui-btn-corner-all ui-li-count-update">${item.updateCount}</span>
  				</c:if>
  			</a> 
  		</li>
  	</c:forEach>
  </ul>
</div>
<div data-role="footer" data-position="fixed" data-theme="c">
  <div data-role="navbar" data-iconpos="left" >
    <ul>
      <li><a href="<c:url value="/"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
      <li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
    </ul>
  </div>
</div>
</body>
</html>
