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
	<div>
		<div >
			<img style="width:100%" alt="" src="<c:url value="/resources/image/campaign/integra/1.jpg"/>">
			<img style="width:100%" alt="" src="<c:url value="/resources/image/campaign/integra/4.jpg"/>">
			<img style="width:100%" alt="" src="<c:url value="/resources/image/campaign/integra/5.jpg"/>">
			<img style="width:100%" alt="" src="<c:url value="/resources/image/campaign/integra/3.jpg"/>">
		</div>
	</div> 		
<!-- <script type="text/javascript">

function shareTimeline(){
	WeixinJSBridge.invoke("shareTimeline",{
	    "img_url":"http://220.248.19.21/wechat/resources/image/egg-icon.jpg",
	    "img_width":"120",
	    "img_height":"120",
	    "link":"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4e0465dd6a4be55a&redirect_uri=http%3A%2F%2F220.248.19.21%2Fwechat%2Fcampaign%2FshowEdm&response_type=code&scope=snsapi_base",
	    "desc":"",
	    "title":"砸金蛋抽红包，赢取现金大奖!"
	 },function(d){alert(d);});
	$.get("<c:url value="/campaign/shareTimeline"/>",{"userId":"${userId}", "campaignId": "${campaignId}"},function(){ });
}

(function(){
	var onBridgeReady=function(){
	   WeixinJSBridge.on('menu:share:timeline', shareTimeline);
	};

	if(document.addEventListener){
	   document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
	}else if(document.attachEvent){
	   document.attachEvent('WeixinJSBridgeReady'   , onBridgeReady);
	   document.attachEvent('onWeixinJSBridgeReady' , onBridgeReady);
	}
})();

</script> -->
</body>
</html>