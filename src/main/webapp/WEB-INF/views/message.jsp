<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/script/jqModal.js"/>"></script>
<style type="text/css">
body{
margin:0;
}
.message{
text-align:center;
min-height:420px;
position:absolute;
width:100%;
height:100%;
}
.errorpage img{
width:100px;
}
.errorpage{
padding-top:10%;
}
</style>
</head>
<body>
	<div data-role="page" id="home" class="message" style="background-image: -webkit-radial-gradient(#6facd5,#497bae);
background-image: radial-gradient(#6facd5,#497bae);">
		<!-- <div data-role="header" data-position="fixed" data-theme="b">
			<h1>温馨提示</h1>
		</div> -->
		<div class="errorpage"><img src="<c:url value="/resources/image/smile.png"/>"/></div>
		<div data-role="content" id="error">
			<p>${message}</p>
			<c:if test="${returnFlag}">
				<div style="text-align:center;padding-top:5%;"><a class="ui-btn ui-corner-all" href="<c:url value="/"/>">返回首页</a></div>
			</c:if>
		</div>
	</div>
</body>
</html>