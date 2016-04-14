<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="new-sales">
		<div data-role="header" data-theme="b">
			<h1>添加小伙伴</h1>
		</div>
		<div data-role="content">
			<form:form action="save" method="post" modelAttribute="dto">
				<div data-role="fieldcontain">
					<label for="name">姓名：</label> 
					<form:input path="name" placeholder="例：李晓明"/>
				 	<form:errors path="name" class="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="mobile">手机号：</label> 
					<form:input path="mobile" placeholder="例：13845678989"/>
					<form:errors path="mobile" class="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="branchCode">分支机构：</label> 
					<form:select path="branchCode" >
						<form:option value="" label="--- 请选择 ---"/>
   						<form:options items="${branches}" itemValue="value" itemLabel="label"/>
					</form:select>
					<form:errors path="branchCode" class="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="regionCode">地市编码：</label> 
					<form:select path="regionCode" >
						<form:option value="" label="--- 请选择 ---"/>
						<form:options items="${regions}" itemValue="value" itemLabel="label"/>
					</form:select>
					<form:errors path="regionCode" class="error"/>
				</div>
				
				
				<!-- 表示内部员工显示分类，其他不显示 -->
				<c:if test="${fn:length(processorIds) > 1}">
					<div data-role="fieldcontain">
						<label for="processorId">所属机构：</label> 
						<form:select path="processorId" >
							<form:option value="" label="--- 请选择 ---"/>
							<form:options items="${processorIds}" itemValue="value" itemLabel="name"/>
						</form:select>
						<form:errors path="processorId" class="error"/>
					</div>
				</c:if>
				
				<!-- 表示不为内部员工，默认带出当前值 -->
				<c:if test="${fn:length(processorIds) < 2}">
					<c:forEach items="${processorIds}" var="processorItem">
						<input type="hidden" name="processorId" id="processorId" value="${processorItem.value }"/>
					</c:forEach>
				</c:if>
				
				<input type="submit" id="submitButton" data-theme="b" value="确认" />
			</form:form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="<c:url value="/sales/account"/>"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			$("#new-sales").on('pageinit', function(){
				refreshRegionByBranch();
			});
		</script>			
	</div>
</body>
</html>