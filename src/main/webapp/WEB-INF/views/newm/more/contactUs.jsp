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
                <div class="center sliding">联系方式</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content ${isApp == '0' ? '' : 'none-navbar'}">
                    <div class="caseShare_pic aboutUs_titPic"><a href="#" class="caseShare-popup"><img src="<c:url value="/resources/newm/images/welcome.jpg"/>" width="100%"></a></div>
                    <div>
                        <div class="content-block caseShare_story honorTit">卡得万利商业保理（上海）有限公司</div>
                        <div class="list-block uploadfile-block contactUsCon">
                            <ul>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-phone-alt"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title label">服务咨询：</div>
                                            <div class="item-input">
                                                <a href="tel:4006081310" ><span class="contactUsText">400-608-1310</span></a>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-print"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title label">传真：</div>
                                            <div class="item-input">
                                                <a href="#" ><span class="contactUsText">021-60870131</span></a>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-map-marker"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title label">地址：</div>
                                            <div class="item-input">
                                                <span class="contactUsText">上海浦东新区北张家浜路88号C座5楼</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-pencil"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title label">邮编：</div>
                                            <div class="item-input">
                                                <span class="contactUsText">200122</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="glyphicon glyphicon-envelope"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title label">邮箱：</div>
                                            <div class="item-input">
                                                <span class="contactUsText">factoring@cardvalue.cn</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
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