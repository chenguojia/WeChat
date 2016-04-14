<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head></head>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>卡得万利商业保理</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/newm/lib/framework7/css/framework7.css"/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/wechat.css'/>">
</head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">

        <div class="page-content padding0 page-back">
            <div class="tabs height-full">
                <div class="container-fluid padding0 align-middle back-ground-col">
                    <div class="nav-body nav-body-bac">
                        <div class="left-chanzi">
                            <span>剩余</span>
                            <span class="left-account" id="residueCount">${empty drawCount ? '0' : ''}<fmt:formatNumber value="${drawCount}" type="currency" pattern="#####.##"/></span>
                            <span>把金铲</span>
                        </div>
                        <div class="shovel">
                            <div style="position: absolute;">
                                <img src="<c:url value="/resources/image/gold.png"/>" id="golds">
                            </div>
                            <img src="<c:url value="/resources/image/chanzi.png"/>" id="idevent">
                        </div>
                        <div class="nav-buttom">
                            <a class="btn btn-check-result btn-check-color btn-shadow" data-toggle="modal" data-target="#myModal">
                                查看获奖记录
                            </a>
                        </div>
                        <div class="check-rules" data-toggle="modal" data-target="#checkRules">
                            <span>查看活动规则</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal-body-top displaynone">
                <div class="modal-dialog modal-dialog-align">
                    <div class="modal-content modal-black-back">
                        <div class="glyphicon glyphicon-remove-circle wechat-icon-error"></div>
                        <div class="modal-lights displaynone">
                            <img src="<c:url value="/resources/image/light2.png"/>" width="100%" id="lighting">
                        </div>
                        <div class="cads wa-baobei">
                            <span>哇！您本次挖到了1件宝贝</span>
                        </div>
                        <div class="modal-body modal-body-back displaynone">
                            <%--抽奖结果为金块--%>
                            <div class="displaynone modal-font" id="goldDiv"><img src="<c:url value="/resources/image/goldkuai.png"/>" width="60%"> </div>
                            <%--抽奖结果为积分--%>
                            <div class="displaynone modal-font" id="scoreDiv">10000积分</div>
                        </div>
                        <div class="modal-footer modal-footer-pos">
                            <a href="<c:url value='/sales/pointAndLevel'/>" type="button" class="btn btn-check-result modal-footer-btn" data-dismiss="modal">
                                立即兑换
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" id="myModal">
                <div class="modal-dialog modal-dialog-pos" role="document">
                    <div class="modal-content modal-content-pos">
                        <div class="modal-header modal-header-font">
                            <a class="close glyphicon glyphicon-remove-circle modal-remove-circle" data-dismiss="modal" aria-label="Close"></a>
                            <h4 class="modal-title modal-title-font" id="gridSystemModalLabel">我的奖品</h4>
                        </div>
                        <div class="modal-body modal-body-positi">
                            <div class="container-fluid modal-container">
                                <%--无获奖记录--%>
                                <div class="helpcheck none-award-record" style="display: ${fn:length(campaignActions) > 0 ? 'none': 'block'}">无获奖记录</div>
                                <c:forEach  var="item" items="${campaignActions}">
                                    <div class="row row-font">
                                        <div class="col-md-4 col-sm-4 padding-r0"><fmt:formatDate value="${item.createDate}" type="date" dateStyle="default"/></div>
                                        <div class="col-md-4 col-sm-4 padding-r0"><fmt:formatDate value="${item.createDate}" pattern="HH:mm:ss"/></div>
                                        <div class="col-md-4 col-sm-4 padding-r0">获得<span class="row-font-color">
                                            <c:if test="${item.amount == 1}">金条1枚</c:if>
                                            <c:if test="${item.amount != 1}"><fmt:formatNumber value="${item.amount}" type="currency" pattern="#####.##"/>积分</c:if>
                                        </span></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="modal-footer modal-footer-posti">
                            <a href="<c:url value='/sales/pointAndLevel'/>" type="button" class="btn btn-reward-result modal-footer-btn">
                                立即兑换
                            </a>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->


            <div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" id="checkRules">
                <div class="modal-dialog modal-dialog-pos rules-whole-page" role="document">
                    <div class="rules-table">
                        <div class="table-left">
                            <span class="check-font">活动时间</span>
                        </div>
                        <div class="table-right">
                            <span class="check-rules-font">为期2个月，8月1日-9月30日</span>
                        </div>
                    </div>
                    <div class="rules-table padding-t10 float_clear">
                        <div class="table-left">
                            <span class="check-font">活动对象</span>
                        </div>
                        <div class="table-right">
                            <span class="check-rules-font">全体银商客户经理</span>
                        </div>
                    </div>
                    <div class="rules-table padding-t10 float_clear">
                        <div class="table-left">
                            <span class="check-font">活动形式</span>
                        </div>
                        <div class="table-right">
                            <span class="check-rules-font">客户经理通过微信端提交线索，每提交1条有效线索即可获得1个金铲，提交6个月产品有效线索可获得1.5个金铲。历史金铲获得数量前3名的客户经理可获得相应礼品，同时金铲可用于挖金条活动，一个金铲可参与一次。</span>
                        </div>
                    </div>
                    <div class="rules-table padding-t10 float_clear">
                        <div class="table-left">
                            <span class="check-font">活动奖品</span>
                        </div>
                        <div class="table-right">
                            <span class="check-rules-font">排名前三奖品：</span>
                        </div>
                    </div>
                    <div class="rules-table padding-t05 float_clear">
                        <div class="table-left">
                            <span class="check-font td-opacity"></span>
                        </div>
                        <div class="table-right">
                            <span class="check-rules-font">金铲获得数排名<span class="color-white">第一</span>：价值约<span class="color-white">5000元金条</span></span>
                        </div>
                    </div>
                    <div class="rules-table float_clear">
                        <div class="table-left">
                            <span class="check-font td-opacity"></span>
                        </div>
                        <div class="table-right">
                            <span class="check-rules-font">金铲获得数排名<span class="color-white">第二、第三</span>：价值约<span class="color-white">3000元金条</span></span>
                        </div>
                    </div>
                    <div class="rules-table padding-t05 float_clear">
                        <div class="table-left">
                            <span class="check-font td-opacity"></span>
                        </div>
                        <div class="table-right">
                            <span class="check-rules-font">挖金条活动奖品：</span>
                        </div>
                    </div>
                    <div class="rules-table padding-t05 float_clear">
                        <div class="table-left">
                            <span class="check-font td-opacity"></span>
                        </div>
                        <div class="table-right">
                            <div class="row">
                                <div class="col-sm-3 col-md-3 padding-r0 padding-l05"><span class="check-rules-font">一等奖</span></div>
                                <div class="col-xs-7 col-md-7 padding-r0 padding-l05"><span class="check-rules-font">价值<span class="color-white">3000</span>元的金条</span></div>
                                <div class="col-sm-2 col-md-2 padding-r0 padding-l05"><span class="check-rules-font"><span class="color-white">1</span>个</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="rules-table float_clear">
                        <div class="table-left">
                            <span class="check-font td-opacity"></span>
                        </div>
                        <div class="table-right">
                            <div class="row">
                                <div class="col-sm-3 col-md-3 padding-r0 padding-l05"><span class="check-rules-font">二等奖</span></div>
                                <div class="col-xs-7 col-md-7 padding-r0 padding-l05"><span class="check-rules-font">价值<span class="color-white">500</span>元的<span class="color-white">10000</span>积分</span></div>
                                <div class="col-sm-2 col-md-2 padding-r0 padding-l05"><span class="check-rules-font"><span class="color-white">2</span>个</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="rules-table float_clear">
                        <div class="table-left">
                            <span class="check-font td-opacity"></span>
                        </div>
                        <div class="table-right">
                            <div class="row">
                                <div class="col-sm-3 col-md-3 padding-r0 padding-l05"><span class="check-rules-font">三等奖</span></div>
                                    <div class="col-xs-7 col-md-7 padding-r0 padding-l05"><span class="check-rules-font">价值<span class="color-white">300</span>元的<span class="color-white">6000</span>积分</span></div>
                                    <div class="col-sm-2 col-md-2 padding-r0 padding-l05"><span class="check-rules-font"><span class="color-white">5</span>个</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="rules-table float_clear">
                            <div class="table-left">
                                <span class="check-font td-opacity"></span>
                            </div>
                            <div class="table-right">
                                <div class="row">
                                    <div class="col-sm-3 col-md-3 padding-r0 padding-l05"><span class="check-rules-font">四等奖</span></div>
                                    <div class="col-xs-7 col-md-7 padding-r0 padding-l05"><span class="check-rules-font">价值<span class="color-white">50</span>元的<span class="color-white">1000</span>积分</span></div>
                                    <div class="col-sm-2 col-md-2 padding-r0 padding-l05"><span class="check-rules-font"><span class="color-white">20</span>个</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="rules-table float_clear">
                            <div class="table-left">
                                <span class="check-font td-opacity"></span>
                            </div>
                            <div class="table-right">
                                <div class="row">
                                    <div class="col-sm-3 col-md-3 padding-r0 padding-l05"><span class="check-rules-font">五等奖</span></div>
                                    <div class="col-xs-7 col-md-7 padding-r0 padding-l05"><span class="check-rules-font">价值<span class="color-white">25</span>元的<span class="color-white">500</span>积分</span></div>
                                    <div class="col-sm-2 col-md-2 padding-r0 padding-l05"><span class="check-rules-font"><span class="color-white">50</span>个</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="rules-table float_clear">
                            <div class="table-left">
                                <span class="check-font td-opacity"></span>
                            </div>
                            <div class="table-right">
                                <div class="row">
                                    <div class="col-sm-3 col-md-3 padding-r0 padding-l05"><span class="check-rules-font">参与奖</span></div>
                                    <div class="col-xs-6 col-md-6 padding-r0 padding-l05"><span class="check-rules-font">随机<span class="color-white">10~100</span>积分</span></div>
                                    <div class="col-sm-3 col-md-3 padding-r0 padding-l05"><span class="check-rules-font"><span class="color-white">数量不限</span></span></div>
                                </div>
                            </div>
                        </div>
                        <button type="button" class="close glyphicon glyphicon-remove-circle color-white check-close" data-dismiss="modal" aria-label="Close"></button>
                    </div><!-- /.modal-dialog -->
                </div>


        </div>

    </div>
