<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages">
            <!-- Page, data-page contains page name-->
            <div data-page="home" class="page toolbar-fixed">
                <!-- toolbar -->
                <div class="toolbar tabbar tabbar-labels">
                    <div class="toolbar-inner">
                        <a href="<c:url value='/new/m/home'/>" class="tab-link active">
                            <i class="icon money-icon">
                                <%--<span class="badge bg-red">1</span>--%>
                            </i>
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
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div class="home">
                        <div class="header">
                            <div class="mylimit">
                                <div class="circle">
                                    <div class="circle-md"></div>
                                    <div class="circle-sm"></div>

                                    <c:if test="${(!empty applicationModel && applicationModel.isComputingAmount != '1') || empty applicationModel }">
                                        <!-- 有额度时的 -->
                                        <div class="limit-txt">
                                            <div class="limit-title">我的额度</div>
                                            <div class="limit-num">
                                                <span class="icon-rmb">¥</span>
                                                <c:if test="${!empty applicationModel.amountRequested}">
                                                    <fmt:parseNumber integerOnly="true" value="${applicationModel.amountRequested}" />
                                                </c:if>
                                                <c:if test="${empty applicationModel.amountRequested}">
                                                    0
                                                </c:if>
                                            </div>
                                        </div>
                                    </c:if>

                                    <%--<!-- 额度审核中 -->--%>
                                    <c:if test="${!empty applicationModel && applicationModel.isComputingAmount == '1'}">
                                        <div class="home-scroll">
                                            <div class="limit-txt">
                                                <div class="limit-title">额度审核中</div>
                                                <div class="limit-num">
                                                    <div id="surplus-time"></div>
                                                </div>
                                            </div>
                                            <div class="home-srcoll"><img src="<c:url value="/resources/newm/images/home/scroll-lg.png"/>"></div>
                                        </div>
                                    </c:if>

                                </div>
                                <c:if test="${(!empty applicationModel && applicationModel.isComputingAmount != '1') || empty applicationModel }">
                                    <%--额度是否已冻结，冻结不让更改了--%>
                                    <c:if test="${applicationModel.isAmountLocked != '1'}">
                                        <div class="up-limit">
                                            <a class="button button-round color-white up-limit-inner" href="<c:url value='/new/m/myLimit'/>">${!empty applicationModel.amountRequested && applicationModel.amountRequested > 0 ? '继续提升额度' : '提升额度'}</a>
                                            <c:if test="${empty applicationModel.amountRequested || applicationModel.amountRequested < 0}">
                                                <i class="icon up-limit-icon"><span class="badge bg-red badge-dot"></span></i>
                                            </c:if>
                                        </div>

                                    </c:if>
                                </c:if>
                            </div>
                        </div>
                        <div class="home-content">
                            <div class="row home-row">
                                <%--<a class="col-33 home-block" id="cashBtn" href="##">--%>
                                    <%--<i class="icon index-icon immediate-cash">--%>
                                        <%--<c:if test="${isCash == '1' && !empty applicationModel.amountRequested && applicationModel.amountRequested > 0 && applicationModel.isEnabled == '0'}">--%>
                                            <%--<span class="badge bg-red badge-dot"></span>--%>
                                        <%--</c:if>--%>
                                    <%--</i>--%>
                                    <%--<p class="block-txt">立即提现</p>--%>
                                <%--</a>--%>
                                <a class="col-33 home-block" id="myapplyBtn" href="##">
                                    <i class="icon index-icon myapply">
                                        <%--<c:if test="${isCash != '1' && !empty applicationModel.amountRequested && applicationModel.amountRequested > 0 && applicationModel.isEnabled == '0'}">--%>
                                        <c:if test="${(isCash != '1' && !empty applicationModel.amountRequested && applicationModel.amountRequested > 0 ) &&
                                                    (applicationModel.isDocumentLocked != '1' || applicationModel.appStatus == 'approved')}">
                                            <span class="badge bg-red badge-dot"></span>
                                        </c:if>
                                        <%--加徽章--%>
                                        <%--<span class="badge bg-red badge-dot"></span>--%>
                                    </i>
                                    <p class="block-txt">我的申请</p>
                                </a>
                                <a class="col-33 home-block"  id="refundBtn" href="##'/>">
                                    <i class="icon index-icon bill-list">
                                        <c:if test="${!empty applicationModel.cashadvanceStatus && applicationModel.cashadvanceStatus == '还款清算'}">
                                            <span class="badge bg-red badge-dot"></span>
                                        </c:if>
                                    </i>
                                    <p class="block-txt">我的账单</p>
                                </a>
                            </div>
                            <div class="row home-row">
                                <a class="col-33 home-block"  id="pendingBtn" href="##">
                                    <i class="icon index-icon add-file">
                                        <c:if test="${!empty applicationModel.appStatus && applicationModel.appStatus == 'pending'}">
                                            <span class="badge bg-red badge-dot"></span>
                                        </c:if>
                                    </i>
                                    <p class="block-txt">补全资料</p>
                                </a>
                                <a class="col-33 home-block">
                                    <div class="index-icon expecting"></div>
                                    <p class="block-txt">敬请期待</p>
                                </a>
                            </div>
                        </div>
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

    if ("${!empty applicationModel && applicationModel.isComputingAmount == '1'}" == "true") {
        //表示正在计算度

        //获取服务器当前倒计时剩余总秒数
        var maxtime = "${creditsTaskModel.waitSeconds}";

        //循环倒计时
        function countDown() {
            var minus = Math.floor(maxtime / 60);
            var seconds = Math.floor(maxtime % 60);
            var msg = minus + ":" + seconds;
            if (parseInt(maxtime) <= 0) {
                //清除计时器
                clearInterval(timer);
                clearInterval(creditTimer);
                myApp.alert('系统无法给出您的额度，请线下联系管理员或拨打400电话!', '提示', function () {
                    location.href = location.href;//刷新当前界面
                });
            }
            $("#surplus-time").html(msg);
            --maxtime;
        }

        //定时器2，每隔1秒获取当前授信状态
        function accredit() {
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/credit",
                data: {},
                success: function (data) {
                    if (data.resultCode != "-1") {
                        //清除计时器
                        clearInterval(timer);
                        clearInterval(creditTimer);
                        //额度已计算成功,刷新界面
                        location.href = location.href;
                    }
                }
            });
        }

        // 没超时则执行
        if (parseInt(maxtime) > 0) {
            //倒计时计时器2
            var timer = setInterval("countDown()", 1000);
            //定时器2，定时调用授信接口
            var creditTimer = setInterval(accredit, 5000);//定时器，5秒一次
        } else {
            var creditLine = parseInt(${creditsTaskModel.totalCreditLine});
            creditLine = isNaN(creditLine) ? "无额度" : creditLine;
            //表示验证超时了
            $(".home-scroll").before('' +
            '<div class="limit-txt">' +
            '<div class="limit-title">我的额度</div>' +
            '<div class="limit-num">' +
            '<span class="icon-rmb">¥</span>' + creditLine +
            '</div>' +
            '</div>' +
            '');
            $(".home-scroll").remove();
        }
    }


    // 立即体现按钮
    $("#cashBtn").click(function(){
        if ("${!empty applicationModel.amountRequested && applicationModel.amountRequested > 0}"  == "true") {
            if ("${newMerchantUserModel.isJxlValid == '1'}" != 'true') {
                myApp.confirm('您还未进行手机验证！是否马上进行验证？','提示',function() {
                    location.href = "<c:url value='/new/m/juxinliLimit/show'/>";
                });
            } else {
                myApp.showPreloader('加载中...')
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/applyStatus",
                    data: {},
                    success: function (data) {
                        if (data.resultCode == "-1") {
                            myApp.hidePreloader();
                            if (data.resultData == "1") {
                                //首页提示
                                myApp.confirm('您当前的提现申请还未结束，暂不允许继续提现！是否马上查看申请详情？','提示',function() {
                                    location.href = "<c:url value='/new/m/applyStatus/show'/>";
                                });
                            } else {
                                //错误提示
                                myApp.alert(data.resultMsg,'提示');
                            }
                        } else {
                            if(data.resultData == '1') {
                                myApp.hidePreloader();
                                myApp.alert('您的额度已经过期，请重新授信完成后以后再进行提交续贷申请！','提示',function(){
                                    location.href = "<c:url value='/new/m/myLimit'/>";
                                });
                            } else {
                                location.href = "<c:url value='/new/m/uploadFile/show'/>";
                            }
                        }
                    }
                });
            }
        } else {
            myApp.confirm('请授信完成以后再进行该操作，是否马上进行授信？','提示',function() {
                location.href = "<c:url value='/new/m/myLimit'/>";
            });
        }
    });

    // 我的申请按钮
    $("#myapplyBtn").click(function(){
        if ("${!empty applicationModel.amountRequested && applicationModel.amountRequested > 0}"  == "true") {
            if ("${newMerchantUserModel.isJxlValid == '1'}" != 'true') {
                    myApp.confirm('您还未进行手机验证！是否马上进行验证？','提示',function() {
                        location.href = "<c:url value='/new/m/juxinliLimit/show'/>";
                });
            } else {
                location.href = "<c:url value='/new/m/applyStatus/show'/>";
            }
        } else {
            myApp.confirm('请授信完成以后再进行该操作，是否马上进行授信？','提示',function() {
                location.href = "<c:url value='/new/m/myLimit'/>";
            });
        }
    });

    // 对账单按钮
    $("#refundBtn").click(function(){
        if ("${!empty applicationModel.cashadvanceStatus && applicationModel.cashadvanceStatus == '还款清算'}" == "true") {
            location.href = "<c:url value='/new/m/refundDetail?baoliId=${applicationModel.cashadvanceId}'/>";
        } else {
            myApp.alert('您当前没有对账相关信息!!','提示');
        }
    });

    // 补件按钮
    $("#pendingBtn").click(function(){
        if ("${!empty applicationModel.appStatus && applicationModel.appStatus == 'pending'}"  == "true") {
            location.href = "<c:url value='/new/m/addFile/show'/>";
        } else {
            myApp.alert('您当前没有需要补充的文件!!','提示');
        }
    });

    //.header点击跳转
    $(".header").click(function(){
        if ("${((!empty applicationModel && applicationModel.isComputingAmount != '1') || empty applicationModel) && applicationModel.isAmountLocked != '1' }" == "true") {
            location.href="<c:url value='/new/m/myLimit'/>"
        }
    });

</script>

</body>
</body>
</html>
