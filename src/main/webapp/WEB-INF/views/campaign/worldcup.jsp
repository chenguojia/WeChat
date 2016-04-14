<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <meta charset="utf-8">
    <title>世界杯竞猜赢积分</title>
    <style type="text/css">
body {
	max-width:650px;
	margin:0 auto;
	color:#fff;
	min-width:323px;
	overflow:hidden;
}
ul, p {
	list-style:none;
	margin:0;
	padding:0;
}
.background {
	background:url(<c:url value="/resources/image/worldcup/worldcupbg2.jpg"/>) top center no-repeat;
	width:100%;
	min-height:400px;
	padding-top:20px;
}
.content {
	background:url(<c:url value="/resources/image/worldcup/blackbord.png"/>) top center no-repeat;
	width:100%;
	min-height:380px;
	text-align:center;
	padding-top:1px;
}
.content h1 {
	text-shadow:0 0 8px #ff3e31;
	margin:10px 0;
}
.checkresult{
	margin-top:30px;
	}
.checkresult a {
	display:block;
	border:1px solid #ddd;
	border-radius:.3125em;
	width:120px;
	height:30px;
	line-height:30px;
	color:#FFF;
	background:-webkit-linear-gradient(top, #fea92e 0%, #f86e21 100%);
	background: linear-gradient(top, #fea92e 0%, #f86e21 100%);
	background: -o-linear-gradient(top, #fea92e 0%, #f86e21 100%);
	background: -ms-linear-gradient(top, #fea92e 0%, #f86e21 100%);
	background: -moz-linear-gradient(top, #fea92e 0%, #f86e21 100%);
	text-decoration:none;
	margin:0 auto;
}
.checkresult a:hover{
	text-decoration:underline;
	}
hr {
	border:1px dashed #fff;
	box-shadow:0 0 6px #ff3e31;
	width:520px;
}
#tab-title .selected {
	text-shadow:0 0 8px #ff3e31;
}
#tab-content {
	padding-left:13%;
}
.teaminfo p {
	text-shadow:0 0 8px #ff3e31;
	margin:5px 0;
}
.time {
	text-shadow:0 0 8px #ff3e31;
	line-height:50px;
	padding:0 5px;
}
button {
	cursor:pointer;
	border:1px solid #ddd;
	width:60px;
	height:30px;
	font-size:1em;
	background:#396b9e;
	background-image:linear-gradient(#5f9cc5, #396b9e);
	background: linear-gradient(#5f9cc5, #396b9e);
	background: -o-linear-gradient(#5f9cc5, #396b9e);
	background: -ms-linear-gradient(#5f9cc5, #396b9e);
	background: -moz-linear-gradient(#5f9cc5, #396b9e);
	border-radius:.3125em;
	color:#fff;
}
.popupcontent {
	display:none;
	position:absolute;
	z-index:999;
	border-color:#ddd;
	background-color:#fff;
	-webkit-box-shadow:0 0 12px rgba(0, 0, 0, .6);
	-moz-box-shadow:0 0 12px rgba(0, 0, 0, .6);
	box-shadow:0 0 12px rgba(0, 0, 0, .6);
	-webkit-border-radius:.3125em;
	border-radius:.3125em;
	text-align:center;
	padding:5px 10px;
}
.popupcontent .submit{
	width:80px;
	height:40px;
	margin-top:10px;
}
.recheck{
	display:none;
	position:absolute;
	z-index:999;
	border-color:#ddd;
	background-color:#fff;
	-webkit-box-shadow:0 0 12px rgba(0, 0, 0, .6);
	-moz-box-shadow:0 0 12px rgba(0, 0, 0, .6);
	box-shadow:0 0 12px rgba(0, 0, 0, .6);
	-webkit-border-radius:.3125em;
	border-radius:.3125em;
	text-align:center;
	padding:5px 10px;
	color:#333;
	padding-top:30px;
	}
.recheck .closerecheck{
	width:80px;
	height:40px;
	margin-top:10px;
	}
.close {
	cursor:pointer;
	position:absolute;
	top:0;
	right:0;
	margin:-10px -10px 0 0;
}
.popupcontent{
	color:#333;
}
.fieldcontent{
	text-align:left;
	margin-bottom:10px;
}
.getscore {
	display:none;
}
#campain {
	border:1px solid #b9d996;
	padding:2%;
	overflow:hidden;
	background:#fff;
}
#campain h2 {
	margin:10px 0;
	color:#333;
}
#campain h2 img {
	display:inline-block;
}
#campain h2 span {
	display:inline-block;
	vertical-align:top;
}
.jq_worldcup {
	cursor:pointer;
	border:1px solid #b9d996;
	background:-webkit-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: -o-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: -ms-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	background: -moz-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(221, 245, 221, 1) 100%);
	width:45%;
	margin:0 3% 10px 0;
	float:left;
	line-height:15px;
	padding-left:3px;
	color:#333;
	vertical-align:top;
}
.jq_worldcup:hover {
	background:-webkit-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: -o-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: -ms-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
	background: -moz-linear-gradient(top, rgba(255, 255, 255, 1) 0%, rgba(255, 243, 217, 1) 100%);
}
.jq_worldcup span {
	display:inline-block;
	vertical-align:middle;
}
#introduce{
	border:1px solid #ddd;
	background:#f5f5f5;
	color:#333;
	padding:2px;
	}
#loading{
	background:#ddd url(<c:url value="/resources/image/worldcup/loaderc.gif"/>) center center no-repeat;
	display:none;
	position:absolute;
	z-index:9999;
	top:0%;
	filter:alpha(opacity=50);
	-moz-opacity:0.5;
	-khtml-opacity: 0.5;
	opacity: 0.5;
	max-width:650px;
	}
@media (max-width:600px) {
 .content {
 background:url(<c:url value="/resources/image/worldcup/blackbord_mobile.png"/>) top center no-repeat;
 min-height:420px;
}
 .content h1 {
 margin:80px 0 10px 0;
}
 hr {
 width:350px;
}
 .teaminfo img {
 width:70%;
}
 .teaminfo {
 width:140px;
}
 #tab-content {
 padding-left:15%;
}
 .time {
 line-height:70px;
 padding:0;
}
.checkresult {
 margin-top:0;
}
.time{
	line-height:30px;
	}
}
 @media (max-width:525px) {
 #tab-content {
 padding-left:12%;
}
.time p{
	font-size:.9em;
	}
}
 @media (max-width:450px) {
 #tab-content {
 padding-left:8%;
}
.time p{
	font-size:.9em;
	}
}
 @media (max-width:417px) {
 #tab-content {
 padding-left:4%;
}
 .teaminfo {
 width:130px;
}
.time p{
	font-size:.9em;
	}
}
 @media(max-width:381px) {
 .content {
 background:url(<c:url value="/resources/image/worldcup/blackbord_xs.png"/>) top center no-repeat;
 min-height:400px;
}
 .teaminfo {
 width:120px;
}
 hr {
 width:280px;
}
.checkresult {
 margin-top:60px;
}
.time p{
	font-size:.9em;
	}
}
@media (max-width:358px) {
 .teaminfo {
 width:110px;
}
#tab-content {
 padding-left:1%;
}
 .time {
 line-height:30px;
}
.time p{
	font-size:.8em;
	}
}
}

