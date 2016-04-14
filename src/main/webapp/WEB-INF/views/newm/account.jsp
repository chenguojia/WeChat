<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
    <!-- Views-->
    <div class="views">
        <!-- Your main view, should have "view-main" class-->
        <div class="view view-main">
            <!-- Top Navbar-->
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="center sliding">我的账户</div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="index" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content">
                        <div class="list-block media-list account-color" style="margin-top:7px;">
                            <a href="<c:url value='/new/m/userInfo/show'/>" class="item-link">
                                <ul>
                                    <li>
                                        <div class="item-content my-account-new">
                                            <div class="item-media myaccount-pic-new"></div>
                                            <div class="item-inner myaccount-txt">
                                                <div class="item-title-row" style="display:block;">
                                                    <div class="item-title"><span class="account-txt">${!empty login_new_merchant.ownerName ? login_new_merchant.ownerName : '亲爱的用户'}，欢迎你！</span></div>
                                                    <div class="item-title"><span>手机：${!empty login_new_merchant.mobilePhone ? login_new_merchant.mobilePhone : '***********'}</span></div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </a>
                        </div>
                        <div class="list-block media-list myaccount ">
                            <ul>
                                <%--<li>--%>
                                    <%--<a href="#" class="item-link item-content">--%>
                                        <%--<div class="item-media"><span class="glyphicon glyphicon-tag wechat-icon-coupon"></span></div>--%>
                                        <%--<div class="item-inner">--%>
                                            <%--<div class="item-title-row">--%>
                                                <%--<div class="item-title">我的优惠券</div>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#" class="item-link item-content">--%>
                                        <%--<div class="item-media"><span class="glyphicon glyphicon-heart wechat-icon-campaign"></span></div>--%>
                                        <%--<div class="item-inner">--%>
                                            <%--<div class="item-title-row">--%>
                                                <%--<div class="item-title">最新活动</div>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <li>
                                    <a href="###" class="item-link item-content" id="refundBtn">
                                        <div class="item-media"><span class="glyphicon glyphicon-list-alt wechat-icon-file"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">我的账单</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="toolbar tabbar tabbar-labels">
                <div class="toolbar-inner">
                    <a href="<c:url value='/new/m/home'/>" class="tab-link">
                        <i class="icon money-icon"></i>
                        <span class="tabbar-label">融资</span>
                    </a>
                    <a href="<c:url value='/new/m/account'/>" class="tab-link active">
                        <i class="icon account-icon">  </i>
                        <span class="tabbar-label">账户</span>
                    </a>
                    <a href="<c:url value='/new/m/more'/>" class="tab-link">
                        <i class="icon more-icon"></i>
                        <span class="tabbar-label">更多</span>
                    </a>
                </div>
            </div>
        </div>
    </div>

<script>

    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    $("#refundBtn").click(function(){
        if ("${!empty applicationModel.cashadvanceStatus && applicationModel.cashadvanceStatus == '还款清算'}" == "true") {
            location.href = "<c:url value='/new/m/refundDetail?baoliId=${item.cashadvanceId}'/>";
        } else {
            myApp.alert('您当前没有对账相关信息!!','提示');
        }
    });

</script>

</body>
</html>
