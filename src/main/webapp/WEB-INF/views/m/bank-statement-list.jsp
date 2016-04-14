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
			<h1>对账单列表</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home"  data-ajax="false">主页</a>
		</div>
		<div data-role="content">
			<c:if test="${fn:length(exchangerResultModel.footer) > 0}">
			</c:if>

			<c:if test="${fn:length(exchangerResultModel.rows) > 0}">
			<h3>明细信息:</h3>
			<ul data-role="listview" data-inset="true">
					<c:forEach var="item" items="${exchangerResultModel.rows}">
							<li><a href="###"  >
									<h5>清算日期：${item.qingsuandate}</h5>
									<p>清算金额：${item.inJine}</p>
									<p>账户管理费：${item.cvFee}</p>
									<p>实还日期：${item.posRepaymentDate}</p>
									<p>实还金额：${item.huankuan}</p>
									<p>卡得万利付款：${item.paymentAmt}</p>
									<%-- <span class="extra">
										${item.qingsuandate}
									</span> --%>
							</a></li>
					</c:forEach>
					
					<div class="pagigationpart">第 <span>${pageNumber}</span> 页, 共  <span>${pageCount}</span> 页</div>
					
					<div id="pagination-div">
						<c:if test="${pageNumber > 1}">
						<button  class="ui-btn ui-btn-inline ui-btn-icon-left ui-shadow ui-corner-all ui-icon-arrow-l floatleft" data-page="${pageNumber-1}">上一页</button>
						</c:if>
						<c:if test="${pageNumber < pageCount}">
						<button class="ui-btn ui-btn-inline ui-btn-icon-right ui-shadow ui-corner-all ui-icon-arrow-r floatright" data-page="${pageNumber+1}">下一页</button>
						</c:if>
					</div>
			</ul>
			</c:if>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/m/bankStatementSearch"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript">
			var url = '<c:url value="/m/bankStatementList"/>' + "?beginDate=${beginDate}&endDate=${endDate}&baoliId=${baoliId}&pageSize=20";
			var urlWithParam = url;
			
			$("#pagination-div button").on("click", function(){
				$.mobile.changePage(encodeURI(urlWithParam + "&pageNumber=" + $(this).attr("data-page")), "pop", false, false); 
			});
		</script>
	</div>
</body>
</html>