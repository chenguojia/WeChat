<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
    <%--swipe slider banner滑动--%>
    <script type="text/javascript" src="<c:url value='/resources/script/swipe-slider/swipe.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/resources/script/swipe-slider/swipe.css'/>"/>
</head>
<body>
    <div data-role="page" class="home">
        <div data-role="header" class="ui-header">
            <div class="home-header">卡得万利商业保理</div>
            <div class="home-banner page-swipe">
                <section>
                    <div id="slider" class="swipe" style="visibility: visible;">
                        <div class="swipe-wrap">
                            <figure>
                                <div class="wrap">
                                    <div class="image banner1"></div>
                                </div>
                            </figure>
                            <figure>
                                <div class="wrap">
                                    <div class="image banner2"></div>
                                </div>
                            </figure>
                            <figure>
                                <div class="wrap">
                                    <div class="image banner3"></div>
                                </div>
                            </figure>
                        </div>
                    </div>
                    <nav>
                        <ul id="position">
                            <li class="on"></li>
                            <li class=""></li>
                            <li class=""></li>
                        </ul>
                    </nav>
                </section>
            </div>
        </div>
        <div role="main" class="home-content">
            <div class="ui-grid-a home-gird-a">
                <a class="ui-block-a home-block"  href="<c:url value='/m/showApply'/>">
                    <div class="home-icon apply-fund"></div>
                    <p class="block-txt">申请融资</p>
                </a>
                <a class="ui-block-b home-block" href="<c:url value='/m/myAccount'/>">
                    <div class="home-icon my-account"></div>
                    <p class="block-txt">我的账户</p>
                </a>
            </div>
            <div class="ui-grid-a home-gird-a">
                <a class="ui-block-a home-block" href="<c:url value='/m/showRefer'/>">
                    <div class="home-icon submit-clue"></div>
                    <p class="block-txt">转介申请</p>
                </a>
                <a class="ui-block-b home-block" href="<c:url value='/m/creditShow'/>">
                    <div class="home-icon fund-limit"></div>
                    <p class="block-txt">融资额度</p>
                </a>
            </div>
            <div class="ui-grid-a home-gird-a last">
                <a class="ui-block-a home-block" href="<c:url value='/m/applyStatus'/>">
                    <div class="home-icon apply-status"></div>
                    <p class="block-txt">申请状态</p>
                </a>
                <a class="ui-block-b home-block" href="<c:url value='/m/help'/>">
                    <div class="home-icon help-center"></div>
                    <p class="block-txt">帮助中心</p>
                </a>
            </div>
        </div>
        <%--判断是否认证--%>
        <div class="overlay"></div>
        <div class="agreement">
            <div class="header"></div>
            <div data-role="fieldcontain" class="agreementcontainer">
                <h3>卡得万利商户授权协议</h3>
                <p>尊敬的用户，欢迎您首次登录卡得万利商业保理官方微信服务号商户中心。</p>
                <p>卡得万利商业保理（上海）有限公司（以下简称卡得万利）是国家商业保理试点企业和政府中小企业服务机构，致力于激活百万商户的亿万账款资源，推动金融创新，最终实现小微商户融资无门槛。</p>
                <p>为了及时、有效地为您提供融资服务，贵方授权允许我们调取您POS机历史交易流水记录用于保理业务的预授信额度的核定，同时卡得万利有责任对您的交易记录进行保密处理。</p>
                <p>免责声明：如发生在进入、浏览和使用本微信服务号或从本微信服务号下载任何内容而导致病毒或其他破坏性程序对您的电脑系统以及其他任何软件、硬件、IT系统或财产的损害或损失，我方将不承担任何责任。</p>
            </div>
            <div data-role="fieldcontain" class="agree">
                <input id="authorization" name="authorization " type="checkbox">
                <label for="authorization">同意授权卡得万利使用注册商户的交易流水数据</label>
            </div>
            <div data-role="fieldcontain" class="closeagreement">
                <input id="dynamic_button_new" name="submit" type="submit" value="确认" disabled/>
            </div>
        </div>
    </div>
	<script>
        //banner swipe slider
        $(document).on('pageshow', function () {
            var slider =
                    Swipe(document.getElementById('slider'), {
                        auto: 3000,
                        continuous: true,
                        callback: function (pos) {
                            var i = bullets.length;
                            while (i--) {
                                bullets[i].className = ' ';
                            }
                            bullets[pos].className = 'on';
                        }
                    });
            var bullets = document.getElementById('position').getElementsByTagName('li');
        });

         var merchantIsNotNull = "${merchant}" == "" ? false : true; //如果为false表示还没有认证，只注册了。
         var authorizationFlag = "${merchant.authorizationFlag}" == "true" ? true : false;
         var merchantStatus = "${merchant.activeStatus}" == "2" ? true : false;//表示商户已经激活
         var sliderBox=document.getElementById('scroll_img');
         $(".home").on('pageinit', function(){
             if(merchantIsNotNull == true && authorizationFlag == false && merchantStatus == true){
                 setTimeout("showagree($('.agreement'))",500);
                $("#authorization").change(function(){
                    if($("#authorization").is(":checked")){
                       $("#dynamic_button_new").button('enable');
                    }else{
                       $("#dynamic_button_new").button('disable');
                    }
                    $("#dynamic_button_new").button('refresh');
                });

                $("#dynamic_button_new").click(function(){
                    $.getJSON('<c:url value="/m/authorize"/>', function(data){
                        if(data == 1){
                            $(".agreement").hide();
                            $(".overlay").hide();
                        }
                    });
                });
             }
        });

        function showagree(obj){
            var windowWidth = $(window).width(),
            popupWidth = ($(window).width())*0.95;
            posiLeft = (windowWidth - popupWidth)/2;
            obj.css({"left": posiLeft + "px","top":"10px","display":"block"});
            $(".overlay").show();
        }

    </script>
</body>
</html>