<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>世界杯比赛结果</title>
    <style type="text/css">
   body{
	   color:#333;
	   overflow:hidden;
	   }
	ul, p {
	list-style:none;
	margin:0;
	padding:0;
}
.container{
	width:100%;
	padding:0 10px;
	margin:0 auto;
	}
ul li {
	cursor:pointer;
	border:1px solid #b9d996;
	background:-webkit-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: -o-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: -ms-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: -moz-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	width:90%;
	margin-bottom:2px;;
	line-height:15px;
	vertical-align:top;
}
ul li:hover {
	background:-webkit-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: -o-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: -ms-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: -moz-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
}
a{
	display:block;
	text-decoration:none;
	color:#333;
	padding:10px;
	}
    </style>
</head>

<body>
<div class="container">
<h1>世界杯比赛结果</h1>
<ul>
<c:forEach items="${matchs}" var="match">
	<li><a href="<c:url value='/campaign/showMatch?matchId=${match.id}'/>">${match.team1Name} VS ${match.team2Name}</a></li>
</c:forEach>

</ul>
</div>
</body>
</html>
