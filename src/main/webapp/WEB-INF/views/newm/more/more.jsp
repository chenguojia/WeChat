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
                    <div class="center sliding">更多</div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="index" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content">
                        <div class="list-block media-list">
                            <ul>
                                <li>
                                    <a href="<c:url value='/new/m/more/caseShare'/>" class="item-link item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-share wechat-icon-list-alt"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">案例分享</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="<c:url value='/new/m/more/question'/>" class="item-link item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-heart wechat-icon-campaign"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">融资攻略</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="list-block media-list myaccount">
                            <ul>
                                <li>
                                    <a href="<c:url value='/new/m/more/aboutUs'/>" class="item-link item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-home wechat-icon-home"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">公司简介</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="<c:url value='/new/m/more/honor'/>" class="item-link item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-tower wechat-icon-user"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">资质荣誉</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <%--<li>--%>
                                    <%--<a href="<c:url value='/new/m/more/news'/>" class="item-link item-content">--%>
                                        <%--<div class="item-media"><span class="glyphicon glyphicon-file wechat-icon-file"></span></div>--%>
                                        <%--<div class="item-inner">--%>
                                            <%--<div class="item-title-row">--%>
                                                <%--<div class="item-title">新闻中心</div>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <li>
                                    <a href="<c:url value='/new/m/more/contactUs'/>" class="item-link item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-phone-alt wechat-icon-phone-alt"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">联系方式</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <%--<li>--%>
                                    <%--<a href="<c:url value='/new/m/more/comments'/>" class="item-link item-content">--%>
                                        <%--<div class="item-media"><span class="glyphicon glyphicon-info-sign wechat-icon-info"></span></div>--%>
                                        <%--<div class="item-inner">--%>
                                            <%--<div class="item-title-row">--%>
                                                <%--<div class="item-title">意见反馈</div>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
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
                    <a href="<c:url value='/new/m/account'/>" class="tab-link">
                        <i class="icon account-icon">
                        </i>
                        <span class="tabbar-label">账户</span>
                    </a>
                    <a href="<c:url value='/new/m/more'/>" class="tab-link active">
                        <i class="icon more-icon"></i>
                        <span class="tabbar-label">更多</span>
                    </a>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript">
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

</script>

</body>
</html>
