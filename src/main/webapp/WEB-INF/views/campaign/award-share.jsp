<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="utf-8">
	<title>砸金蛋, 天天赢大奖</title>
	<style type="text/css">
		body {
			margin: 0px;
		}
		.imageBody{
			background: #fff url(<c:url value="/resources/image/egg-bk3.jpg"/>) no-repeat center center;
			width: 640px; 
			height: 1024px;
		}
		.name{
			padding-top: 380px;
			margin-left: 180px;
			font: 24px 'Microsoft Yahei';
		}
		.amount{
			margin: 20px auto;
			text-align: center;
			font: 100px arial, sans-serif;
			color: red;
		}
	</style>
</head>
<body style="height:100%;display:table;margin:auto;">
<div class="imageBody">
	<div class="summary">
		<div class="name">${name}</div>
		<div class="amount">${amount}元</div>
	</div>
</div>
</body>
</html>