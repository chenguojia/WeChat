<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="show-qrcode">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>添加商户</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home" data-ajax="false">主页</a>
		</div>
		<div data-role="content">
			<p><img alt="二维码" src="${url}" class="eighty-percent-width"/></p>
			<p>*商户可以通过微信中的扫一扫功能扫描您的二维码关注卡得万利服务号</p>
			<button data-theme="a" class="showdialog">短信添加商户</button>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" data-rel="back" href="#" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>

		<div id="showdialog">
			<form:form id="myfrom" action="/m/sendSmsToMerchant" method="post"  modelAttribute="dto" class="validate">
				<div data-role="fieldcontain" >
					<label for="contactMobile">商户手机号码:</label><form:input type="number" path="contactMobile" class="required mobile" id="contactMobile" value=""/>
				</div>
				<div class="ui-field-contain" id="resultMessage" style="color:red;"></div>
				<div data-role="fieldcontain" >
					<a href="#" id="submit" class="ui-btn ui-corner-all ui-shadow ui-btn-b">发送</a>
					<a href="#" id="cancel" class="ui-btn ui-corner-all ui-shadow">关闭</a>
				</div>
			</form:form>
		</div>
		<div class="overlay"></div>

		<script type="text/javascript">
			$("#show-qrcode").on('pageinit', function(){
				$(".showdialog").click(function(){
					showagree($("#showdialog"));
					$(".overlay").show();
				});
				$("#submit").click(function(){
					$.mobile.loading("show");
					$.post("<c:url value="/m/sendSmsToMerchant"/>", $("#myfrom").serialize(), function(data){
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
					$("#submit").removeClass("ui-disabled");
					$("#resultMessage").html("");
					$("#contactMobile").val("");
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
