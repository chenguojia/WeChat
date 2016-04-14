<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>商户额度信息</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<ul data-role="listview" data-inset="true" class="submitleads">
				<li>
					<a href="<c:url value='/leads/showSubmitWithMerchant?mid=${merchant.mid}'/>" >
					<h6>编号：${merchant.mid}</h6>
					<p>名称：${merchant.merchantName}</p>
					<p>地址：${merchant.address}</p>
					
					<div class="split-line"></div>		
										
					<p>授信额度(三个月)：${merchant.creditLineLabel}</p>
					
					<div class="split-line"></div>
					
					<c:if test="${merchant.creditLine < 10000 }">
						<p><b>*为了能更好的让您享用融资服务，<br>请提升您店铺POS刷卡活跃度。</b></p>
					</c:if>
					<p>*授信额度基于${merchant.refreshMonth}的商户交易流水</p>
					</a>
				</li>
			</ul>
			<a href="<c:url value="/sales/showQrCode?mid=${number}"/>" class="ui-btn ui-corner-all ui-shadow">扫一扫加商户</a>
			<a href="javascript:;" class="ui-btn ui-corner-all ui-shadow showdialog">短信营销商户</a>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href='#' data-rel="back" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<div id="showdialog">
			<form:form id="remoteAddMerchantForm" action="apply" method="post" modelAttribute="dto">
			    <div data-role="fieldcontain" >
					<label for="merchantName">商户联系人姓名:</label><form:input type="text" path="contactName" value=""/>
				</div>
				<div data-role="fieldcontain" >
				    <label for="merchantMobile">商户联系人手机号:</label><form:input type="number" path="contactMobile" value=""/>
				</div>
				<div data-role="fieldcontain" >
					 <label for="contactPosition">商户联系人身份:</label>
	 				<form:select path="contactPosition" >
   						<form:options items="${positions}" itemValue="value" itemLabel="name"/>
					</form:select>		    
				</div>
				<form:hidden path="mid" value="${number}"/>
				<div class="ui-field-contain" id="resultMessage" style="color:red;"></div>
				<div data-role="fieldcontain" >
				    <a href="#" id="submit" class="ui-btn ui-corner-all ui-shadow ui-btn-b">发送</a>
				    <a href="#" id="cancel" class="ui-btn ui-corner-all ui-shadow">关闭</a>
				</div>
			</form:form>
		</div>
		<div class="overlay"></div>
		<script type="text/javascript">
		$("#task-detail").on('pageinit', function(){
			$(".showdialog").click(function(){
				showagree($("#showdialog"));
				$(".overlay").show();
			});
			$("#submit").click(function(){
				$.mobile.loading("show");
				$.post("<c:url value="/sales/remoteAddMerchant"/>", $("#remoteAddMerchantForm").serialize(), function(data){
					if(data.code == "success"){
						$("#submit").addClass("ui-disabled");
						$("#resultMessage").css("color", "green");
					}
					$("#resultMessage").html(data.message);
					$(".ui-loader h1").html("已完成");
					$.mobile.loading("hide");
				},"json");
			});
			$("#cancel").click(function(){
				$("#showdialog").hide();
				$(".overlay").hide();
			});
		});
		function showagree(obj){
			var _scrollHeight = $(document).scrollTop(),
            _windowHeight = $(window).height(),
            _popupHeight =obj.height(),
			windowWidth = $(window).width(),
			popupWidth = obj.width();
			posiLeft = (windowWidth - popupWidth)/2;
			 _posiTop = (_windowHeight - _popupHeight)/2 + _scrollHeight;
			obj.css({"left": posiLeft + "px","top":_posiTop +"px","display":"block"});
		}
		</script>
	</div>	
</body>
</html>
