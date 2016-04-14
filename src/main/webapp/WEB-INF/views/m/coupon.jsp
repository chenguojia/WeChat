<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
</head>
<body>
<div data-role="page" id="point-level" style="overflow-y:hidden;">
    <div data-role="header" data-position="fixed" data-theme="b" id="header">
        <h1>我的优惠券</h1>
        <a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back' data-icon="home" data-ajax="false">主页</a>
    </div>
    <div data-role="content" class="field">

        <div data-role="fieldcontain">
            <label style="width:100%">优惠券:</label>

            <div class="exchange" id="rebateCoupons">
                <c:if test="${fn:length(coupons) < 1}">无</c:if>
                <c:forEach items="${coupons}" var="coupon">
                    <p class="coupon-p">
                        <a href="<c:url value="/m/showApply"/> "><img src="<c:url value="/resources/image/coupons/${coupon.name}.jpg"/>"/></a>
                    </p>
                </c:forEach>
            </div>
        </div>

        <div data-role="fieldcontain">
            <p class="helpcheck"><a id="right4" href="#integrate">优惠券使用说明</a></p>
        </div>
    </div>

    <div data-role="footer" data-position="fixed" data-theme="c">
        <div data-role="navbar" data-iconpos="left">
            <ul>
                <li><a data-transition="none" href="<c:url value="/"/>" class="ui-btn-icon-left ui-icon-back"  data-ajax="false">返回</a></li>
                <li><a data-transition="none" href="<c:url value="/help/list"/>" data-icon="info">发现</a></li>
            </ul>
        </div>
    </div>
    <!--优惠券使用说明-->
    <div data-role="panel" id="integrate" data-theme="b" data-position="right">
        <div class=" ui-panel-inner">
            <div class="activity"><h3>优惠券使用说明:</h3>
                <ol class="process">
                    <li>被转介绍的商户认证成功后获得50元优惠券</li>
                    <li>被转介绍的商户成功放款一笔后获得200元优惠券</li>
                    <li>每个商户每笔融资使用的优惠券总金额额相加不能超过200元</li>
                    <li>由于商户原因导致优惠券无法正常使用时，该优惠券不能再次使用</li>
                    <li>已使用的优惠券不能进行更改</li>
                </ol>
            </div>
            <a href="#right4" data-rel="close" data-role="button" data-icon="delete" data-inline="true"
               data-corners="true">关闭</a>
        </div>
    </div>

    <script type="text/javascript">

    </script>

</div>
</body>
</html>