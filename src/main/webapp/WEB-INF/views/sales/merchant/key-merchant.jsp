<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="key-merchant-${uuid}">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>白名单商户</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back' data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<div class="search">
				<!-- 表示内部员工显示分类，其他不显示 -->
				<c:if test="${fn:length(processorIds) > 1}">
					<select id="processorId" name="processorId">
						<c:forEach items="${processorIds}" var="processorItem">
								<option value="${processorItem.value }" <c:if test="${processorId == processorItem.value }">selected="selected" </c:if> >${processorItem.value == 331 ? '全部' : processorItem.name }</option>    
						</c:forEach>
					</select>
				</c:if>
				
				<!-- 表示不为内部员工，默认带出当前值 -->
				<c:if test="${fn:length(processorIds) < 2}">
					<c:forEach items="${processorIds}" var="processorItem">
						<input type="hidden" name="processorId" id="processorId" value="${processorItem.value }"/>
					</c:forEach>
				</c:if>
				
				<input id="name-${uuid}" name="name" type="text" class="searchtxt" placeholder="输入商户编号，商户名称或街道查询白名单商户..." value="${name}"/>
				<input type="image" class="go" id="search-button-${uuid}" src="<c:url value='/resources/image/search.png'/>" width="34" height="34" id="go" alt="Search" /> 
			</div>
			
			<c:if test="${fn:length(result.payload) > 0}">
			<div class="pagigationpart">第 <span>${result.pageNumber}</span> 页, 共  <span>${result.pageCount}</span> 页</div>
			<ul data-role="listview" data-inset="true" class="recommend">
				<c:forEach items="${result.payload}" var="item">
					<li><a href="<c:url value="/merchant/search?number=${item.mid}"/>">
						<p class="status">${item.statusLabel}</p>
						<h4>${item.merchantName}</h4>
						<p>${item.province}-${item.prefecture} ${item.address}</p>
						<p>${item.mid}</p>
					</a></li>
				</c:forEach>
			</ul>
			<div class="pagigationpart">第 <span>${result.pageNumber}</span> 页, 共  <span>${result.pageCount}</span> 页</div>
			<div id="pagination-div">
				<c:if test="${result.pageNumber > 1}">
				<button  class="ui-btn ui-btn-inline ui-btn-icon-left ui-shadow ui-corner-all ui-icon-arrow-l floatleft" data-page="${result.pageNumber-1}">上一页</button>
				</c:if>
				<c:if test="${result.pageNumber < result.pageCount}">
				<button class="ui-btn ui-btn-inline ui-btn-icon-right ui-shadow ui-corner-all ui-icon-arrow-r floatright" data-page="${result.pageNumber+1}">下一页</button>
				</c:if>
			</div>
			</c:if>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" data-rel="back" href="#" class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a data-transition="none" href="<c:url value='/help/list'/>" data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
		$("#key-merchant-${uuid}").on('pageinit', function(){
			var url = '<c:url value="/sales/keyMerchantList"/>' + "?pageSize=20";
			var urlWithParam = url;
			if($("#name-${uuid}").val()){
				urlWithParam = urlWithParam + "&name=" + $("#name-${uuid}").val();
			}
			$("#pagination-div button").on("click", function(){
				$.mobile.changePage(encodeURI(urlWithParam + "&pageNumber=" + $(this).attr("data-page")));
			});
			$("#search-button-${uuid}").on("click", function(){
				var processorId = '';
				if($("#processorId").size() > 0){
					processorId = $("#processorId").val();
				}
				$.mobile.changePage(encodeURI(url + "&name=" + $("#name-${uuid}").val() + "&processorId=" + processorId), "pop", false, false);
			});
		});
		</script>
	</div>
</body>
</html>
