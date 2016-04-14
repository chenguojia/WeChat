<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <meta charset="utf-8">
<title>答题历史</title>
<style type="text/css">
body{
	margin:0 auto;
	background-color:#739e11;
	padding-top:10px;
	}
ul{
	list-style:none;
	padding: 0 10px;
	}
p{
	margin:10px 0;
	}
.header{
	text-align:center;
	margin-bottom:-20px;
	}
.logo{
	text-align:center;
	}
.logo img{
	width:150px;
	}
.container{
	width:95%;
	margin:0 auto;
	border:4px solid #ebd49f;
	border-radius:25px;
	background-color:#fff;
	padding-top:15px;
	margin-bottom:10px;
	min-height:300px;
	}
.content{
	max-height:300px;
	overflow-y:scroll;
	}
.content li p span{
	color:#624208;
	}
.content li p span:first-child{
	color:#000;
	}
.content li{
	border-radius:20px;
	background-color:#f0e8d6;
	padding:5px;
	margin-bottom:10px;
	}
.goback{
	text-align:center;
	margin-bottom:20px;
	}
</style>
</head>

<body>
<div class="main" id="container">
<header>
<div class="logo">
<img src="<c:url value="/resources/image/competition/images/cardvalue_logo1.png"/>" />
</div>
<div class="header">
<img src="<c:url value="/resources/image/competition/images/history.png"/>" />
</div>
</header>
<div class="container">
<div id="content">
<ul class="content">
<li>
<p><span>我的答题: </span><span>小鸡炖蘑菇是哪个地方菜</span></p>
<p><span>我的答案: </span><span>东北菜</span></p>
<p><span>正确答案: </span><span>东北菜</span></p>
<p><span>积分情况: </span><span>获得20分</span></p>
</li>
<li>
<p><span>我的答题: </span><span>我国晋商，富甲天下，誉满全球，荣膺明清时代十大商帮之首，与威尼斯商人、犹太商人并称为世界三大商帮。我国晋商会如此成功的本质原因是</span></p>
<p><span>我的答案: </span><span>尔虞我诈，唯利是图</span></p>
<p><span>正确答案: </span><span>对人诚信，对事诚信</span></p>
<p><span>积分情况: </span><span>失去20分</span></p>
</li>
<li>
<p><span>我的答题: </span><span>日本位于哪个洲</span></p>
<p><span>我的答案: </span><span>欧洲</span></p>
<p><span>正确答案: </span><span>亚洲</span></p>
<p><span>积分情况: </span><span>失去20分</span></p>
</li>
</ul>
</div>
<div class="goback"><a href="#"><img src="<c:url value="/resources/image/competition/images/goback.png"/>" /></a></div>
</div>

</div>
</body>
</html>
