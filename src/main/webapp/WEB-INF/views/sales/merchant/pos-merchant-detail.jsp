<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>

<body>
	<div data-role="page" id="pos-merchant-detail">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>商户信息</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
        <div data-role="content">
            <div data-role="fieldcontain" class="readonly">
              <label>发布日期:</label><label>${merchant.publishDate}</label>
            </div>
            <div data-role="fieldcontain" class="readonly">
              <label>省市:</label><label>${merchant.province}-${merchant.prefecture}</label>
            </div>
            <div data-role="fieldcontain" class="readonly">
              <label>行业:</label><label>${merchant.industry}</label>
            </div>
            <div data-role="fieldcontain" class="readonly">
              <label>商户性质:</label><label>${merchant.businessNature}</label>
            </div>
            <div id="contact_info">
				<div data-role="fieldcontain" class="readonly">
	              <label>联系人:</label><label>${merchant.contactName} ${merchant.contactGender}</label>
	            </div>
	            <div data-role="fieldcontain" class="readonly">
	              <label>联系方式:</label><label>${merchant.contactMobile}</label>
	            </div>
            </div>       
            <div data-role="fieldcontain" class="readonly">
              <button id="claim-button" class="ui-btn ui-corner-all ui-btn-b" data-id="${merchant.id}">领取商户</button>
            </div>
        </div>
     	<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" data-rel="back" href="#" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			var status = parseInt("${merchant.status}");
			$("#pos-merchant-detail").on("pageinit", function(){
				if(status == 1){
					$("#contact_info").hide();
					$("#claim-button").show();
					$("#claim-button").on("click",function(){
						var id = $(this).attr("data-id");
						$.getJSON('<c:url value="/posMerchant/claim"/>',{appId:id},function(result){
							if(result.code == "success"){
								$("#contact_info").show();
								$("#claim-button").hide();
							}
						});
					});
				}else{
					$("#contact_info").show();
					$("#claim-button").hide();
				}
			});
		</script>
	</div>
</body>
</html>
