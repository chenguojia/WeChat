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
			background: #fff url(<c:url value="/resources/image/egg-bk4.jpg"/>) no-repeat center center;
			width: 640px; 
			height: 1024px;
			position: relative;
			margin: 0px;
			color: #ff8c00;
			font: 20px 'Microsoft YaHei';
		}
	
		.totalAmount {
			padding-top: 490px;
			margin-left: 380px;
		}
		
		.awardCode {
			margin-top: 38px;
			margin-left: 380px;
		}
		.hotline {
			margin-top: 38px;
			margin-left: 380px;
		}
		.wechatNumber {
			margin-top: 38px;
			margin-left: 380px;
		}
		.link{ 
			width: 240px;
			margin:160px auto 0;
		}		
		.link a{
			display:block; 
			height:40px; 
			text-indent:-9999px;
		}
	</style>
</head>
<body style="height:100%;display:table;margin:auto;">
<div class="imageBody">
	<div class="summary">
		<div class="totalAmount">
			${dto.totalAmount}
			<c:if test="${dto.awardGave}">&nbsp;&nbsp;已领取</c:if>
		</div>
		<div class="awardCode">${dto.awardCode} </div>
		<div class="wechatNumber">${dto.wechatNumber}&nbsp;</div>	
		<div class="hotline">400-608-1310</div>
	</div>
	<div class="link">
		<a href="http://mp.weixin.qq.com/s?__biz=MzA5NDE5MzYyOA==&mid=200222063&idx=1&sn=4a58006aa21e169afa862e56280525e9&scene=1#rd">领奖说明</a>
	</div>
</div>
<script type="text/javascript">

function shareTimeline(){
	WeixinJSBridge.invoke("shareTimeline",{
	    "img_url":"http://220.248.19.21/wechat/resources/image/egg-icon.jpg",
	    "img_width":"120",
	    "img_height":"120",
	    "link":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4e0465dd6a4be55a&redirect_uri=http%3A%2F%2F220.248.19.21%2Fwechat%2Fcampaign%2FshowEdm&response_type=code&scope=snsapi_base",
	    "desc":"",
	    "title":"砸金蛋抽红包，赢取现金大奖!"
	 },function(d){alert(d);});
}

(function(){
	var onBridgeReady=function(){
	   WeixinJSBridge.on('menu:share:timeline', shareTimeline);
	   WeixinJSBridge.on('menu:send:appmessage', shareTimeline);
	};

	if(document.addEventListener){
	   document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
	}else if(document.attachEvent){
	   document.attachEvent('WeixinJSBridgeReady'   , onBridgeReady);
	   document.attachEvent('onWeixinJSBridgeReady' , onBridgeReady);
	}
})();

</script>
</body>
</html>

