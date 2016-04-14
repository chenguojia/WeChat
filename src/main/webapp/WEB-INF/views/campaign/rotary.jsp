<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta charset="utf8">
	<title>卡得万利商业保理</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/rotary.css"/>" /> 
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
  	<script type="text/javascript" src="<c:url value="/resources/script/jquery.rotate.min.js"/>"></script>
</head>
<body>			
	<div class="rotaryBg"></div>
<div class="header">
	<h1 class="tc"><img width="80%" src="<c:url value="/resources/image/rotary/rotarylogo.png"/>"></h1>
    <div class="tc"><img width="70%" id="luckbag" src="<c:url value="/resources/image/rotary/luckbag.png"/>" /></div>
    <div class="tc" >
    	<div style="overflow:hidden; margin-left:20%">
            <img width="40%" class="fl"  src="<c:url value="/resources/image/rotary/rotarytimes1.png"/>" />
            <span id="drawCount" class="timesBg fl"><fmt:formatNumber value="${drawCount}" pattern="###.##" /></span>
            <img width="15%" class="fl"  src="<c:url value="/resources/image/rotary/rotarytimes2.png"/>" />
        </div>
    </div>
</div>
<div class="rotary">
    <div class="rotaryTable" id="rotaryTable"><img width="90%" src="<c:url value="/resources/image/rotary/rotarytable.png"/>" /></div>
	<div class="rotaryArrow" id="rotaryArrow"><img onfocus=this.blur() border="0" width="80px" src="<c:url value="/resources/image/rotary/rotaryArrow.png"/>" /></div>
	<div class="result" id="result">
		<div class="resultHead"><img width="100%" src="<c:url value="/resources/image/rotary/congulations.png"/>" />
        	<a href="javascript:;" id="resultBtn" title="关闭">关闭</a>
        </div>
        <div class="resultBody">
            <p id="resultTxt">您抽中<span class="prize"></span><span>元</span>红包一个</p>
            <p>请进入积分专区查收钱包金额</p>
            <div style="overflow:hidden; margin-top:20px;">
            <a class="withdrawal fl" href="<c:url value='/sales/pointAndLevel'/>">立即提现</a>
            <a class="continue fr" href="javascript:;">继续抽奖</a>
            </div>
        </div>
	</div>
    <div class="tips" id="tips">
    	<div class="resultHead">
        	<img width="100%" src="<c:url value="/resources/image/rotary/tips.png"/>" />
        	<a href="javascript:;" id="tipsBtn" title="关闭">关闭</a>
        </div>
        <div class="resultBody tc">
        	<p id="tipsTxt"></p>
            <a class="confirm" style="margin-top:20px;" href="javascript:;">确定</a>
        </div>
    </div>
</div>
<div class="instructions">
	<div class="content">
        <h2>活动说明</h2><%--2013年1月20日-2015年3月19日--%>
        <p><span>活动时间:</span><span><fmt:formatDate value="${campaign.beginDate}" type="date" dateStyle="long"/>-<fmt:formatDate value="${campaign.endDate}" type="date" dateStyle="long"/></span></p>
        <p><span>参与方式:</span><span>每提交一条成功线索即可获得一次抽奖机会</span></p>
        <p><span>奖金领取方式:</span><span>进入<a href="<c:url value='/sales/pointAndLevel'/>">活动专区</a>进行提现</span></p>
        <p class="lines"></p>
        <p><sup>*</sup>成功线索是指该线索中的商户存在实际融资需求。</p>
        <p><sup>*</sup>所提线索是否为成功线索以后台审核结果为准。</p>
    </div>
</div>
<script type="text/javascript">
$(function(){
	var $rotaryArrow = $('#rotaryArrow');
	var $result = $('#result');
	var $resultTxt = $('#resultTxt .prize');
	var $resultBtn = $('#result #resultBtn');
	var $rotaryTable=$("#rotaryTable img");
	var $rotateBg=$(".rotaryBg");
	width=document.body.scrollWidth;
	height=document.body.scrollHeight;
	$rotateBg.css("height",height);
	$rotaryArrow.css({"left":width/2-40,"top":$rotaryTable.height()*0.5-100});
	$(window).resize(function(){
		width=document.body.scrollWidth;
		$rotaryArrow.css({"left":width/2-40,"top":$rotaryTable.height()*0.5-100});
		});
	$("#luckbag").load(function(){
		$rotaryArrow.css({"left":width/2-40,"top":$rotaryTable.height()*0.5-100});
		});

	//抽奖箭头公共点击事件
	function rotaryArrowclickEvent(){
		//禁止指针点击，防止重复提交
		$rotaryArrow.unbind("click");
		if($("#drawCount").text()>0){
			$.getJSON("<c:url value="/campaign/drawRotary"/>", function(data){
				var code = data.result;
				if(code > 0){
					var angle = 0;
					if(code == 1){
						angle = 18 + 72*Math.floor(Math.random()*6);
					}else{
						angle = 54 + 72*(4-code);
				}
					rotateFunc(angle,data.resultMessage, data.remainDrawCount);
				}else{
					var text=data.resultMessage;
					$("#tipsTxt").html(text);
					$("#tips").show();
					$(".rotaryBg").show();
					$rotaryArrow.bind("click",rotaryArrowclickEvent);//重新箭头绑定事件
				}
			});
		}
		else{
			var text="很抱歉，当前您没有抽奖次数";
			$("#tipsTxt").html(text);
			$("#tips").show();
			$(".rotaryBg").show();
		}
	}

	$rotaryArrow.click(function(){
		rotaryArrowclickEvent();
	});

	var rotateFunc = function(angle,text,drawCount){  //awards:奖项，angle:奖项对应的角度
		$rotaryTable.stopRotate();
		$rotaryTable.rotate({
			angle: 0,
			duration: 5000,
			animateTo: angle + 2160,  //angle是图片上各奖项对应的角度，1440是让指针固定旋转4圈
			callback: function(){
				$resultTxt.html(text);
				$result.show();
				$(".rotaryBg").show();
				$("#drawCount").text(drawCount);
				$rotaryArrow.bind("click",rotaryArrowclickEvent);//重新箭头绑定事件
			}
		});
	};

	$resultBtn.click(function(){
		$result.hide();
		$(".rotaryBg").hide();
	});
	$(".continue").click(function(){
		$result.hide();
		$(".rotaryBg").hide();
	});
	$("#tipsBtn").click(function(){
		$("#tips").hide();
		$(".rotaryBg").hide();
		
	});
	$(".confirm").click(function(){
		$("#tips").hide();
		$(".rotaryBg").hide();
	});
});
</script>
</body>
</html>