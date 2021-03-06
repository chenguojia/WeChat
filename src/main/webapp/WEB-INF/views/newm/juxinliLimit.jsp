<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
    <!-- Views-->
    <div class="views">
        <!-- Your main view, should have "view-main" class-->
        <div class="view view-main">
            <!-- Top Navbar-->
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="left"><a href="<c:url value='/new/m/myLimit'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                    <div class="center sliding">手机验证</div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="index" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content">
                        <form  method="post" id="myform">
                            <%--<input type="hidden" name="isHaveCheckCode" id="isHaveCheckCode" value=""/>--%>
                            <input type="hidden" name="token" id="token" value=""/>
                            <input type="hidden" name="website" id="website" value=""/>
                            <div class="list-block uploadfile-block">
                                 <ul>

                                     <li class="item-content">
                                         <div class="item-inner">
                                             <div class="item-title label">真实姓名</div>
                                             <div class="item-input">
                                                 <input type="text" name="ownerName" id="ownerName" placeholder="例如：张三" value="${newMerchantUserModel.ownerName}"/>
                                             </div>
                                         </div>
                                     </li>


                                     <li class="item-content">
                                         <div class="item-inner">
                                             <div class="item-title label">身份证号</div>
                                             <div class="item-input">
                                                 <input type="text" name="ownerSSN" id="ownerSSN" placeholder="例如：420923198712121001" value="${newMerchantUserModel.ownerSSN}"/>
                                             </div>
                                         </div>
                                     </li>

                                     <li class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title label">手机号码</div>
                                            <div class="item-input">
                                                ${newMerchantUserModel.mobilePhone}
                                            </div>
                                        </div>
                                     </li>

                                     <li class="item-content">
                                         <div class="item-inner">
                                             <div class="item-title label">手机6位服务密码</div>
                                             <div class="item-input">
                                                 <input type="password" name="servicePassword" id="servicePassword" placeholder="" value="" maxlength="6"/>

                                             </div>
                                         </div>
                                     </li>

                                     <li class="item-content" id="servicePasswordLi" style="display:none;">
                                         <div class="item-inner">
                                             <div class="item-title label">运营商验证码</div>
                                             <div class="item-input">
                                                 <input type="text" name="checkCode" id="checkCode" placeholder="例如：123456" value=""/>
                                                 <%--<button class="get_verti button button-round" type="button" id="getCheckCodeBtn" style="margin-top:8px;margin-right:5px;" >获取验证码</button>--%>
                                             </div>
                                         </div>
                                     </li>
                                 </ul>
                            </div>
                        </form>
                        <div class="padding-rl15 font12">
                            <p>如无法确认手机6位服务密码，请联系手机运营商，提供身份证号码即可查询和修改。</p>
                            手机认证即收集您号码的基本信息、账单信息、通话记录、上网记录、短信详单等用于认证服务。运营商会发短信告知您，我们从网上营业厅查询过您的详单，这是我们认证您信息的正常过程。
                        </div>
                    </div>
                </div>
            </div>
            <div class="toolbar tabbar tabbar-labels">
                <div class="toolbar-inner">
                    <a class="button button-fill toolbar-btn" href="#" id="submitBtn">提交</a>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        var myApp = new Framework7({
            modalTitle: '卡得万利商业保理',
            ajaxLinks: 'a.ajax'
        });


        //获取验证码
        var count = 60;
        $("#getCheckCodeBtn").click(function () {

            //校验
            if (validateInput() == false) return;
            var beginDate = new Date();
            myApp.showPreloader('获取验证码中...')
            //获取验证码
            $.ajax({
                type: "POST",
                url: "${wsJxlUrl}/getverifycode",
                dataType: 'json',
                data: {
                    "name":$("#ownerName").val(),
                    "id_card_num":$("#ownerSSN").val(),
                    "account":${newMerchantUserModel.mobilePhone},
                    "password":$("#servicePassword").val()
                },
                success: function (data) {
                    var endDate = new Date();
                    console.log(beginDate);
                    console.log(endDate);
                    myApp.hidePreloader();
                    if (data.success == "true" && data.data.process_code == "10002") {
                        $("#token").val(data.data.token);//保存token
                        $("#website").val(data.data.website);//保存website
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
                        $("#token").val(data.data.token);//保存token
                        $("#website").val(data.data.website);//保存website
                        myApp.alert(data.data.content, '提示');
                    }
                },timeout: 300000,
                error: function(jqXHR, textStatus){
                    console.log(jqXHR);
                    console.log(textStatus);
                    myApp.hidePreloader();
                    myApp.alert("获取验证码出错,请稍后再试!", '提示');
                }
            });

        });

        function validateInput() {
            if ($("#ownerName").val() == "") {
                myApp.alert('真实姓名不能为空!', '提示');
                return false;
            }

            if ($("#ownerSSN").val() == "") {
                myApp.alert('身份证号不能为空!', '提示');
                return false;
            }

            // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
            reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if ($("#ownerSSN").val() != "" && !reg.test($("#ownerSSN").val())) {
                myApp.alert('身份证号码不合法!', '提示');
                return false;
            }

            if ($("#servicePassword").val() == "") {
                myApp.alert('手机6位服务密码不能为空!', '提示');
                return false;
            }

            var reg = /^\d{6}$/;
            if (!reg.test($("#servicePassword").val())) {
                myApp.alert('手机服务密码必须为6位数字!!', '提示');
                return false;
            }

            return true;
        }

        //提交
        $("#submitBtn").click(function () {

            if (validateInput() == false) return;

            if ($("#servicePasswordLi").css("display") != "none") {
                if ($("#checkCode").val() == "") {
                    myApp.alert('聚信立验证码不能为空!', '提示');
                    return;
                }

                if ($("#token").val() == "") {
                    myApp.alert('您的验证码不合法请点击获取验证码', '提示');
                    return;
                }
            }

            myApp.confirm('您确定提交吗？', '提示', function () {
                myApp.showPreloader('提交中...可能需要等待一会，请不要退出此页面!')
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/juxinliLimit",
                    data: $('#myform').serialize(),
                    success: function (data) {
                        if (data.resultCode == "-1") {
                            myApp.hidePreloader();
                            if (data.resultData != null) {
                                //表示第一次获取聚信立验证码后台返回错误信息
                                $("#token").val(data.resultData.token);//保存token
                                $("#website").val(data.resultData.website);//保存website
                            }
                            myApp.alert(data.resultMsg, '提示'); //提示
                        } else {
                            myApp.hidePreloader();
                            if (data.resultData != null) {
                                myApp.alert('请继续填写您收到的短信验证码!', '提示',function(){
                                    //表示第一次不知道有验证码提交情况，返回当前手机号码需要输入运行验证码
                                    $("#servicePasswordLi").show();//表示需要输入验证码提示
                                    $("#token").val(data.resultData.token);//保存token
                                    $("#website").val(data.resultData.website);//保存website
                                });
                            } else {
                                //表示第二次提交直接成功
                                myApp.alert('验证成功!', '提示',function(){
                                    //成功,跳转主控界面
                                    location.href = contextPath + "new/m/myLimit";
                                });
                            }
                        }
                    },timeout: 300000,
                    error: function(jqXHR, textStatus){
                        console.log(jqXHR);
                        console.log(textStatus);
                        myApp.hidePreloader();
//                        myApp.alert("提交出错,请稍后再试!", '提示');
                        myApp.alert("提交出错,请稍后再试!"+ jqXHR + textStatus, '提示');
                    }
                });
            });

        });
</script>
</body>
</html>