#sidebar-tab {
	margin-bottom:1.5em;
	overflow:hidden;
}
#tab-title h3 {
	font-weight:400;
	margin:10px 0;
	font-size:1em;
}
#tab-title .selected {
	border-bottom:0px;
} /*标题被选中时的样式*/
#tab-title span {
	padding:5px 9px 5px 10px;
	border-right:0px;
	margin-left:-1px;
	cursor:pointer;
}
#tab-content .hide {
	display:none;
} /*默认让第一块内容显示，其余隐藏*/
#tab-content ul {
	padding:5px 10px;
	overflow:hidden;
}
#tab-content ul li {
	padding-top:5px;
	float:left;
}

</style>
</head>

    <body>
    <div data-role="page" class="background">
      <div class="content">
        <h1>可竞猜赛事</h1>
        <hr/>
        <div id="sidebar-tab">
        	<div id="tab-title">
        	<h3>
        	<c:forEach items="${matchs}" var="match" varStatus="status">
       			<span class="${ status.index == 0 ? 'selected' : ''}">
       				${match.team1Name} vs ${match.team2Name}
       			</span>
        	</c:forEach>
        	</h3>
          </div>
          
          <div id="tab-content">
          	<c:forEach items="${matchs}" var="match" varStatus="status">
          		<ul class="${ status.index > 0 ? 'hide' : ''}">
          			<li>
          				<div class="teaminfo"><img src="<c:url value="/resources/image/worldcup/${match.team1Flag}"/>"/>
          					<p>${match.team1Name}</p>
          					<button data-match-id="${match.id}" data-bet="1">胜</button>
                		</div>
                	</li>
                	<li class="time">
                	<p>${match.matchTime}</p>
					<p>${match.location }</p>
					</li>
          			<li>
          				<div class="teaminfo"><img src="<c:url value="/resources/image/worldcup/${match.team2Flag}"/>"/>
          					<p>${match.team2Name}</p>
          					<button data-match-id="${match.id}" data-bet="2">胜</button>
                		</div>
                	</li>                	
          		</ul>
          	</c:forEach>
          </div>
            
        </div>
       <div class="checkresult"><a href="<c:url value="/campaign/worldcup-bet-list"/>">查看我的投注</a></div>
        <div class="popupcontent">
          <h2>投注单
            <div class="close"><img src="<c:url value="/resources/image/worldcup/close.png"/>"/></div>
          </h2>
          <div class="fieldcontent enablescore">
          	您当前可用积分: <span id="availablePoints">${availablePoints}</span>
          </div>
          <form id="scoreForm">
	          <div class="fieldcontent">
	            <label>请输入积分:</label>
	            <input id="score" type="number" value="" class="required" />
	          </div>
          </form>
          <div class="fieldcontent getscore"> 如果您竞猜成功可获得积分: <span></span></div>
          <div class="fieldcontent error"></div>
          <button class="submit">购买</button>
        </div>
	 <div class="recheck">
        <p class="message">您的操作已完成</p>
        <button class="closerecheck">关闭</button>
        </div>
      </div>
      <div id="campain">
        <h2><img src="<c:url value="/resources/image/worldcup/cup.png"/>"/></h2>
        <c:forEach items="${teams}" var="team">
        	<div class="jq_worldcup" data-team-id="${team.id}"> <span><img src="<c:url value="/resources/image/worldcup/tinylogo/${team.flag}"/>" /></span> <span>${team.name}</span> </div>
        </c:forEach>
      </div>
      <div id="introduce">
        <h3>活动介绍:</h3>
        <ol>
          <li>竞猜16强活动，每天竞猜在当天23:59分截止投注积分。</li>
          <li>竞猜冠军队活动，在7月13日23:59分前截止投注积分。</li>
          <li>竞猜冠军队活动，每人最多参加3次。</li>
          <li>当天比赛获胜积分将在当天10点~12点进行积分。</li>
        </ol>
      </div>
      <div id="loading"></div>
    </div>
    <script type="text/javascript" src="<c:url value="/resources/script/jquery.validate.min.js"/>"></script>
    <script>
    	var betType = 1;
    	var matchId;
    	var teamId;
    	var bet;
		var matchUrl = "<c:url value='/campaign/worldcup-bet-match'/>";
		var teamUrl = "<c:url value='/campaign/worldcup-bet-team'/>";
		var token = "${token}";
    	
    	$(document).ready(function(){
			
			$('#tab-title span').click(function(){ 
				$(this).addClass("selected").siblings().removeClass(); 
				$("#tab-content > ul").hide().eq($('#tab-title span').index(this)).show(); 
			}); 
			 
			$(".teaminfo button").click(function(){
				matchId = $(this).attr('data-match-id');
				bet = $(this).attr('data-bet');
				showBetDialog(1);
				$("#scoreForm").validate();
			});
			
		  	$(".close").click(function(){
				$(".popupcontent").hide();
			});
		  
			$(".closerecheck").click(function(){
				$(".recheck").hide();
			});
		
			$(".jq_worldcup").click(function(){
				teamId = $(this).attr('data-team-id');
				showBetDialog(2);
			});
			
			$(".submit").click(function(){
				if($("#scoreForm").valid()){
					var stake = $('#score').val();
					var url = betType == 1 ? matchUrl : teamUrl;
					showBg();
					$.getJSON(url, {matchId:matchId, bet:bet, stake:stake, token:token, teamId: teamId}, function(data){
						$(".popupcontent").hide();
						closeBg();
						if(data.code == 1){
							$('.recheck .message').html("投注成功");
							$('#availablePoints').html(data.message);
						}else if(data.code == 3){
							$('.recheck .message').html("您的积分不够");
						}else if(data.code == 4){
							$('.recheck .message').html("已到竞猜截止时间");
						}else if(data.code == 5){
							$('.recheck .message').html("竞猜冠军不可超过三次");
						}
						token = data.data;
						
						showDivOnTheMiddle(".recheck");
					});
				}
			});
			
			function showBg() {
			    var bh = $("body").height();
			    var bw = $("body").width();
			    $("#loading").css({
			        height:bh,
			        width:bw,
			        display:"block"
			    });
			    $("#loading").show();
			}
			//关闭灰色 jQuery 遮罩
			function closeBg() {
			    $("#loading").hide();
			}
			$("#score").keyup(function(){
				showBg();
				var score=$(this).val();
				if(!isNaN(score)){
					 $.getJSON("<c:url value='/campaign/getOdds'/>", {betType:betType},function(odds){
						$(".getscore").children("span").text(score*odds);
						$(".getscore").show();
						closeBg();
						$(".error").hide();
					});
				}
			});
			
			function showBetDialog(type){
				betType = type;
				$("#score").val('');
				$(".getscore").children("span").empty();
				$(".getscore").hide();
				$(".error").empty();
				$(".error").hide();
				showDivOnTheMiddle(".popupcontent");
			}
		});
	
		function showDivOnTheMiddle(selector){
			var scrollHeight = $(document).scrollTop(),
			windowHeight = $(window).height(),
			windowWidth = $(window).width(),
			popupHeight = $(selector).height(),
			popupWeight = $(selector).width();
			posiTop = (windowHeight - popupHeight)/2 + scrollHeight;
			posiLeft = (windowWidth - popupWeight)/2;
			$(selector).css({"left": posiLeft + "px","top":posiTop + "px","display":"block"});
		}
		
		var dataForWeixin={
			appId:'',
		   	img:'http://220.248.19.21/wechat/resources/image/brazil.jpg',
		   	url: 'http://220.248.19.21/wechat/campaign/worldcup',
		   	title:"竞猜世界杯赢积分",
		   	desc:"登录商业保理微信号，猜比赛获胜队伍和冠军球队，赢取积分，可兑换手机话费和优惠券。",
		   	callback:function(){
				$.getJSON("<c:url value='/campaign/shareCampaign'/>", {userId:'${userId}', campaignId:2}, function(data){
					if(data == 1){
						$('.recheck .message').html("感谢分享，您获得了50积分！");
					}else{
						$('.recheck .message').html("感谢您的分享！");
					}
					showDivOnTheMiddle(".recheck");
				});
			}
		};

		(function(){
			var onBridgeReady=function(){
				WeixinJSBridge.on('menu:share:appmessage', function(argv){
					WeixinJSBridge.invoke('sendAppMessage',{
						"appid":		dataForWeixin.appId,
						"img_url":		dataForWeixin.img,
						"img_width":	"120",
						"img_height":	"120",
						"link":				dataForWeixin.url,
						"desc":				dataForWeixin.desc,
						"title":			dataForWeixin.title
					}, function(res){dataForWeixin.callback();});
				});
				// 分享到朋友圈;
				WeixinJSBridge.on('menu:share:timeline', function(argv){
					WeixinJSBridge.invoke('shareTimeline',{
					"img_url":dataForWeixin.img,
					"img_width":"120",
					"img_height":"120",
					"link":dataForWeixin.url,
					"desc":dataForWeixin.desc,
					"title":dataForWeixin.title
					}, function(res){dataForWeixin.callback();});
				});
			   WeixinJSBridge.call('hideToolbar');
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

