<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
    <!-- Status bar overlay for fullscreen mode-->
    <div class="statusbar-overlay"></div>
    <!-- Panels overlay-->
    <div class="panel-overlay"></div>
    <!-- Right panel with cover effect-->
    <div class="panel panel-right panel-reveal">
        <div class="content-block">
            <p>Right panel content goes here</p>
        </div>
    </div>
    <!-- Views-->
    <div class="views">
        <!-- Your main view, should have "view-main" class-->
        <div class="view view-main">
            <!-- Top Navbar-->
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="center sliding">忘记密码</div>
                    <div class="right">
                        <a href="<c:url value='/new/m/login/show'/>">登录</a>
                    </div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="login" class="page">
                    <!-- Scrollable page content-->
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
                                                <input class="login_input" type="text" id="mobile" placeholder="请输入您的手机号">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="pwd_icon"><img src="<c:url value="/resources/newm/images/icon/key.png"/>" width="20"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="text" maxlength="4" id="checkCode" placeholder="请输入验证码">
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
                                                <input class="login_input" type="password" id="password" placeholder="请输入6-16位新密码">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="padding-rl15">
                            <div class="bind-number">
                                <!--检测到没有勾选同意服务条款时，添加class="disabled"-->
                                <a class="button button-big button-fill" href="#" id="submitBtn">确认</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="popup popup-service">
        <div class="content-block">
            <p><a href="#" class="close-popup">关闭</a></p>
            <p>卡得万利服务条款</p>
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
                    $.getJSON(contextPath + "new/m/getCheckCode", {mobile: $("#mobile").val()}, function (data) {
                        if (data == "1") {
                            //表示生成验证码成功
                            var countdown = setInterval(countDown, 1000);//定时器
                            //倒计时
                            function countDown() {
                                $("#getCheckCodeBtn").addClass("disabled");
                                $("#getCheckCodeBtn").html(count + "s");
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
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/forgetPassword",
                data: {"mobile": $("#mobile").val(), "password": $("#password").val(), "checkCode": $("#checkCode").val()},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.alert(data.resultMsg,'提示');
                    } else {
                        myApp.alert("恭喜您，密码修改成功!",'提示',function(){
                            location.href = contextPath + "new/m/login/show";
                        });
                    }
                }
            });

        });

</script>

</body>
</body>
</html>
