<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
                    <div class="center sliding">我的店铺</div>
                    <div class="right">
                        <a href="<c:url value='/new/m/addShop/show'/>" class="link ext">
                            <%--暂时只允许添加一个商铺--%>
                            <c:if test="${fn:length(shopModels) <= 1}">
                                <span class="glyphicon glyphicon-plus-sign add-icon"></span>添加店铺
                            </c:if>
                        </a>
                    </div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="index" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content">

                        <%--<div class="list-block media-list shop-list">--%>
                            <%--<ul>--%>
                                <%--<li>--%>
                                    <%--<a href="<c:url value='/new/m/applyStatus'/>" class="item-link item-content">--%>
                                        <%--<div class="item-inner shop-inner">--%>
                                            <%--<div class="item-title-row shop-title-row">--%>
                                                <%--<div class="item-title shop-title">--%>
                                                    <%--<span class="glyphicon home-icon"></span>--%>
                                                    <%--<span class="shop-title-txt">悦诗风吟旗舰店</span>--%>
                                                <%--</div>--%>
                                                <%--<div class="item-after shop-status">待补件</div>--%>
                                            <%--</div>--%>
                                            <%--<div class="item-subtitle shop-subtitle">--%>
                                                <%--<label>主商编：</label>--%>
                                                <%--<span>898360650395654</span>--%>
                                            <%--</div>--%>
                                            <%--<div class="item-text">--%>
                                                <%--<div class="sub-code">--%>
                                                    <%--<label>分商编：</label>--%>
                                                    <%--<span>898360650395654-02</span>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                            <%--<div class="limit-show">--%>
                                                <%--<span class="limit-label">额度: </span>--%>
                                                <%--<span class="limit-sum">￥50,000</span>--%>

                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<div class="item-inner operate-block">--%>
                                        <%--&lt;%&ndash;<a class="operate-btn upgrade-limit" href="<c:url value='/new/m/upgradeLimit/show'/>">续贷</a>&ndash;%&gt;--%>
                                        <%--<a class="operate-btn add-file" href="<c:url value='/new/m/addFile/show'/>">补件</a>--%>
                                        <%--<a class="operate-btn upgrade-limit" href="<c:url value='/new/m/upgradeLimit/show'/>">提升额度</a>--%>
                                        <%--<a class="operate-btn get-cash" href="<c:url value='/new/m/verify/show'/>">立即提现</a>--%>
                                    <%--</div>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>

                        <c:forEach var="shopItem" items="${shopModels}">
                            <div class="list-block media-list shop-list">
                                <ul>
                                    <li>
                                        <a href="<c:url value='/new/m/applyStatus?shopId=${shopItem.objectId}'/>" class="item-link item-content">
                                            <div class="item-inner shop-inner">
                                                <div class="item-title-row shop-title-row">
                                                    <div class="item-title shop-title">
                                                        <span class="glyphicon home-icon"></span>
                                                        <span class="shop-title-txt">${shopItem.businessName}</span>
                                                    </div>
                                                    <div class="item-after shop-status">
                                                        <%--优先判断验证问题状态是否失败--%>
                                                        <c:if test="${shopItem.isQAVerified == '0'}"> 问题验证失败</c:if>
                                                        <c:if test="${shopItem.isQAVerified != '0'}">${shopItem.cashadvanceStatus}</c:if>
                                                    </div>
                                                </div>

                                                <%--遍历显示商编--%>
                                                <c:forEach var="mid" items="${shopItem.mids}" varStatus="i">
                                                    <c:if test="${i.index == 0 }">
                                                        <div class="item-subtitle shop-subtitle">
                                                            <label>主商编：</label>
                                                            <span>${mid}</span>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${i.index != 0 }">
                                                        <div class="item-text">
                                                            <div class="sub-code">
                                                                <label>分商编：</label>
                                                                <span>${mid}</span>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>

                                                <div class="limit-show">
                                                    <span class="limit-label">额度: </span>
                                                    <span class="limit-sum">￥${shopItem.amountRequested}</span>

                                                </div>
                                            </div>
                                        </a>
                                    </li>

                                    <%--如果不是验证问题失败--%>
                                    <c:if test="${shopItem.isQAVerified != '0'}">
                                        <c:if test="${shopItem.cashadvanceStatus == '关闭' ||  shopItem.cashadvanceStatus == '待补件' || shopItem.cashadvanceStatus == '评估额度完成'}">
                                            <li>
                                                <div class="item-inner operate-block">
                                                    <c:if test="${shopItem.cashadvanceStatus == '关闭'}">
                                                        <a class="operate-btn add-file" href="<c:url value='/new/m/upgradeLimit/show'/>">续贷</a>
                                                    </c:if>

                                                    <c:if test="${shopItem.cashadvanceStatus == '待补件'}">
                                                        <a class="operate-btn add-file" href="<c:url value='/new/m/addFile/show?shopId=${shopItem.objectId}baoliId=${shopItem.cashadvanceId}'/>">补件</a>
                                                    </c:if>

                                                    <c:if test="${shopItem.cashadvanceStatus == '评估额度完成'}">
                                                        <a class="operate-btn upgrade-limit" href="<c:url value='/new/m/upgradeLimit/show?shopId=${shopItem.objectId}baoliId=${shopItem.cashadvanceId}'/>">提升额度</a>
                                                        <a class="operate-btn get-cash" href="<c:url value='/new/m/verify/show?shopId=${shopItem.objectId}'/>">立即提现</a>
                                                    </c:if>
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:if>

                                </ul>
                            </div>
                        </c:forEach>

                        <c:if test="${fn:length(shopModels) < 1}">
                            <%--当没有店铺时，添加--%>
                            <div class="list-block">
                                <div class="blank-tips">
                                    <img class="tips-img" src="<c:url value='/resources/newm/images/blank-tips.png'/>" />
                                    <p>您还没有店铺哦~</p>
                                    <a class="button button-lg color-gray tips-btn" href="<c:url value='/new/m/addShop/show'/>">添加店铺</a>
                                </div>
                            </div>
                        </c:if>

                    </div>
                </div>
            </div>
            <div class="toolbar tabbar tabbar-labels">
                <div class="toolbar-inner">
                    <a href="<c:url value='/new/m/home'/>" class="tab-link active">
                        <i class="icon money-icon"><span class="badge bg-red">1</span></i>
                        <span class="tabbar-label">融资</span>
                    </a>
                    <a href="<c:url value='/new/m/account'/>" class="tab-link">
                        <i class="icon account-icon"></i>
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

</body>
</html>
