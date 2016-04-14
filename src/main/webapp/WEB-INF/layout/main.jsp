<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %> 
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title><decorator:title default="卡得万利" /></title>  	
	<link rel="stylesheet" href="<c:url value="/resources/css/jquery.mobile-1.4.2.min.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/css/jquery.mobile.theme-1.4.2.min.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/css/wechat.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/css/jqm-datebox.min.css"/>" />
	<script type="text/javascript" src="<c:url value="/resources/script/jquery.js"/>"></script>
	<!--  <script type="text/javascript" src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script> -->
	<script type="text/javascript" src="<c:url value="/resources/script/jquery.mobile-1.4.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/script/jquery.validate.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/script/jqm-datebox.core.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/script/jqm-datebox.mode.calbox.min.js"/>"></script>
	<%--基于bootstrap datetime picker--%>
    <script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/css/bootstrap-datetimepicker.min.css"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/js/bootstrap-datetimepicker.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"/>"></script>

	<script type="text/javascript" src="<c:url value="/resources/script/jquery.mobile.datebox.i18n.zh-CN.utf8.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/script/jquery.mobile.pagination.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/script/wechat.js"/>"></script>
	

	<script type="text/javascript">
		var contextPath = '<c:url value="/"/>';
	</script>
	<decorator:head />  
</head>
<body>
	<decorator:body />

	<script type="text/javascript">
		var contextPath = '<c:url value="/"/>';
	</script>
</body>
</html>