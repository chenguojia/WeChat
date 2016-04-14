<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>
<html>
<head>
</head>
<body>
	<div data-role="page" >
      <div data-role="header" data-theme="b">
        <h1>意见建议</h1>
        <a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
      </div>
      <div data-role="content"> 
      	<form action="<c:url value='/feedback/new'/>" method="post" class="validate">
			<label for="content">请输入您的意见或建议:</label> 
			<textarea name="content" id="content" minlength="5" maxlength="255" class="required"></textarea>
			<input type="submit" id="submitButton" data-theme="b" value="提交" />
		</form>	
		<h4>我的意见列表</h4>
      	<ul data-role="listview">
      		<c:forEach var="item" items="${feedbacks}">
      			<li>
      				<a href="<c:url value='/feedback/listItems?feedbackId=${item.id}'/>" >
      					${item.title}
      					<p>&nbsp;</p>
      					<p>更新于${item.updateTimeLabel}</p>
      				</a>
      			</li>	
      		</c:forEach>
      	</ul>              
      </div>
      <div data-role="footer" data-position="fixed" data-theme="c">
        <div data-role="navbar" data-iconpos="left">
          <ul>
             <li><a href="<c:url value='/'/>" class="ui-btn-icon-left ui-icon-back">返回</a></li>
             <li><a href="<c:url value='/help/instruction'/>"  data-icon="info">发现</a></li>
          </ul>
        </div>
      </div>
    </div>
	</body>
</html>