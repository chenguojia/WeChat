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
                <div class="left"><a href="<c:url value='/new/m/home'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">提升额度</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="list-block upgrade-list">
                        <div class="list-block media-list myaccount">
                            <ul>
                                <li>
                                    <a href="##" class="item-link item-content" id="basicLimitBtn">
                                        <div class="item-media"><span class="glyphicon glyphicon-credit-card wechat-icon-coupon"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">基础资料</div>
                                                <%--<div class="item-after"><span class="pos-code-confirm">已填写</span></div>--%>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="item-link item-content" id="posLimitBtn">
                                        <div class="item-media"><span class="glyphicon icon-pos-limit"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">POS资料</div>
                                                <%--<div class="item-after"><span class="pos-code-confirm">已填写</span></div>--%>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="item-link item-content" id="juxinliLimitBtn">
                                        <div class="item-media"><span class="glyphicon icon-jxl"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">手机验证</div>
                                                <div class="item-after">
                                                    <span class="pos-code-confirm"> ${newMerchantUserModel.isJxlValid == '1' ? '已验证' : '未验证'} </span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>

                        </div>
                    </div>
                    <div class="padding-rl15">
                        <p>温馨提示：您可以分别填写以上不同的类别信息来提升您的融资额度。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    //待转申请前，允许修改额度
    if ("${((!empty applicationModel && applicationModel.isComputingAmount != '1') || empty applicationModel) && applicationModel.isAmountLocked != '1'}" == "true") {
        $("#basicLimitBtn").click(function () {
            location.href = "<c:url value='/new/m/basicLimit/show'/>";
        });

        $("#posLimitBtn").click(function () {
            if ("${!empty applicationModel && !empty applicationModel.amountRequested  && applicationModel.amountRequested > 0}" == "true") {
                //基础额度填写以后才允许计算POS额度
                myApp.showPreloader('加载中...')
                location.href = "<c:url value='/new/m/posLimit/show'/>";
            } else {
                myApp.alert('请先填写基础额度信息！', '提示');
            }
        });

        $("#juxinliLimitBtn").click(function () {
            //如果未验证才能进行验证
            if ("${newMerchantUserModel.isJxlValid != '1'}" == "true") {
                myApp.showPreloader('加载中...')
                location.href = "<c:url value='/new/m/juxinliLimit/show'/>";
            } else {
                myApp.alert('您已验证过聚信立信息！', '提示');
            }

        });
    } else {
        //表示线索已经转为申请，不允许修改额度
    }

</script>

</body>
</html>
