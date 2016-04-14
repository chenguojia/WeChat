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
                    <div class="left">
                        <c:if test="${sourceType == '1'}"> <a href="<c:url value='/new/m/home'/>"  class="back link wechat-back"> </c:if>
                        <c:if test="${sourceType == '2'}"> <a href="<c:url value='/new/m/applyStatus/show'/>"  class="back link wechat-back"> </c:if>
                        <c:if test="${sourceType == '3'}"> <a href="<c:url value='/new/m/account'/>"  class="back link wechat-back"> </c:if>
                        <i class="icon icon-back card-back"></i></a>
                    </div>
                    <div class="center sliding">还款明细</div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="index" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content pull-to-refresh-content infinite-scroll">
                        <div class="content-block-title margin-t15">
                            <ul class="refund-list-inner">
                                <div class="">
                                    <li>
                                        <label class="refund-list-label">融资金额：</label>
                                        <span>${exchangerResultModel.footer[0].amountRequested}</span>
                                    </li>
                                    <li>
                                        <label class="refund-list-label">已还金额：</label>
                                        <span>${exchangerResultModel.footer[0].totalPayback}</span>
                                    </li>
                                    <li>
                                        <label class="refund-list-label">未还金额：</label>
                                        <span class="no-refund">${exchangerResultModel.footer[0].totalRemaining}</span>
                                    </li>
                                </div>
                            </ul>
                        </div>
                        <div class="list-block media-list shop-list">
                            <ul>

                                <c:forEach var="item" items="${exchangerResultModel.rows}">
                                <li>
                                    <div class="item-content">
                                        <div class="item-inner shop-inner">
                                            <div class="item-title-row">
                                                <div class="item-title refund-title">
                                                    <span class="glyphicon glyphicon-calendar glyphicon-date" aria-hidden="true"></span>
                                                    <span class="">清算日期：${item.qingsuandate}</span>
                                                </div>
                                            </div>
                                            <div class="item-text shop-subtitle">
                                                <div class="refund-subtext">
                                                    <label class="refund-subtext-label">清算金额：</label>
                                                    <span class="refund-fee">${item.inJine}</span>
                                                </div>
                                                <div class="refund-subtext">
                                                    <label class="refund-subtext-label">账户管理费：</label>
                                                    <span class="refund-fee">${item.cvFee}</span>
                                                </div>
                                                <div class="refund-subtext">
                                                    <label class="refund-subtext-label">实还日期：</label>
                                                    <span class="refund-fee">${item.posRepaymentDate}</span>
                                                </div>
                                                <div class="refund-subtext">
                                                    <label class="refund-subtext-label">实还金额：</label>
                                                    <span class="refund-fee">${item.huankuan}</span>
                                                </div>
                                                <div class="refund-subtext">
                                                    <label class="refund-subtext-label">卡得万利付款：</label>
                                                    <span class="refund-fee">${item.paymentAmt}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                </c:forEach>

                            </ul>
                        </div>
                        <!-- Preloader -->
                        <div class="infinite-scroll-preloader">
                            <div class="preloader"></div>
                        </div>

                        <%--未提出申请--%>
                        <div class="list-block">
                            <div class="blank-tips">
                                <img class="tips-img" src="<c:url value='/resources/newm/images/blank-tips.png'/>" />
                                <p>您还没有还款记录！</p>
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
    var $$ = Dom7;

    //滑动加载更多数据
    var baoliId = "${baoliId}";//总页数
    var pageCount = "${pageCount}";//总页数
    var pageNumber = "${pageNumber}";//当前页码
    $$('.infinite-scroll').on('infinite', function () {

        //判断是否最后一页
        if (pageNumber >= pageCount) {
            myApp.detachInfiniteScroll($$('.infinite-scroll'));
            $$('.infinite-scroll-preloader').remove();
            return;
        }

        //表示不是最后一页继续请求
        $.ajax({
            type: "GET",
            url: contextPath + "new/m/loadRefundDetail",
            data: {"baoliId": baoliId,"pageNumber": parseInt(pageNumber) + 1},
            success: function (data) {
                if (data.resultCode == "-1") {
                    myApp.alert(data.resultMsg,'提示');
                } else {
                    //解析服务器返回内容
                    pageNumber = data.resultData["pageNumber"];
                    var exchangerResultModel = data.resultData["exchangerResultModel"]
                    //构建追加变量
                    var html = '';
                    for (var i = 0; i < exchangerResultModel.rows.length; i++) {
                        //获取当前循环对象
                        var obj = exchangerResultModel.rows[i];
                        //追加HTML
                        html += '<div class="item-content">'
                        html += '<div class="item-inner shop-inner">'
                        html += '<div class="item-title-row">'
                        html += '<div class="item-title refund-title">'
                        html += '<span class="glyphicon glyphicon-calendar glyphicon-date" aria-hidden="true"></span>'
                        html += '<span class="">清算日期：'+ obj.qingsuandate +'</span>'
                        html += '</div>'
                        html += '</div>'
                        html += '<div class="item-text shop-subtitle">'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">清算金额：</label>'
                        html += '<span class="refund-fee">'+ obj.inJine +'</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">账户管理费：</label>'
                        html += '<span class="refund-fee">'+ obj.cvFee +'</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">实还日期：</label>'
                        html += '<span class="refund-fee">'+ obj.posRepaymentDate +'</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">实还金额：</label>'
                        html += '<span class="refund-fee">'+ obj.huankuan +'</span>'
                        html += '</div>'
                        html += '<div class="refund-subtext">'
                        html += '<label class="refund-subtext-label">卡得万利付款：</label>'
                        html += '<span class="refund-fee">'+ obj.paymentAmt +'</span>'
                        html += '</div>'
                        html += '</div>'
                        html += '</div>'
                        html += '</div>'
                    }
                    // Append new items
                    $$('.list-block ul').append(html);

                }
            }
        });

    });
</script>

</body>
</html>
