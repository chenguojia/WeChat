<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <meta charset="utf-8">
<title>知识抢答大赛</title>
<style type="text/css">
body{
	margin:0 auto;
	background-color:#739e11;
	padding-top:10px;
	}
p{
	margin:0;
	}
.header{
	text-align:center;
	margin-bottom:-40px;
	}
.logo{
	text-align:center;
	}
.logo img{
	width:150px;
	}
.content{
	width:95%;
	margin:0 auto;
	min-height:280px;
	border:4px solid #ebd49f;
	border-radius:25px;
	background-color:#fff;
	margin-bottom:10px;
	}
	
.innercontent{
	border:4px solid #b88a63;
	width:97%;
	margin:0 auto;
	min-height:280px;
	border-radius:20px;
	padding-top:40px;
	}
.question{
	width:90%;
	margin:0 auto;
	min-height:40px;
	border-radius:20px;
	background-color:#f0e8d6;
	padding:5px;
	overflow:hidden;
	margin-bottom:10px;
	}
.question img{
	float:left;
	margin-left:10px;
	}
.question p{
	margin-left:60px;
	}	

.anwser{
	width:90%;
	margin:0 auto;
	min-height:100px;
	border-radius:20px;
	background-color:#f0e8d6;
	padding:5px;
	}
.anwser p{
	margin:10px;
	}
.submit{
	text-align:center;
	margin-top:20px;
	}
.submit a:first-child img{
	margin-right:10px;
	}
.areyouright{
	text-align:center;
	margin-bottom:-20px;
	}
.previous{
	width:95%;
	margin:0 auto;
	min-height:160px;
	border:4px solid #ebd49f;
	border-radius:25px;
	background-color:#fff;
	padding-top:15px;
	margin-bottom:10px;
	}
.previous p{
	background-color:#f0e8d6;
	border-radius:10px;
	margin:10px;
	min-height:30px;
	padding:5px 0 0 10px;
	}
.previous p span{
	color:#624208;
	}
.introduce{
	width:95%;
	margin:0 auto;
	min-height:160px;
	border:4px solid #ebd49f;
	border-radius:25px;
	background-color:#fff;
	}
.introduce ol li{
	margin-top:10px;
	}
.needtoknow{
	text-align:center;
	margin-bottom:-15px;
	}
</style>
<script>
$(document).ready(function(){
	$("#submit").click(function(){
	var scrollHeight = $(document).scrollTop(),
	  windowHeight = $(window).height(),
	  windowWidth = $(window).width(),
	  popupHeight = $(".popup").height(),
	  popupWeight = $(".popup").width();
	  posiTop = (windowHeight - popupHeight)/2 + scrollHeight;
	  posiLeft = (windowWidth - popupWeight)/2;
	  $(".popup").css({"left": posiLeft + "px","top":posiTop + "px","display":"block"});
	});
	$(".close").click(function(){
		$(".popup").hide();
	});
});
</script>
</head>

<body>
<div class="main">
<header>
<div class="logo">
<img src="<c:url value="/resources/image/competition/images/cardvalue_logo1.png"/>" />
</div>
<div class="header">
<img src="<c:url value="/resources/image/competition/images/header.png"/>" />
</div>
<div class="content">
<div class="innercontent">
<div class="question">
<img src="<c:url value="/resources/image/competition/images/topic.png"/>"/><p>鱼香肉丝是哪个地方菜</p>
</div>
<div class="anwser">
<p><input type="radio" name="anwser" value="东北菜" />东北菜 </p>
<p><input type="radio" name="anwser" value="鲁菜" />鲁菜 </p>
<p><input type="radio" name="anwser" value="粤菜" />粤菜</p>
<p><input type="radio" name="anwser" value="江浙菜" />江浙菜</p>
</div>
<div class="submit">
<a href="#" ><img src="<c:url value="/resources/image/competition/images/submit.png"/>" /></a>
<a href="#"><img src="<c:url value="/resources/image/competition/images/historybtn.png"/>"/></a>
</div>
</div>
</div>
</header>
</div>

<div class="second">
<div class="areyouright">
<img src="<c:url value="/resources/image/competition/images/areyouright.png"/>" />
</div>
<div class="previous">
<p>昨日问题: <span>小鸡炖蘑菇是哪个地方菜</span></p>
<p>正确答案: <span>东北菜</span></p>
<p>昨日大奖: <span>张三</span></p>
</div>
</div>
<div class="third">
<div class="needtoknow">
<img src="<c:url value="/resources/image/competition/images/introduce.png"/>" />
</div>
<div class="introduce">
<ol>
<li>系统每天发放1000积分。</li>
<li>答错的参赛者将失去20积分。</li>
<li>每天第一位答题正确的将获得500积分。</li>
<li>其余答对参赛者将平分剩余余积分。</li>
<li>每日答题在第二天公布答案。</li>
</ol>
</div>
</div>
<div class="popup">
<h4>提示框</h4>
<div class="popcontent">对不起，你今天已经提交过答案了。</div>
<div class="close"><img src="<c:url value="/resources/image/competition/images/close.png"/>" alt="close" /></div>
</div>
</body>
</html>
