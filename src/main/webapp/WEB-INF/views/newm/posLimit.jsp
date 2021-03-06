<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head></head>
<body>
    <div class="views">
        <div class="view view-main">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="left"><a href="<c:url value='/new/m/myLimit'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                    <div class="center sliding">添加POS商编</div>
                </div>
            </div>
            <div class="pages navbar-through toolbar-through">
                <div data-page="index" class="page">
                    <div class="page-content pull-to-refresh-content">
                        <!-- 下拉刷新div-->
                        <div class="pull-to-refresh-layer">
                            <div class="preloader"></div>
                            <div class="pull-to-refresh-arrow"></div>
                        </div>
                        <div class="list-block media-list" class="${fn:length(posCreditsMids) < 1 ? 'displaynone' : '' } ">
                            <ul id = "posListDiv">
                                <%--后台数据--%>
                                <c:forEach var="item" items="${posCreditsMids}">
                                    <c:if test="${item.status == 'U'}">
                                        <li>
                                            <a href="<c:url value='/new/m/verify/show?mid=${item.mid}'/>" class="item-link item-content">
                                                <%--商编图标--%>
                                                <div class="item-media"><span class="glyphicon glyphicon-barcode glyphicon-barcode-sub"></span></div>
                                                <div class="item-inner">
                                                    <div class="item-title-row">
                                                        <div class="item-title">${item.mid}</div>
                                                        <div class="item-after"><span class="pos-code-confirm">${item.statusInfo}</span></div>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                    </c:if>

                                    <c:if test="${item.status != 'U'}">
                                        <li>
                                            <div class="item-content">
                                                <div class="item-media"><span class="glyphicon glyphicon-barcode glyphicon-barcode-sub"></span></div>
                                                <div class="item-inner">
                                                    <div class="item-title-row">
                                                        <div class="item-title"><a href="#" class="poscode-txt-color">${item.mid}</a></div>
                                                        <div class="item-after">
                                                            <span class="pos-code-confirm pos-code-position">${item.statusInfo}</span>
                                                            <%--loading状态图标--%>
                                                            <c:if test="${item.status == 'Q'}">
                                                                <span class="preloader"></span>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                    <c:if test="${item.status == 'Q'}"><div class="item-subtitle margin-t05 pos-note">提示：系统将自动为您刷新最新状态，请耐心等待！或您可以尝试向下滑动界面获取最新状态！</div></c:if>
                                                </div>
                                            </div>
                                        </li>

                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>

                        <%--如果没有验证失败或者正在执行的的POS则显示--%>
                        <c:if test="${empty processingMid && empty checkFailMid}">
                            <div class="list-block upgrade-list">
                                <ul>
                                    <li class="swipeout transitioning">
                                        <div class="swipeout-content item-content">
                                            <div class="item-media"><span class="glyphicon glyphicon-barcode glyphicon-barcode-sub"></span></div>
                                            <div class="item-inner subcode-inner">
                                                <div class="item-title"><input type="text" placeholder="请输入商编" name="mids"  id="mids" tip="商编不能为空" /></div>
                                            </div>



                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="padding-rl15">
                                <a class="button button-fill button-big" id="submitBtn">提交</a>
                                <p class="font12">请确保您输入的的POS商编为您名下的，以免后续问题验证失败给您带来不便！</p>

                                <%--POS编号示例--%>
                                <div class="pos-eg">
                                    <a href="#" data-popover=".popover-pos" class="pos-limit-help open-popover">
                                        什么是POS商编？
                                    </a>
                                    <style>
                                        .modal-overlay {background-color:rgba(0,0,0,0);}
                                    </style>
                                    <%-- popover--%>
                                    <div class="popover popover-pos">
                                        <div class="popover-angle"></div>
                                        <div class="popover-inner">
                                            <div class="content-block pos-bill">
                                                <img src="<c:url value='/resources/newm/images/pos-bill.jpg'/>" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <%--如果有验证失败的记录则显示提示信息--%>
                        <c:if test="${!empty checkFailMid}">
                            <div class="padding-rl15 margin-t10 pos-tips">
                                <div class="margin-b05">提示：由于您的POS编号${checkFailMid.mid}验证问题三次回答错误，该商编额度已被锁定。请您在提交申请界面上传如下材料之一作为辅证，激活您的商编额度：</div>
                                <div class="margin-b05 pos-proof">1、POS机装机单<br/>
                                2、收单机构提供的对账系统截屏（需包含商户注册名称、商户编号和装机地址信息）</div>
                            </div>
                        </c:if>

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

    // 下拉刷新Pull to refresh content
    $$('.pull-to-refresh-content').on('refresh', function () {
        location.href = location.href;
    });

    //判断是否有正在生成验证问题的记录
    if ("${!empty makingQuestionsMid && makingQuestionsMid != ''}" == 'true') {
        //启用定时器，定时刷新
        var countdown = setInterval(countDown, 3000);//定时器
        //倒计时
        function countDown() {
            $.ajax({
                type: "GET",
                url: contextPath + "new/m/posLimit/query",
                data: {},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        console.log(data.resultMsg);
                    } else {
                        var list = data.resultData.posCreditsMids;
                        var isHaveMakingQuestionsMid = data.resultData.isHaveMakingQuestionsMid;

                        //局部刷新上面商编
                        var html = "";
                        for (var i = 0 ; i < list.length ; i ++) {
                            var item = list[i];
                            var isQTipHtml = item.status == 'Q' ? '<div class="item-subtitle margin-t05 pos-note">提示：系统将自动为您刷新最新状态，请耐心等待！或您可以尝试向下滑动界面获取最新状态！</div>' : '';
                            if (list[i].status == 'U') {
                                html += '' +
                                '<li> ' +
                                    '<a href="<c:url value='/new/m/verify/show?mid='/>' + item.mid + '" class="item-link item-content"> ' +
                                        '<div class="item-media"><span class="glyphicon glyphicon-barcode glyphicon-barcode-sub"></span></div>'+
                                        '<div class="item-inner">' +
                                            '<div class="item-title-row">' +
                                            '<div class="item-title">' + item.mid + '</div>' +
                                            '<div class="item-after"><span class="pos-code-confirm">' + item.statusInfo + '</span></div>' +
                                            '</div>' +
                                        '</div>' +
                                    '</a>' +
                                '</li>';
                            } else {
                                var loadingHtml = item.status == "Q" ? '<span class="preloader"></span>' : '';//如果有带生成验证问题则显示loading效果
                                html += '' +
                                '<li>'+
                                    '<div class="item-content">'+
                                        '<div class="item-media"><span class="glyphicon glyphicon-barcode glyphicon-barcode-sub"></span></div>'+
                                        '<div class="item-inner">'+
                                            '<div class="item-title-row">'+
                                                '<div class="item-title"><a href="#" class="poscode-txt-color">' + item.mid + '</a></div>'+
                                                '<div class="item-after"><span class="pos-code-confirm pos-code-position">' + item.statusInfo + '</span> '+ loadingHtml +'</div>'+
                                            '</div>'+
                                            isQTipHtml +
                                        '</div>'+
                                    '</div>'+
                                '</li>';

                            }
                        }
                        $("#posListDiv").html(html);
                        console.log(html);

                        //如果已经没有正在获取验证问题的记录则清除计时器
                        if (isHaveMakingQuestionsMid == '0') {
                            clearInterval(countdown);
                        }
                    }
                }
            });
        }
    }

    //提交
    $("#submitBtn").click(function () {
        var flag = true;
        $("input").each(function () {
            if ($(this).val() == "") {
                myApp.alert($(this).attr("tip"), "提示");
                flag = false;
                return false;
            }
        });

        if (flag) {
            var mids  = $("#mids").val();
            myApp.showPreloader('处理中...')
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/posLimit",
                data: {"mids": mids},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.hidePreloader();
                        myApp.alert(data.resultMsg, '提示');
                    } else {
                        if (data.resultData.status == "Q") {
                            myApp.hidePreloader();
                            myApp.alert('当前商编添加成功！','提示',function(){
                                myApp.showPreloader('加载中...');
                                location.href = "<c:url value='/new/m/posLimit/show'/>";
                            });
                        } else {
                            location.href = "<c:url value='/new/m/verify/show?mid='/>" + mids;
                        }
                    }
                }
            });
        }
    });
</script>

</body>
</html>
