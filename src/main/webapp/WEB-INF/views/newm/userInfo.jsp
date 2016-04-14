<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/account'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">个人信息</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="list-block uploadfile-block">
                            <ul>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="icon myAccount-username_icon"></span></div>
                                        <div class="item-inner questionCon">
                                            <span>${!empty login_new_merchant.ownerName ? login_new_merchant.ownerName : '亲爱的用户'}</span>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="icon myAccount-phone_icon"></span></div>
                                        <div class="item-inner questionCon">
                                            <span>${!empty login_new_merchant.mobilePhone ? login_new_merchant.mobilePhone : '***********'}</span>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><span class="icon myAccount-account_icon"></span></div>
                                        <div class="item-inner questionCon">
                                            <span>${!empty login_new_merchant.ownerSSN ? login_new_merchant.ownerSSN : '******************'}</span>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <a href="<c:url value='/new/m/updatePassword/show'/>" class="item-link item-content">
                                        <div class="item-media"><span class="icon myAccount-changepass-icon"></span></div>
                                        <div class="item-inner">
                                            <div class="item-title-row">
                                                <div class="item-title">修改密码</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="padding-rl15">
                            <a class="button button-big buttonConfirm quit-but-color" href="#" id="logoutBtn">退出账号</a>
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

    //退出登录
    $("#logoutBtn").click(function () {

        myApp.modal({
            text: '退出后您将不能查看相关信息，确定要退出当前账号吗？',
            buttons: [
                {
                    text: '取消',
                    onClick: function () {
                    }
                },
                {
                    text: '确定',
                    onClick: function () {
                        $.ajax({
                            type: "POST",
                            url: contextPath + "new/m/logout",
                            data: {},
                            success: function (data) {
                                if (data.resultCode == "-1") {
                                    myApp.hidePreloader();
                                    myApp.alert(data.resultMsg, '提示');
                                } else {
                                    //登出
                                    location.href = contextPath + "new/m/j_spring_security_logout";
                                    //关闭微信浏览器，重新获取SESSION
                                    WeixinJSBridge.call('closeWindow');
                                }
                            }
                        });
                    }
                }
            ]
        })

    });

</script>

</body>
</html>