<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="point-level" style="overflow-y:hidden;">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>积分兑换</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back' data-icon="home">主页</a>
		</div>
		<div data-role="content" class="field">
			<input type="hidden" id="token" name="token" value="${token}"/>
			<div data-role="fieldcontain" class="readonly">
				<label for="integral">可用积分:</label><label id="availablePoint" class="highlight">${summary.availablePoint}分</label>
				<a id="right1" class="intro Integration" href="#introduction" >积分说明</a>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="cumulative">累计积分:</label><label id="cumulative">${summary.totalPoint}分</label>
				
			</div>
			<div data-role="fieldcontain" class="readonly stage">
				<label for="grade">我的等级:</label>
				<p id="grade" class="grade_${summary.level}">${summary.levelLabel}</p>
				<a class="intro" id="right1"  href="#rating" >等级说明</a>
			   <div data-role="fieldcontain" style="width:100%">
                   <label></label> <p class="extrainfo"> ${levelMessage}</p>
               </div>				
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="balance">钱包余额:</label><label id="balance">${summary.balance}元</label>
			</div>
			<div data-role="fieldcontain" class="readonly">
				<label for="balance">操作:</label>
				<label for="balance"><a id="${(login_user.type != 0 && login_user.type != 3) == true ? 'withdrawLink' : ''}" href="javascript:void(0);" style="margin-right: 15px;">取现</a>
				<a href="<c:url value="/sales/purseRecord"/>" >明细</a></label>
			</div>
			<div data-role="fieldcontain">
				<label style="width:100%">积分兑换优惠券:</label>
				<div class="exchange" id="rebateCoupons">
					<c:forEach items="${rebateCoupons}" var="coupon">
						<c:set var="flag" value="${coupon.available ? 'enabled' : 'disabled'}"/>
						<p data-type="${coupon.type}" id="${coupon.id}" class="coupon-p ${flag}" data-point="${coupon.costPoint}">
							<img src="<c:url value="/resources/image/coupons/${coupon.name}_${flag}.png"/>" />
						</p>
					</c:forEach>
				</div>
				<div class="exchange" id="mobileCoupons">
					<c:forEach items="${mobileCoupons}" var="coupon">
						<c:set var="flag" value="${coupon.available ? 'enabled' : 'disabled'}"/>
						<p data-type="${coupon.type}" id="${coupon.id}" class="coupon-p ${flag}" data-point="${coupon.costPoint}">
							<img src="<c:url value="/resources/image/coupons/${coupon.name}_${flag}.png"/>" />
						</p>
					</c:forEach>						
				</div>
			</div>
            <div data-role="fieldcontain">
           		<p class="helpcheck"><a data-transition="none" href="<c:url value="/sales/showMyCoupons"/>">我的优惠券<span id="availableCouponCount">${availableCouponCount}</span></a></p>
           		<p class="helpcheck"><a id="right3" href="#act_desc">活动说明</a> | <a id="right4" href="#integrate">优惠券使用说明</a></p>
            </div>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/"/>" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		

	<div data-role="panel" id="introduction" data-theme="b" data-position="right" >
         <div class="activity ui-panel-inner"><h3>积分规则:</h3>
           <table data-role="none" id="tableview" data-mode="reflow" class="ui-responsive table-stroke">
<thead>
 <tr>
       <th data-priority="persist">项目</th>
       <th colspan="1">积分</th>
       </tr>
</thead>
<tbody>
<tr>
<td>提交线索</td>
<td>1分/次<sup>注1*</sup></td>
</tr>
<tr>
<td>授信查询</td>
<td>1分/次<sup>注1*</sup></td>
</tr>
<tr>
<td>添加商户</td>
<td>1分/次<sup>注1*</sup></td>
</tr>
<tr>
<td>微信线索商户<br>放款成功</td>
<td>1000分/笔<sup>注2*</sup></td>
</tr>
</tbody>
</table>
<p>注1:每天每项最高累计积10分</p>
<p>注2:放款成功后进行积分</p>
<a href="#right1" data-rel="close" data-role="button" data-icon="delete" data-inline="true" data-corners="true">关闭</a>
</div>
</div>
 <div data-role="panel" id="rating" data-theme="b" data-position="right" >
<div class=" ui-panel-inner"><h3>积分等级说明:</h3>
<table data-role="table" id="tableview" data-mode="reflow" class="ui-responsive table-stroke">
<thead>
 <tr>
       <th data-priority="persist">积分等级</th>
       <th colspan="1">银粉</th>
       <th colspan="1">金粉</th>
       <th colspan="1">钻石粉</th>
       </tr>
