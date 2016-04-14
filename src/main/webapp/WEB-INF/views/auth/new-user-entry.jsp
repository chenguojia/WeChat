<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>

<body>
	<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>新用户入口</h1>
		</div>
		<div data-role="content" style="text-align: center;vertical-align: middle;">
			<div data-role="fieldcontain">
			    <img style="margin:0 auto;" usemap="#map" src="<c:url value='/resources/image/verification_code.png'/>"/>
			    <map name="map" id="map">
				    <area shape="rect" coords="8,11,277,79" href="<c:url value="/public/merchantValidEntry?code=${code}"/>">
				    <area shape="rect" coords="0,89,277,156" href="<c:url value="/m/register/show"/>">				    
			    </map>
			</div>
			
			<%-- 
			<div data-role="fieldcontain">
				<img style="width:100%" src="<c:url value="/resources/image/first-apply.jpg"/>"/>
			</div> --%>
			
		</div>
	</div>
</body>
</html>
