<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar"  style="display: ${isApp == '0' ? 'block' : 'none'}">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">意见反馈</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content ${isApp == '0' ? '' : 'none-navbar'}">
                    <div>
                        <%--<div class="content-block-title1">欢迎您提出宝贵的意见和建议，我们期待听到您的声音！</div>--%>
                        <div class="list-block uploadfile-block">
                            <ul>
                                <li>
                                    <div class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="text" placeholder="请输入您的姓名">
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="text" placeholder="请输入您的联系电话">
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title" style="width: 100%;padding: 0">
                                                <textarea class="commentsTextarea" placeholder="请输入您的意见内容" rows="6" style="height: 200px;"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="padding-rl15">
                            <a class="button button-fill button-big buttonConfirm" href="#">确认</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>