</thead>
<tbody>
<tr>
<td>积分规则</td>
<td>0分-199分（含）</td>
<td>200分-599分（含）</td>
<td>600分（含以上）</td>
</tr>
<tr>
<td>每天登录</td>
<td>2分/天</td>
<td>5分/天</td>
<td>10分/天</td>
</tr>
<tr>
<td colspan="4">登录微信后台每天按积分等级额外赠送对应积分。</td>
</tr>
</tbody>
</table>
<a href="#right2" data-rel="close" data-role="button" data-icon="delete" data-inline="true" data-corners="true">关闭</a>
</div>
	</div>   
    
  <div data-role="panel" id="act_desc" data-theme="b" data-position="right" >
<div class=" ui-panel-inner"><h3>活动说明:</h3>
<div class="activity"><b>活动时间:</b>2014年6月3日~2015年5月31日。</div>
<div class="activity"><b>活动对象:</b>全体商户拓展和维护人员。</div>
<div class="activity"><b>活动形式:</b>登录商业保理微信服务号（微信号：cvbaoli），进行登录、查询、添加线索、商户得到对应积分，积分可以兑换手机话费和优惠券。</div>
<div class="activity"><b>兑换流程:</b>
<ol class="process">
<li>优惠券兑换流程
<ol>
<li>登录商业保理后台</li>
<li>在积分页面兑换相应优惠券</li>
<li>放款成功后，优惠券显示已使用</li>
</ol>
</li>
<li>优惠券使用流程
<ol>
<li>微信后台使用积分兑换优惠券</li>
<li>在办理业务中将优惠券码告知商户</li>
<li>商户在确认书上填写优惠券代码</li>
<li>卡得万利审核优惠券的有效性</li>
<li>正常还款结束后，商户提供使用优惠券金额的发票快递到"上海浦东新区北张家浜路88号C座508室， 市场部收， 联系电话021-60200916"</li>
<li>卡得万利收到发票后打款到商户结算账号。</li>
</ol>
</li>
<li>手机话费兑换流程
<ol>
<li>登录商业保理后台</li>
<li>在积分页面兑换话费，2个工作日内完成充值</li>
</ol>
</li>
</ol>
<p>备注：积分等级是根据累计积分总数计算，积分兑换不影响积分等级的变化。</p>
</div>
<div class="activity">
<b>活动热线:</b> 021-60200916
</div>
<a href="#right3" data-rel="close" data-role="button" data-icon="delete" data-inline="true" data-corners="true">关闭</a>
</div>
	</div>

 <div data-role="panel" id="integrate" data-theme="b" data-position="right" >
