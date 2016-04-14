<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/script/jqModal.js"/>"></script>
<script type="text/javascript">
$(document).on('pageshow', function(){
	<c:if test="${not empty imageUrl}">
	$('#pop-image').jqm();
	$('#pop-image').jqmShow();
	$('#pop-image').click(function(){
		$('#pop-image').jqmHide();
	});
	</c:if>
});
</script>
</head>
<body >
	<div data-role="page" id="home" style="background-image: -webkit-radial-gradient(#fff,#376d9b);background-image: radial-gradient(#fff,#376d9b);">
		<div class="ui-title" ><img src="<c:url value='/resources/image/headerlogo.png'/>"/>卡得万利商业保理
		</div>
		<div data-role="content">
		    <div class="search">
				<input id="search-term" name="name" type="text" class="searchtxt" placeholder="输入商户编号，商户名称或街道查询白名单商户..." value="${name}"/>
				<input type="image" id="search-button" src="<c:url value='/resources/image/search.png'/>" width="34" height="34" class="go" alt="Search" />
			</div>
			<ul data-role="none" class="Homepage">
			<li class="new" style="background-color:#bd1d49"><a data-transition="none" href="<c:url value='/sales/myMerchant'/>"><img src="<c:url value="/resources/image/shop.png"/>"  alt="Count" /><span>我的商户<sup>热</sup></span></a></li>
				<li style="background-color:#2a72ea"><a data-transition="none" href="<c:url value='/merchant/criteria'/>"><img src="<c:url value="/resources/image/search.png"/> " alt="Search" /><span>查询额度</span></a></li>
				<!-- <li style="background-color:#ED636e"><a data-transition="none" href="<c:url value='/merchant/calculator'/>"><img src="<c:url value="/resources/image/recommend.png"/>"  alt="Count" /><span>推荐商户</span></a></li> -->
				<li style="background-color:#CC3399">
				<a data-transition="none" href="<c:url value='/posMerchant/list'/>"><img src="<c:url value="/resources/image/POS.png"/>" alt="pos" />
					<span>POS安装</span>
					<c:if test="${posAppCount > 0}">
						<span class="mark">${posAppCount}</span>
					</c:if>
				</a>
				</li>
				<li style="background-color:#63b219"><a data-transition="none" href="<c:url value='/leads/showSubmit'/>"><img src="<c:url value="/resources/image/submit.png"/>" alt="upload" /><span>提交线索</span></a></li>
				<li class="new" style="background-color:#ED636e"><a data-transition="none" href="<c:url value='/leads/showPosInstallation'/>"><img src="<c:url value="/resources/image/load_machine.png"/>" alt="upload" /><span>开业宝<sup>新</sup></span></a></li>
				<li style="background-color:#996633">
					<a data-transition="none" href="<c:url value='/leads/status'/>"><img src="<c:url value="/resources/image/state.png"/>" alt="state" />
						<span>线索状态</span>
						<c:if test="${updatedLeadsCount > 0}">
							<span class="mark">${updatedLeadsCount}</span>
						</c:if>
					</a>
				</li>
				<li style="background-color:#4f33aa"><a data-transition="none" href="<c:url value="/task/listGroups"/>"><img src="<c:url value="/resources/image/addshop.png"/>"  /><span>申请状态</span></a></li>
				<li style="background-color:#10798f"><a data-transition="none" href="<c:url value='/sales/pointAndLevel'/>"><img src="<c:url value="/resources/image/integral.png"/>" /><span>积分专区</span></a></li>
				<li style="background-color:#cf4020">
                    <a data-transition="none" href="<c:url value='/sales/account'/>">
                    <img src="<c:url value="/resources/image/myaccount.png"/>" alt="account"/><span>我的账户</span>
                    </a>
                </li>
			</ul>
			<!--<div class="advertise">
			  <a href="<c:url value='/public/showPicture?pictureName=20140822.gif'/>"><img class="full-width" src="<c:url value='/resources/image/edm/20140822title.gif'/>"/></a>
			</div>-->
			<div class="advertise">
				<c:if test="${user.type == 1 or user.type == 0}">
					<jsp:useBean id="now" class="java.util.Date" />
					<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="currentDate"/>
					<fmt:parseDate value="2015-05-10" pattern="yyyy-MM-dd" var="activeEndDateStr"/>
					<fmt:formatDate value="${activeEndDateStr}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="activeEndDate"/>
					<%--大转盘活动结束--%>
					<c:if test = "${ currentDate >= activeEndDate }">
						<a href="##"><img class="full-width" src="<c:url value='/resources/image/edm/recentCampaign-banner.jpg'/>"/></a>
					</c:if>
					<%--大转盘活动还在继续--%>
					<c:if test = "${ currentDate < activeEndDate }">
						<a data-ajax="false" href="<c:url value='/campaign/rotary'/>"><img class="full-width" src="<c:url value='/resources/image/edm/yl-rotary.png'/>"/></a>
					</c:if>
					<%--<a href="##"><img class="full-width" src="<c:url value='/resources/image/edm/recentCampaign-banner.jpg'/>"/></a>--%>
				</c:if>
				<c:if test="${user.type == 7}">
					<a data-ajax="false" href="<c:url value='/campaign/rotary'/>">
					<img class="full-width" src="<c:url value='/resources/image/campaign/new/yl-rotary.png'/>"/>
					</a>
				</c:if>
				<c:if test="${user.type != 1 and user.type != 0 }">
					<img class="full-width" src="<c:url value='/resources/image/edm/welcome.jpg'/>"/>
				</c:if>
			</div>
			<c:if test="${not empty imageUrl}">
			<div id="pop-image" class="jqmDialog" style="margin-top:30px">
				<img style="width:50%" src="${imageUrl}">
			</div>
			</c:if>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="#" class="ui-btn-active ui-state-persist" data-icon="home">主页</a></li>
					<li><a data-transition="none" href="<c:url value='/help/list'/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			$("#home").on('pageinit', function(){
				var url = '<c:url value="/sales/keyMerchantList"/>' + "?pageSize=20";
				$("#search-button").on("click", function(){
					$.mobile.changePage(encodeURI(url + "&name=" + $("#search-term").val()));
				});
			});


		</script>
	</div>
</body>
</html>