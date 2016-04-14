<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>  
<html>
<head>
</head>
<body>
	<div data-role="page">
      <div data-role="header" data-theme="b">
        <h1>意见建议</h1>
        <a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
      </div>
      <div data-role="content">      
      	<ul data-role="listview" style="margin-top:0px">
      		<c:forEach var="item" items="${feedbackItems}">
      			<li>
    				${item.creatorName} : ${item.content}
    				<p>&nbsp;</p>
      				<p>${item.createTimeLabel}</p>
      			</li>	
      		</c:forEach>
      	</ul>
      	<h4>请输入您的回复</h4>
      	<form action="<c:url value='/feedback/newItem'/>" method="post" class="validate">
			<input type="hidden" name="feedbackId" value="${feedbackId}">
			<textarea name="content" id="content" minlength="5" maxlength="255" class="required"></textarea>
			<input type="submit" id="submitButton" data-theme="b" value="提交" />
		</form>	      	              
      </div>
      <div data-role="footer" data-position="fixed" data-theme="c">
        <div data-role="navbar" data-iconpos="left">
          <ul>
             <li><a href="<c:url value='/feedback'/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
             <li><a href="<c:url value='/help/instruction'/>"  data-icon="info">发现</a></li>
          </ul>
        </div>
      </div>
    </div>
	</body>
</html>