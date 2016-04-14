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
                <div class="left"><a href="<c:url value='/new/m/userInfo/show'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">修改密码</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="content-block login">
                            <div class="list-block">
                                <ul>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="icon changeCode-pwd_icon"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="password" maxlength="16" id="oldPassword" name="oldPassword" placeholder="当前密码">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="changeCode-username_icon"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="password" maxlength="16" id="newPassword"  name="newPassword" placeholder="新密码">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content border-bottom">
                                        <div class="item-media">
                                            <span class="icon changeCode-username_icon"></span>
                                        </div>
                                        <div class="item-inner">
                                            <div class="item-title">
                                                <input class="login_input" type="password"  maxlength="16"  id="newPasswordRepete"  name="newPasswordRepete" placeholder="确认新密码">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="padding-rl15">
                            <a class="button button-fill button-big buttonConfirm" href="#" id="submitBtn">确认</a>
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


    //提交
    $("#submitBtn").click(function () {

        if ($("#oldPassword").val() == "") {
            myApp.alert('当前密码不能为空!', '提示');
            return;
        }

        if ($("#newPassword").val() == "") {
            myApp.alert('新密码不能为空!', '提示');
            return;
        }

        if ($("#newPasswordRepete").val() == "") {
            myApp.alert('确认新密码不能为空!', '提示');
            return;
        }

        if ($("#newPassword").val() != $("#newPasswordRepete").val()) {
            myApp.alert('新密码两次输入不一致!!', '提示');
            return;
        }

        //验证成功，提交FORM
        myApp.showPreloader('处理中....')
        $.ajax({
            type: "POST",
            url: contextPath + "new/m/updatePassword",
            data: {"oldPassword": $("#oldPassword").val(), "newPassword": $("#newPassword").val()},
            success: function (data) {
                if (data.resultCode == "-1") {
                    myApp.hidePreloader();
                    myApp.alert(data.resultMsg,'提示');
                } else {
                    myApp.hidePreloader();
                    myApp.alert('密码修改成功','提示',function(){
                        location.href = contextPath + "new/m/userInfo/show";
                    });
                }
            }
        });

    });
</script>

</body>
</html>