<div class=" ui-panel-inner">
<div class="activity"><h3>优惠券使用说明:</h3>
<ol class="process">
<li>每个商户每笔融资只能使用一张优惠券</li>
<li>商户在还款期限内还款成功优惠券才能正常生效</li>
<li>商户在满足使用优惠券条件情况下，需先提供优惠券对应金额的发票快递至上海浦东新区北张家浜路88号C座508室，市场部收，联系电话021-60200916</li>
<li>由于商户原因导致优惠券无法正常使用时，该优惠券不能再次使用</li>
<li>已使用的优惠券不能进行更改</li>
</ol>
</div>
<a href="#right4" data-rel="close" data-role="button" data-icon="delete" data-inline="true" data-corners="true">关闭</a>
</div>
	</div>   
		<div class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" style="max-width:400px;" data-theme="a" data-overlay-theme="a" id="popupDialog" data-role="popup">
			<div class="ui-corner-top ui-header ui-bar-a" data-theme="a" data-role="header" data-role="banner">
				<h1 class="ui-title" data-role="heading" >请确认</h1>
			</div>
			<div class="ui-corner-bottom ui-content" data-role="main">
				<p>请确认兑换</p>
				<a data-theme="b" data-role="button" data-inline="true" id="teleconfirm">确&nbsp;&nbsp;认</a>
				<a data-theme="b" data-role="button" data-inline="true" id="confirmButton" class="confirmButton">确&nbsp;&nbsp;认</a>
				<a data-theme="c" data-rel="back" data-role="button" data-inline="true" >取&nbsp;&nbsp;消</a>
			</div>
		</div>
		  <div class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" style="max-width:400px;" data-theme="a" data-overlay-theme="a" id="confirmBox" data-role="popup">
			<div class="ui-corner-top ui-header ui-bar-a" data-theme="a" data-role="header" data-role="banner">
				<h1 class="ui-title" data-role="heading">请确认充值手机号</h1>
			</div>
			<div class="ui-corner-bottom ui-content" data-role="main">
				<p>您要充值的号码是:<span id="comfirm-content"></span></p>
				<a data-theme="b" data-role="button" data-inline="true" class="confirmButton">确&nbsp;&nbsp;定</a>
				<a data-theme="c" data-rel="back" data-role="button" data-inline="true" >取&nbsp;&nbsp;消</a>
			</div>
		</div>
		<div class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" style="max-width:400px;" data-theme="a" data-overlay-theme="a" id="withdrawBox" data-role="popup">
			<div class="ui-corner-top ui-header ui-bar-a" data-theme="a" data-role="header" data-role="banner">
				<h1 class="ui-title" data-role="heading">确认取现</h1>
			</div>
			<div class="ui-corner-bottom ui-content" data-role="main">
				<p>您的微信号是:<input id="weId" name="weId" value="${weId}" type="text"/></p>
				<small>请提供您的微信号用于发放微信红包，该微信号将是我们发放微信红包的唯一依据，请仔细确认，谢谢。</small>
				<br>
				<a data-theme="b" data-role="button" data-inline="true" class="withdrawButton">确&nbsp;&nbsp;定</a>
				<a data-theme="c" data-rel="back" data-role="button" data-inline="true" >取&nbsp;&nbsp;消</a>
			</div>
		</div>		
		<div class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" style="max-width:400px;min-width:200px;" data-theme="a" data-overlay-theme="a" id="messageBox" data-role="popup">
			<div class="ui-corner-top ui-header ui-bar-a" data-theme="a" data-role="header" data-role="banner">
				<h1 class="ui-title" data-role="heading" id="messageBox-title"></h1>
			</div>
			<div class="ui-corner-bottom ui-content" data-role="main">
				<p id="messageBox-content"></p>
				<a data-theme="b" data-rel="back" data-role="button" data-inline="true" href="#" >确&nbsp;&nbsp;定</a>
			</div>
		</div>		
		<script type="text/javascript">
			$('#point-level').on('pageinit', function(){
				var id = null;
				var type=null;
				var tele=null;
				$('p.enabled').click(function(){
					id = $(this).attr('id');
					type=$(this).attr("data-type");
					$(".popupcontent").remove();
					if(type=='2'){
						$('#popupDialog p').after("<form id='mobileForm' class='popupcontent'><div class='ui-field-contain'><label for='textinput'>请输入你要充值的号码:</label><input type='text' name='textinput' id='textinput' value='' class='required mobile'></div><div class='ui-field-contain'><label for='textinput_again'>请再次输入:</label><input type='text' name='textinput_again' id='textinput_again' value='' equalTo='#textinput'></div><div class='alert' style='color:red'></div></form>");	
						$("#popupDialog #teleconfirm").show();
						$("#popupDialog #confirmButton").hide();
						$('#mobileForm').validate();
					}
					else{
						$("#popupDialog #teleconfirm").hide();
						$("#popupDialog #confirmButton").show();
					}
					//$("#confirmBox").popup('open');
					$('#popupDialog').popup('open');
				});
				$("#withdrawLink").click(function(e){
					if(parseFloat("${summary.balance}") > 0) {
						$('#withdrawBox').popup('open');
					} else {
						$('#messageBox-content').html("您的余额为0，不允许提现操作！");
						$('#messageBox').popup('open');
					}
				});
				$("#teleconfirm").click(function(e){
					if($('#mobileForm').valid()){
						tele=$("#textinput").val();
						$("#comfirm-content").html(tele);
						$.mobile.switchPopup($('#popupDialog'),$('#confirmBox'));
					}
				});
				$(".confirmButton").click(function(){
					$('#confirmBox').popup('close');
					$('#popupDialog').popup('close');
					var token = $('#token').val();
					$.getJSON('<c:url value="/sales/exchangeCoupon"/>',{couponId:id, token:token, mobile:tele}, function(result){
						if(result.resultCode == 1){
							$("#availablePoint").html(result.availablePoint + "分");
							$("#availableCouponCount").html(result.availableCouponCount);
							$('#token').val(result.token);
							$('.coupon-p,.enabled').each(function(i, e){
								var point = $(e).attr('data-point');
								if(point > result.availablePoint){
									$(e).removeClass('enabled');
									$(e).addClass('disabled');
									$(e).children("img").attr('src',function(n, v){
										return v.replace('enabled','disabled');
									});
								}
							});
							$('#messageBox-title').html('');
							
						}
						$('#messageBox-content').html(result.resultMessage);
						$('#messageBox').popup('open');
						
					});
				});
				
				$(".withdrawButton").click(function(){
					$('#withdrawBox').popup('close');
					var token = $('#token').val();
					var weId = $('#weId').val();
					$.getJSON('<c:url value="/sales/withdraw"/>',{token:token, weId:weId}, function(result){
						if(result.code == 1){
							$('#token').val(result.result);
							$('#messageBox-title').html('');
							$("#balance").html("0元");
						}
						$('#messageBox-content').html("操作成功，微信红包很快发送给您！");
						$('#messageBox').popup('open');
						
					});
				});
			});
		</script>
	</div>
</body>
</html>