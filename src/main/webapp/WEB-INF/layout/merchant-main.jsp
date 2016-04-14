<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<title><decorator:title default="卡得万利" /></title>
    <%--jquery library--%>
    <script type="text/javascript" src="<c:url value='/resources/script/jquery-1.9.1.min.js'/>"></script>
	<!-- bootstrap-->
	<link rel="stylesheet" href="<c:url value="/resources/newm/lib/bootstrap/css/bootstrap.min.css"/>">
	<!--framework7 css & js-->
	<link rel="stylesheet" href="<c:url value="/resources/newm/lib/framework7/css/framework7.css"/>">
	<script type="text/javascript" src="<c:url value="/resources/newm/lib/framework7/js/framework7.js"/>"></script>

    <%--压缩图片--%>
    <script type="text/javascript" src="<c:url value="/resources/newm/lib/localResizeIMG3/lrz.mobile.min.js"/>"></script>

    <%--基于bootstrap datetime picker--%>
    <script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/css/bootstrap-datetimepicker.min.css"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/js/bootstrap-datetimepicker.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/script/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"/>"></script>
    <%--系统一些js--%>
	<script type="text/javascript" src="<c:url value="/resources/script/jquery.validate.min.js"/>"></script>

    <%--main css & js--%>
    <link rel="stylesheet" href="<c:url value='/resources/newm/css/wechat.css'/>">
    <script type="text/javascript" src="<c:url value='/resources/script/wechat.js'/>"></script>
    <%--ajax提交form--%>
	<script type="text/javascript" src="<c:url value="/resources/script/ajaxfileupload.js"/>"></script>

	<script type="text/javascript">
		<%--var contextPath = '<c:url value="/"/>';--%>
		//var contextPath = '/webak/';
		var contextPath='<c:url value="/"/>';
	</script>

	<decorator:head />
</head>
<body>
<decorator:body />

<!-- 全局js-->
<script type="text/javascript" src="<c:url value="/resources/newm/js/wechat.js"/>"></script>

</body>
</html>






