<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>	
</head>
<body>
	<div data-role="page" id="leads-list-${uuid}">
      	<div data-role="header" data-position="fixed" data-theme="b">
        	<h1>线索列表</h1>
 			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back' data-icon="home">主页</a>      
      	</div>
		<div data-role="content">
			<c:if test="${fn:length(result.payload) > 0}">
			<div class="pagigationpart">第 <span>${result.pageNumber}</span> 页, 共  <span>${result.pageCount}</span> 页</div>
			<ul data-role="listview" data-inset="true" id="leadsList">
				<c:forEach var="item" items="${result.payload}">
					<li>
						<a href="<c:url value='/leads/detail?id=${item.id}&status=${status}'/>" >
							<h5>线索编号：${item.number}</h5>
							<p>
								商户编号：${item.merchantNumber}
							</p>
							<c:if test="${!empty item.subCode && item.subCode != ''}"><p>分店号：${item.subCode}</p></c:if>

							<p>商户名称：${item.merchantName}</p>

							<c:if test="${!empty item.pqFundedAmount && item.pqFundedAmount != ''}"><p>授信额度：${item.pqFundedAmount}</p></c:if>

							<c:if test="${item.status == 3}">
								<span class="extra">
									${item.merchantIntentionLabel}
								</span>
							</c:if>
							<c:if test="${item.updated == 1}">
								<span class="ui-li-count ui-btn-up-f ui-btn-corner-all ui-li-count-update">&nbsp;&nbsp;</span>
							</c:if>
						</a>
					</li>
				</c:forEach>
			</ul>
			<div class="pagigationpart">第 <span>${result.pageNumber}</span> 页, 共  <span>${result.pageCount}</span> 页</div>
			<div id="pagination-div">
				<c:if test="${result.pageNumber > 1}">
				<button class="ui-btn ui-btn-inline ui-btn-icon-left ui-shadow ui-corner-all ui-icon-arrow-l " data-page="${result.pageNumber-1}">上一页</button>
				</c:if>
				<c:if test="${result.pageNumber < result.pageCount}">
				<button  class="ui-btn ui-btn-inline ui-btn-icon-right ui-shadow ui-corner-all ui-icon-arrow-r floatright" data-page="${result.pageNumber+1}">下一页</button>
				</c:if>
			</div>
			</c:if>
			<c:if test="${fn:length(result.payload) == 0}">
				<span>无相关记录</span>
			</c:if>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
	        <div data-role="navbar" data-iconpos="left" >
	          <ul>
	            <li><a href='<c:url value="/leads/status"/>' class="ui-btn-icon-left ui-icon-back">返回</a></li>
	            <li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
	          </ul>
	        </div>
    	</div>
		<script type="text/javascript">
		$("#leads-list-${uuid}").on('pageinit', function(){
			var url = '<c:url value="/leads/list"/>' + "?pageSize=10&status=${status}";
			$("#pagination-div button").on("click", function(){
				$.mobile.changePage(url + "&pageNumber=" + $(this).attr("data-page"));
			});
		});
		</script>
    </div>
	</body>
</html>