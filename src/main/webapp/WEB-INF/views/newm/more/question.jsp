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
        <div class="navbar"  style="display: ${isApp == '0' ? 'block' : 'none'}">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">融资攻略</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content ${isApp == '0' ? '' : 'none-navbar'}">
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>创新金融</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>无抵押无担保！</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>提高额度</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>请在填写申请时，详尽并真实的填写您的个人信息和经营信息，最重要的是，如果您安装有POS机，一定尽可能多的提交完整、正确的POS商编，可以大幅提高您的额度。我们的额度上限为100万元。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>融资期限</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>主要为短期保理融资，一般为6个月期限。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>融资费率</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>综合费率在1.5-3%/月之间</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>还款方式</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>您可以选择按周还款，也可以选择按日还款。</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>续签优惠</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>只要您上一次的融资正常还款，续签商户可以享受更高额度，更低费率，更快审批，更少材料，超速直达！</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="list-block media-list myaccount">
                        <ul>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-question-sign wechat-icon-question-sign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>授信用时</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-link item-content">
                                    <div class="item-media"><span class="glyphicon glyphicon-ok-sign wechat-icon-campaign"></span></div>
                                    <div class="item-inner questionCon">
                                        <span>只要资料完整正确，我们最快可以做到，您3分钟申请，我3小时审核，3天内放款！</span>
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
</body>
</html>