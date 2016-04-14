<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的投注信息</title>
<style type="text/css">
body {
	margin: 0 auto;
	max-width: 650px;
	overflow: hidden;
}

ul,p {
	list-style: none;
	margin: 0;
	padding: 0;
}

.page {
	background: url(< c : url value = "/resources/image/worldcup/dialog-bg.png"/ >)
		top center repeat-y;
	width: 100%;
	min-height: 500px;
	max-width: 650px;
	margin: 0 auto;
}

#header {
	padding: 20px 0 10px 20px;
}

.dialog {
width:100%;
	margin: 0 auto;
}

.thead {
	overflow: hidden;
}

.thead li {
	float: left;
	background-color: #9f9150;
	padding: 6px 0;
	width: 34%;
	color: #fff;
	font-size: 1.2em;
	text-align: center;
}

.thead li.even {
	background-color: #b4a870;
}

.thead li:first-child {
	width: 16%;
}

.thead li:nth-child(3n+1) {
	width: 16%
}

#result ul {
	overflow: hidden;
	border-bottom: 1px solid #ebe4b5;
	background-color: #ffffd3;
}

#result ul li {
	float: left;
	padding: 6px 0;
	width: 34%;
	text-align: center;
	color:#333;
	font-size:.9em;
}

#result ul li:first-child {
	width: 16%;
}

#result ul li:nth-child(3n+1) {
	width: 16%
}

.return {
	text-align: center;
	margin-top: 20px;
}

.return a {
	display: block;
	border: 1px solid #ddd;
	border-radius: .3125em;
	width: 100px;
	height: 50px;
	line-height: 50px;
	color: #FFF;
	background: -webkit-linear-gradient(top, #fea92e 0%, #f86e21 100%);
	text-decoration: none;
	margin: 0 auto;
}
</style>
</head>

<body>
	<div class="page">
		<header>
			<div id="header">
				<img src="<c:url value="/resources/image/worldcup/resulttitle.png"/>" />
			</div>
			<div class="dialog">
				<ul class="thead">
					<li>玩法</li>
					<li class="even">场次</li>
					<li>我的投注</li>
					<li class="even">结果</li>
				</ul>
				<div id="result">
					<c:forEach items="${bets}" var="bet">
						<ul>
							<li>${bet.type}</li>
							<li>${bet.matchLabel}</li>
							<li>${bet.betLabel}</li>
							<li>${bet.resultLabel}</li>
						</ul>
					</c:forEach>
				</div>
			</div>
		</header>
		<div class="return">
			<a href="<c:url value="/campaign/worldcup"/>">返回</a>
		</div>
	</div>
</body>
</html>
