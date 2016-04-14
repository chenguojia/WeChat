<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="task-status">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>商户任务列表</h1>
			 <a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="请输入搜索条件...">
				<c:if test="${fn:length(result.payload) > 0}">
					<div class="pagigationpart">第 <span>${result.pageNumber}</span> 页, 共  <span>${result.pageCount}</span> 页</div>
					
					<c:forEach var="item" items="${result.payload}">
							<li><a href="<c:url value='/task/detail?id=${item.id}&group=${group}'/>"  >
									<h5 class="<c:if test='${item.urgentDegree > 1}'>urgent</c:if>">任务编号：${item.number}</h5>
									<p>商户编号：${item.merchantNumber}</p>
									<p>商户名称：${item.merchantName }</p>
									<p>授信额度：${item.pqFundedAmount }</p>
									<%--<if test="${item.statusLabel == '待补件' && !empty item.rfe && (fn:length(item.rfe) > 0)}">--%>
										<%--<p>--%>
										<%--需补件列表:--%>
											<%--<c:forEach var="file" items="${item.rfe}">--%>
												<%--${file['title']}&nbsp;&nbsp;--%>
											<%--</c:forEach>--%>
										<%--</p>--%>
									<%--</if>--%>
									<span class="extra">
										${item.statusLabel}
									</span>
							</a></li>
					</c:forEach>
					
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
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/task/listGroups"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript">
			var url = '<c:url value="/task/list"/>' + "?group=${group}&pageSize=20";
			var urlWithParam = url;
			
			$("#pagination-div button").on("click", function(){
				$.mobile.changePage(encodeURI(urlWithParam + "&pageNumber=" + $(this).attr("data-page")));
			});
			$("#search-button-${uuid}").on("click", function(){
				$.mobile.changePage(encodeURI(url + "&name=" + $("#name-${uuid}").val()));
			});
		</script>
	</div>
</body>
</html>