<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="utf8">
	<title>卡得万利商业保理</title>
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
  	<style type="text/css">
  		*{padding:0px;margin:0px}
  	</style>
</head>
<body>
	<div data-role="page" id="show-picture">
		<img style="width: 100%" alt="" src="<c:url value="/resources/image/edm/${pictureName}"/>">
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" data-rel="back" href="#" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value='/help/list'/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>