<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="task-status">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>授信详情</h1>
			 <a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
		</div>
		<div data-role="content" style="text-align:center">
				<p>我们正在努力为您计算授信额度</p>
				<p>请稍后...</p>
			<div class="circle">     
		     <div class="pie_left">
		     	<div class="left"></div>
		     </div>     
		     <div class="pie_right">
		     	<div class="right"></div>
		     </div>     
		     <div class="mask">
		     	<span></span>
		     </div> 
			</div> 
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/m/myAccount"/>"  class="ui-btn-icon-left ui-icon-back"  data-ajax="false">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
		//速融超时时间(分钟单位)
		var instantCreditTimeout = "${instantCreditTimeout}";
		
		//当前服务器时间
		var str1 = "${currentDate}";
		str1 = str1.replace(/-/g,"/");
		var date1 = new Date(str1);
		
		//获取授信开始时间
		var str2 = "${startCreditDate}";
		str2 = str2.replace(/-/g,"/");
		var date2 = new Date(str2);
		
		//获取时间差，秒数差
		var secondDifference = parseInt((date1.getTime() - date2.getTime())/1000);
		//倒计时*分钟总秒数
		var totalSecond = parseInt(instantCreditTimeout)* 60;
		//倒计时秒数
		var countDownSecond = totalSecond - secondDifference;
		
		//倒计时剩余秒数
		var maxtime = countDownSecond;
		var statictime=totalSecond;//本次进入转圈页面剩余的总秒数
		var timer;
		var each_edg=360/totalSecond;//每一秒走圆圈的多少度°

		countDown(); //页面进入就开始调用一次任务
		checkCreditStatus(); //页面进入就开始调用一次任务
		
		function countDown() {
		    if (maxtime >= 0) {
		        var minus = Math.floor(maxtime / 60);
		        var seconds = Math.floor(maxtime % 60);
		        var msg = minus + ":" + seconds;
		        $(".mask").children("span").text(msg);
		        if (maxtime <= statictime / 2) {
		            $(".pie_right").children(".right").css({
		                'transform': "rotate(180deg)"
		            },
		            {
		                '-webkit-transform': "rotate(180deg)"
		            },
		            {
		                '-ms-transform': "rotate(180deg)"
		            });
		            $(".pie_left").children(".left").css({
		                'transform': "rotate(" + (180 - maxtime * each_edg) + "deg)"
		            },
		            {
		                '-webkit-transform': "rotate(" + (180 - maxtime * each_edg) + "deg)"
		            },
		            {
		                '-ms-transform': "rotate(" + (180 - maxtime * each_edg) + "deg)"
		            });
		        } else {
		            $(".pie_right").children(".right").css({
		                'transform': "rotate(" + (360 - maxtime * each_edg) + "deg)"
		            },
		            {
		                '-webkit-transform': "rotate(" + (360 - maxtime * each_edg) + "deg)"
		            },
		            {
		                '-ms-transform': "rotate(" + (360 - maxtime * each_edg) + "deg)"
		            });
		            $(".pie_left").children(".left").css({
		                'transform': "rotate(0deg)"
		            },
		            {
		                '-webkit-transform': "rotate(0deg)"
		            },
		            {
		                '-ms-transform': "rotate(0deg)"
		            });
		        }; --maxtime;
		    } else {
		        clearInterval(timer);
		        
		     	//表示5分倒计时结束了任然没有获取到授信，停止计时器
				clearInterval(checkcreditstatus);
				//跳转到提示界面
				var url = '<c:url value="/m/getInstantCreditTimeout"/>';
				$.mobile.changePage(encodeURI(url), "pop", false, false); 
		    }
		};
		//倒计时timer
		timer = setInterval("countDown()", 1000);
		

		//循环查询授信接口状态码
		function checkCreditStatus(){
			//定时获取系统返回的授信状态码
			$.getJSON(contextPath + "/m/getCreditStatus", {}, function(data){
				if(data == "1"){
					//表示后台已经处理完成了授信，停止计时器
					clearInterval(checkcreditstatus);
					clearInterval(timer);//转圈定时器关闭
					//直接跳转到授信结果显示界面
					var url = '<c:url value="/m/creditShow"/>';
					$.mobile.changePage(encodeURI(url), "pop", false, false); 
				}else if(data == "2"){
					//表示5分倒计时结束了任然没有获取到授信或者获取错误，停止计时器
					clearInterval(checkcreditstatus);
					clearInterval(timer);//转圈定时器关闭
					//跳转到提示界面
					var url = '<c:url value="/m/getInstantCreditTimeout"/>';
					$.mobile.changePage(encodeURI(url), "pop", false, false); 
				}else{
					//...继续转圈
				}
			});
		}
		
		//定时器，定时调用接口
		var checkcreditstatus = setInterval(checkCreditStatus, 10000);//定时器，10秒一次
		
	</script>
</body>
</html>