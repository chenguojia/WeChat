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
                    <div class="center sliding">登录</div>
                    <div class="right">
                        <%--<a href="<c:url value='/new/m/bind/show'/>">新用户绑定</a>--%>
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
                                                <input class="login_input" type="text" id="mobile" maxlength="11" placeholder="请输入您的手机号">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="icon username_icon"><img src="<c:url value="/resources/newm/images/icon/pwd.png"/>" width="20"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="password" id="password" maxlength="16"  placeholder="请输入6-16位密码">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="padding-rl15">
                            <div class="bind-number">
                                <a class="button button-big button-fill" href="#" id="submitBtn">登录</a>
                            </div>
                            <div class="row margin-t10">
                                <a class="col-50" href="<c:url value='/new/m/forgetPassword/show'/>">忘记密码？</a>
                                <a class="col-50 register_hint" href="<c:url value='/new/m/bind/show'/>">还没账号？</a>
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

            if ($("#password").val() == "") {
                myApp.alert('密码不能为空!', '提示');
                return;
            }

            //验证成功，提交FORM
            myApp.showPreloader('登录中...')
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/login",
                data: {"mobile": $("#mobile").val(), "password": $("#password").val()},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.hidePreloader();
                        myApp.alert(data.resultMsg,'提示');
                    } else {
                        //成功,跳转主控界面
                        location.href = contextPath + "new/m/home";
                    }
                }
            });

        });
</script>

</body>
</body>
</html>
