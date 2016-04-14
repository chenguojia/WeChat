<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>砸金蛋, 天天赢大奖</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/jqModal.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/css/egg.css"/>" />
</head>
<body class="eggBody" style="height:100%;display:table;margin:auto;">
<div id="main">
	<div class="scroll">
		<div>
			<c:forEach items="${dto.awardMessages}" var="message">
				<a>${message}</a>
			</c:forEach>
		</div>
	</div>
	<div class="egg">
		<ul class="eggList">
			<p class="hammer" id="hammer">锤子</p>
			<p class="resultTip" id="resultTip"><b id="result"></b></p>
			<li><span></span><sup></sup></li>
			<li><span></span><sup></sup></li>
			<li><span></span><sup></sup></li>
		</ul>
	</div>
	<div class="name">
	 ${dto.name}
	</div>
	<div class="count">
	<span id="drawCount">${dto.drawCount}</span>次
	</div>
	<div class="awardLink"><a href="<c:url value="/sales/pointAndLevel"/>">查看奖励</a></div>
</div>

<div id="message" class="jqmDialog">
	<div class="jqmdTL"><div class="jqmdTR"><div class="jqmdTC jqDrag"></div></div></div>
	<div class="jqmdBL"><div class="jqmdBR"><div class="jqmdBC1">
		<div id="info" class="jqmdMSG1">
			
		</div>
	</div></div></div>
</div>

<div id="popup" class="jqmDialog">
	<div class="jqmdTL"><div class="jqmdTR"><div class="jqmdTC jqDrag">中奖啦</div></div></div>
	<div class="jqmdBL"><div class="jqmdBR"><div class="jqmdBC">
		<div class="jqmdMSG">
		<span id="amount"></span>元
		</div>
	</div></div></div>
</div>

<script type="text/javascript" src="<c:url value="/resources/script/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/script/jqModal.js"/>"></script>
<script type="text/javascript">
var token = '${token}';

function eggClick(obj) {
	$.get("<c:url value='/campaign/draw' />", {'userId': '${dto.userId}', 'campaignId': '${dto.campaignId}', 'token':token}, function(o){
		token = o.token;
		if(o.result > -1){
			$("#drawCount").html(o.remainDrawCount);
			var _this = obj;
			_this.unbind('click');
			 $(".hammer").css({"top":_this.position().top-100,"left":_this.position().left+155});
			 $(".hammer").show();
			 $(".hammer").animate({ 
				 "top":_this.position().top-70,
				 "left":_this.position().left+95
				 },150,function(){ 
					_this.addClass("curr"); //蛋碎效果
					_this.find("sup").show(); //金花四溅
					$(".hammer").hide();
					var amount = parseFloat(o.resultMessage);
					if(amount>=10){
						//弹出分享对话框
						$('#amount').html(o.resultMessage);
						$("#popup").jqmShow();
					}else{
						if(amount>0){
							$("#result").html("恭喜，您中得红包" + o.resultMessage + "元!");	
						}else{
							$("#result").html("很遗憾,您没能中奖!");
						}
						$('.resultTip').css({display:'block',top:'100px',left:_this.position().left+5,opacity:0}).animate({top: '50px',opacity:1},300);
				}
			});	
		}else if(o.result == -1){
			$('#info').html("很遗憾，当前您没有抽奖机会，请查看活动规则获取更多抽奖机会。");
			$('#message').jqmShow();
		}else if(o.result == -2){
			$('#info').html("活动已经圆满结束啦，谢谢您的大力支持，下一个活动会更加精彩，期待您的参与！");
			$('#message').jqmShow();
		}else{
			$('#info').html("对不起，您的请求正在处理中，请稍候。");
			$('#message').jqmShow();
		}
	});
}

$(".eggList li").click(function() {
	eggClick($(this));
});

function autoScroll(obj){
    $(obj).find("div").animate({
        marginTop:"-25px"
    },1000,function(){
        $(this).css({marginTop:"0px"}).find("a:first").appendTo(this);
    });
}

function rotateEgg(){
	$('.egg li').each(function(index, obj){
		setTimeout(function(){
			$(obj).animate({top:"-30px"}, 250);
			$(obj).animate({top:"0px"}, 250);}
		,index*500);
	});
}

$(function(){
	$.ajaxSetup({ cache: false });
	setInterval('autoScroll(".scroll")',3000);
	setInterval('rotateEgg()',2000);
	$('#popup').jqm();
	$('#message').jqm();
});

</script>

</body>
</html>