</div>
<!-- Path to Framework7 Library JS-->
<script type="text/javascript" src="<c:url value="/resources/newm/lib/framework7/js/framework7.js"/>"></script>
<!-- Path to your app js-->
<script type="text/javascript" src="<c:url value='/resources/script/wechat.js'/>"></script>

<script type="text/javascript" src="<c:url value='/resources/script/jquery.js'/>"></script>

<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>

<script>

    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    $(function () {
        var tiemer = "";
        var timer2 = "";
        var time = 3000;//每次点击三秒后才能再次点击
        var time2 = 3500;
        var fun = function bClick() {
            //判断是否有足够的金铲
            if ($("#residueCount").html() == "" ||  parseFloat($("#residueCount").html()) < 1 ) {
                myApp.alert("亲，您的铲子数量小于1个，暂不能挖金条哦!赶紧提交线索来增加您的铲子数量吧！",'提示');
                return;
            }

            //alert("执行方法");
            $('#idevent').addClass('idevent-rotate');
            $('#golds').addClass('idevent-scale');
            //在3秒内再按键无效
            $("#idevent").unbind("click");

            //开始抽奖逻辑
            $.ajax({
                type: "POST",
                url: "<c:url value="/campaign/excavate"/>",
                data: {},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        $('#idevent').removeClass('idevent-rotate');
                        $('#golds').removeClass('idevent-scale');
                        myApp.alert(data.resultMsg,'提示');
                    } else {

                        tiemer = setTimeout(function () {
                            $('.tabs').addClass('displaynone');
                            $('.view-main .padding0').removeClass('page-back').addClass('page-back-retu');
                            $('.modal-body-top').fadeIn('slow');
                        }, time);

                        timer2 = setTimeout(function () {
                            $('.modal-lights').fadeIn();
                            $('#lighting').addClass('light-scale');

                            //判断是否抽中金块
                            if (data.resultData.isGold == "1") {
                                $("#goldDiv").fadeIn();
                                $(".cads").removeClass('wa-baobei');
                                $(".modal-body-back").fadeIn();
                                $(".modal-body-back").addClass('font-scale');
                                myApp.alert("恭喜您，挖到本次活动特等奖“金条一枚”！稍后我们的工作人员会联系到您，尽将金条快派送到您手中！",'提示');
                            } else {
                                $("#scoreDiv").html(data.resultData.amount + "积分");
                                $("#scoreDiv").fadeIn();
                                $(".cads").removeClass('wa-baobei');
                                $(".modal-body-back").fadeIn();
                                $(".modal-body-back").addClass('font-scale');
                            }
                            $("#residueCount").html(data.resultData.residueCount);//显示剩下次数
                        }, time2);
                    }
                    $(".shovel").click(fun);//重新绑定
                }
            });
        };
        $(".shovel").click(fun);
        $(".wechat-icon-error").click(function () {
            history.go(0);
        });
    })


</script>
</body>
</html>