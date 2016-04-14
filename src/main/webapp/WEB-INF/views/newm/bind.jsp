<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
    <div class="statusbar-overlay"></div>
    <div class="panel-overlay"></div>
    <div class="panel panel-right panel-reveal">
        <div class="content-block">
            <p>Right panel content goes here</p>
        </div>
    </div>
    <div class="views">
        <div class="view view-main">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="center sliding">新用户注册</div>
                    <div class="right">
                        <a href="<c:url value='/new/m/login/show'/>">立即登录</a>
                    </div>
                </div>
            </div>
            <div class="pages navbar-through toolbar-through">
                <div data-page="login" class="page">
                    <div class="page-content">
                        <div class="content-block login">

                            <div class="list-block">
                                <ul>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img src="<c:url value="/resources/newm/images/icon/phone.png"/>" width="20"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="text" maxlength="11" id="mobile" placeholder="请输入您的手机号">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="pwd_icon"><img src="<c:url value="/resources/newm/images/icon/key.png"/>" width="20"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="text" maxlength="4"  id="checkCode" placeholder="请输入验证码">
                                                <button class="get_verti button button-round" type="button" id="getCheckCodeBtn" >获取验证码</button>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img src="<c:url value="/resources/newm/images/icon/pwd.png"/>" width="20"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="password" id="password"  maxlength="16" placeholder="请输入6-16位初始密码">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="padding-rl15">
                            <div>
                                <input id="agree-terms" type="checkbox" checked />
                                <label for="agree-terms">同意<a class="open-popup" data-popup=".popup-register" href="#" onClick="popClose()">卡得万利注册协议</a>和<a class="open-popup" data-popup=".popup-privacy" href="#" onClick="popClose()">隐私协议</a></label>
                            </div>
                            <div class="bind-number">
                                <!--检测到没有勾选同意服务条款时，添加class="disabled"-->
                                <a class="button button-big button-fill" href="#" id="submitBtn">注册</a>
                            </div>
                            <%--<p><a href="<c:url value='/new/m/login/show'/>">已有账号用户登录</a></p>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--注册协议内容--%>
    <div class="popup popup-register">
        <div class="content-block register-padding">
            <jsp:include page="/new/m/clause/register"/>
        </div>
    </div>
    <%--协议关闭按钮--%>
    <div class="close-display display-none">
        <div class="close-line-height"></div>
        <a href="#" class="close-popup padding-l10" onClick="$('.close-display').addClass('display-none')">关闭</a>
    </div>
    <%--隐私协议内容--%>
    <div class="popup popup-privacy">
        <div class="content-block register-padding">
            <jsp:include page="/new/m/clause/privacy"/>
        </div>
    </div>

    <script>
        var myApp = new Framework7({
            modalTitle: '卡得万利商业保理',
            ajaxLinks: 'a.ajax'
        });

        //获取验证码
        var count = 60;
        $("#getCheckCodeBtn").click(function () {
            if ($("#mobile").val() != "") {
                //验证手机号是否合法
                var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                if (reg.test($("#mobile").val())) {
                    //成功，发送验证码
                    //获取验证码
                    $("#getCheckCodeBtn").addClass("disabled");
                    $.getJSON(contextPath + "new/m/getCheckCode", {mobile: $("#mobile").val()}, function (data) {
                        if (data == "1") {
                            //表示生成验证码成功
                            var countdown = setInterval(countDown, 1000);//定时器
                            //倒计时
                            function countDown() {
                                $("#getCheckCodeBtn").html(count + " s");
                                if (count == 0) {
                                    $("#getCheckCodeBtn").removeClass("disabled");
                                    $("#getCheckCodeBtn").html("重新发送");
                                    clearInterval(countdown);
                                    count = 60;
                                }
                                count--;
                            }
                        } else {
                            myApp.alert("验证码生成异常，请重新获取!", '提示');
                        }
                    });
                } else {
                    myApp.alert('手机号码不合法!', '提示');
                }
            } else {
                myApp.alert('手机号码不能为空!', '提示');
            }
        });

        //同意条款
        $("#agree-terms").change(function () {
            if ($(this).is(":checked")) {
                $("#submitBtn").removeClass("disabled");
            } else {
                $("#submitBtn").addClass("disabled");
            }
        });

        //提交
        $("#submitBtn").click(function () {

            if ($("#mobile").val() == "") {
                myApp.alert('手机号码不能为空!', '提示');
                return;
            }

            var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            if (!reg.test($("#mobile").val())) {
                myApp.alert('手机号码不合法!', '提示');
                return;
            }

            if ($("#checkCode").val() == "") {
                myApp.alert('验证码不能为空!', '提示');
                return;
            }

            if ($("#password").val() == "") {
                myApp.alert('初始密码不能为空!', '提示');
                return;
            }

            //验证成功，提交FORM
            myApp.showPreloader('注册中...')
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/bind",
                data: {"mobile": $("#mobile").val(), "password": $("#password").val(), "checkCode": $("#checkCode").val()},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.hidePreloader();
                        myApp.alert(data.resultMsg,'提示');
                    } else {
                        //成功,跳转主控界面
                        if (data.resultData == "1") {
                            location.href = contextPath + "new/m/home";//同意条款跳转到首页
                        } else {
                            location.href = contextPath + "new/m/accredit/show";//未同意条款
                        }
                    }
                }
            });

        });
</script>

</body>
</html>
