<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>世界杯比赛结果更新</title>
    <style type="text/css">
	body{
		padding:0 10px;
		color:#333;
		}
    .field{
		border:1px solid #b9d996;
		text-align:center;
		}
	.status{
		margin-top:10px;
		}
	.status select{
		width:200px;
		height:30px;
		font-size:1em;
		}
	.backup{
		margin-top:10px;
		}
	.backup textarea{
		width:90%;
		height:100px;
		font-size:1em;
		}
	#update button{
	cursor:pointer;
	border:1px solid #ddd;
	width:60px;
	height:30px;
	font-size:1em;
	background: -webkit-linear-gradient(#5f9cc5, #396b9e);
	background: linear-gradient(#5f9cc5, #396b9e);
	background: -o-linear-gradient(#5f9cc5, #396b9e);
	background: -ms-linear-gradient(#5f9cc5, #396b9e);
	background: -moz-linear-gradient(#5f9cc5, #396b9e);
	border-radius:.3125em;
	color:#fff;
		}
    </style>
</head>
<body>
	<h1>结果更新</h1>
	<div class="field">
		<form action="<c:url value='/campaign/updateMatchResult'/>" method="post">
			<p class="title">${match.team1Name} vs ${match.team2Name}</p>
			<input type="hidden" name="matchId" value="${match.id}">
			<div class="status">
				<select name="result">
					<option value="1">主胜</option>
					<option value="2">客胜</option>
					<option value="0">未开始</option>
				</select>
			</div>
			<div class="backup">
				<textarea name="memo"></textarea>
			</div>
			<div id="update">
				<input type="submit" value="更新" />
			</div>
		</form>
	</div>
</body>
</html>
