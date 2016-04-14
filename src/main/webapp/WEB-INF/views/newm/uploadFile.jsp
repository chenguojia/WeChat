<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head></head>
<body>
    <!-- Views-->
    <div class="views">
        <!-- Your main view, should have "view-main" class-->
        <div class="view view-main">
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages">
                <!-- Page, data-page contains page name-->
                <div data-page="upload" class="page navbar-fixed">
                     <!-- Top Navbar-->
                    <div class="navbar">
                        <div class="navbar-inner">
                            <div class="left"><a href="<c:url value='/new/m/applyStatus/show'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                            <div class="center">
                                <div class="buttons-row new-apply">
                                    <a href="#" class="tab-link button ${selectedTabIndex == 1 ? 'active' : ''}">申请资料</a>
                                    <a href="#" class="tab-link button ${selectedTabIndex != 1 ? 'active' : ''}" id="uploadFileTab" >上传图片</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Scrollable page content-->
                    <div class="page-content">
                      <!-- Tabs, tabs wrapper -->
                      <div class="tabs">
                        <!-- Tab 1, active by default -->
                        <div id="tab1" class="tab" style="display: ${selectedTabIndex == 1 ? 'block' : 'none'}" >
                            <form id="myform" method="post">
                                <div class="content-block-title">
                                    <span class="glyphicon glyphicon-credit-card wechat-icon-credit-card margin-r05" aria-hidden="true"></span>保理融资需求
                                </div>
                                <div class="list-block uploadfile-block">
                                    <ul>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">意向融资金额(元)</div>
                                                    <div class="item-input">
                                                        <input type="text" id="loanAmount" name="loanAmount" value="${newMerchantUserModel.loanAmount}" placeholder="融资范围为5000~<fmt:formatNumber value="${applicationModel.amountRequested}" type="currency" pattern="#####.##"/>">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">意向融资期限(月)</div>
                                                    <div class="item-input">
                                                        <select name="planFundTerm" id="planFundTerm">
                                                            <option value="">请选择</option>
                                                            <option value="3" ${newMerchantUserModel.planFundTerm == '3' ? 'selected' : ''}>3</option>
                                                            <option value="6" ${newMerchantUserModel.planFundTerm == '6' ? 'selected' : ''}>6</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="item-content">
                                            <div class="item-inner">
                                                <div class="item-title label">用途</div>
                                                <div class="item-input">
                                                    <select name="purposeFactor" id="purposeFactor">
                                                        <option value="">请选择</option>
                                                        <option value="2" ${newMerchantUserModel.purposeFactor == '2' ? 'selected' : ''}>店铺装修</option>
                                                        <option value="3" ${newMerchantUserModel.purposeFactor == '3' ? 'selected' : ''}>购置设备</option>
                                                        <option value="4" ${newMerchantUserModel.purposeFactor == '4' ? 'selected' : ''}>购买库存</option>
                                                        <option value="5" ${newMerchantUserModel.purposeFactor == '5' ? 'selected' : ''}>工资账单</option>
                                                        <option value="6" ${newMerchantUserModel.purposeFactor == '6' ? 'selected' : ''}>广告宣传</option>
                                                        <option value="7" ${newMerchantUserModel.purposeFactor == '7' ? 'selected' : ''}>其它</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="content-block-title">
                                    <span class="glyphicon glyphicon-list-alt wechat-icon-list-alt margin-r05" aria-hidden="true"></span>法定代表人基本信息
                                </div>
                                <div class="list-block uploadfile-block">
                                    <ul>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">身份证号码</div>
                                                    <div class="item-input">
                                                        <input type="text"  name="ownerSSN" id="ownerSSN" value="${newMerchantUserModel.ownerSSN}"  placeholder="例如：511702198606266283">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">固定电话</div>
                                                    <div class="item-input">
                                                        <input type="text"  name="ownerPhone" id="ownerPhone" value="${newMerchantUserModel.ownerPhone}" placeholder="例如：021-60870131">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">现址居住年限</div>
                                                    <div class="item-input">
                                                        <input type="text"  name="ownerResidenceYears" id="ownerResidenceYears" value="${newMerchantUserModel.ownerResidenceYears}" placeholder="例如：1">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">电子邮箱</div>
                                                    <div class="item-input">
                                                        <input type="text" name="ownerEmail" id="ownerEmail" value="${newMerchantUserModel.ownerEmail}" placeholder="例如：zhangsan@163.com">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">住所地址</div>

                                                    <div class="item-input">
                                                        <input type="text" name="ownerAddress" id="ownerAddress"  value="${newMerchantUserModel.ownerAddress}" placeholder="例如：北张家浜路88号">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="content-block-title">
                                    <span class="glyphicon glyphicon-list wechat-icon-list margin-r05" aria-hidden="true"></span>个人详细信息
                                </div>
                                <div class="list-block uploadfile-block">
                                    <ul>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">股权百分比</div>
                                                    <div class="item-input">
                                                        <input type="text" name="ownerPercentage2" id="ownerPercentage2" value="<fmt:parseNumber integerOnly='true' value='${newMerchantUserModel.ownerPercentage2}' />" placeholder="例如：50">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">住宅类别</div>
                                                    <div class="item-input">
                                                        <select  name="apartmentType" id="apartmentType">
                                                            <option value="">请选择</option>
                                                            <option value="自置" ${newMerchantUserModel.apartmentType == '自置' ? 'selected' : ''}>自置</option>
                                                            <option value="按揭" ${newMerchantUserModel.apartmentType == '按揭' ? 'selected' : ''}>按揭</option>
                                                            <option value="租借" ${newMerchantUserModel.apartmentType == '租借' ? 'selected' : ''}>租借</option>
                                                            <option value="父母住宅" ${newMerchantUserModel.apartmentType == '父母住宅' ? 'selected' : ''}>父母住宅</option>
                                                            <option value="其它" ${newMerchantUserModel.apartmentType == '其它' ? 'selected' : ''}>其它</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">婚姻状况</div>
                                                    <div class="item-input">
                                                        <select name="opratorMaritalStatus" id="opratorMaritalStatus">
                                                            <option value="">请选择</option>
                                                            <option value="已婚" ${newMerchantUserModel.opratorMaritalStatus == '已婚' ? 'selected' : ''}>已婚</option>
                                                            <option value="未婚" ${newMerchantUserModel.opratorMaritalStatus == '未婚' ? 'selected' : ''}>未婚</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">非同住亲友姓名</div>
                                                    <div class="item-input">
                                                        <input type="text" name="owner2NearestRelativeName" id="owner2NearestRelativeName" value="${newMerchantUserModel.owner2NearestRelativeName}" placeholder="例如：张三">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">非同住亲友手机</div>
                                                    <div class="item-input">
                                                        <input type="text" name="owner2RelativePhone" id="owner2RelativePhone"  value="${newMerchantUserModel.owner2RelativePhone}" placeholder="例如：18600120000">
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="padding-rl15">
                                    <a class="button button-fill button-big" href="#" id="saveBtn">保存</a>
                                </div>
                            </form>
                        </div>


                        <!-- Tab 2 -->
                        <div id="tab2" class="tab" style="display: ${selectedTabIndex != 1 ? 'block' : 'none'}" >

                            <%--正式分组数据--%>
                            <c:forEach var="item" items="${uploadFileMainModels}">
                                <div class="content-block-title">
                                    <span class="glyphicon glyphicon-picture wechat-icon-picture margin-r05" aria-hidden="true"></span>
                                    <span class="uf-title">${item.title}</span>
                                </div>
                                <div class="list-block media-list uploadfile-block">
                                    <ul>
                                        <c:forEach var="childItem" items="${item.items}">
                                            <li>
                                                <a href="<c:url value='/new/m/uploadFileDetail/show?groupName=${childItem.title}'/>" class="item-link item-content">
                                                    <div class="item-inner">
                                                        <div class="item-title-row">
                                                            <div class="item-title">${childItem.title}</div>
                                                            <c:if test="${!empty childItem.lackFiles && childItem.lackFiles != '0'}">
                                                                <div class="item-after"><span class="badge bg-red" stitle="${childItem.title}">${childItem.lackFiles}</span></div>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </c:forEach>

                            <div class="padding-rl15">
                                <a class="button button-fill button-big" id="submitBtn" >提交申请</a>
                            </div>
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

    //点击上传图片TAB
    $(".tab-link").click(function(){
        if ($(this).html() == "上传图片") {
            saveBasicInfo($(this),"tab");
        } else {
            $(".tab-link.active").removeClass("active");
            $(this).addClass("active");
            $("#tab2").hide();
            $("#tab1").show();
        }
    });

    //点击保存基本信息按钮
    $("#saveBtn").click(function(){
        saveBasicInfo($(this),"button");
    });


    //逝去焦点以后验证融资额度
    $("#loanAmount").blur(function(){
        var reg = /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
        if ($("#loanAmount").val() != "" && !reg.test($("#loanAmount").val())) {
            myApp.alert('意向融资金额不合法!', '提示');
            return;
        }

        if (parseFloat($("#loanAmount").val()) < parseFloat("5000")) {
            myApp.confirm('融资金额至少为<font color="red">5000</font>元!如您的授信额度不足5000元，您可以添加更多的POS商编来提高的您当前额度!是否马上进行添加新商编？', '提示',function() {
                location.href = "<c:url value='/new/m/posLimit/show'/>";
            });
            return;
        }

        if (parseFloat($("#loanAmount").val()) > parseFloat("${applicationModel.amountRequested}")) {
            myApp.alert('您的融资金额最大为<font color="red">' + parseInt(${applicationModel.amountRequested}) + '</font>元!请修改您的额度!', '提示');
            return;
        }
    });

    /**
     * 公共的保存第一个TAB方法
     * @param eventType 表示触发此方法的事件源
     */
    function saveBasicInfo(eventObj,eventType) {

        var reg = /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
        if ($("#loanAmount").val() != "" && !reg.test($("#loanAmount").val())) {
            myApp.alert('意向融资金额不合法!', '提示');
            return;
        }

        if (parseFloat($("#loanAmount").val()) < parseFloat("5000")) {
            myApp.confirm('融资金额至少为<font color="red">5000</font>元!如您的授信额度不足5000元，您可以添加更多的POS商编来提高的您当前额度!是否马上进行添加新商编？', '提示',function() {
                location.href = "<c:url value='/new/m/posLimit/show'/>";
            });
            return;
        }

        if (parseFloat($("#loanAmount").val()) > parseFloat("${applicationModel.amountRequested}")) {
            myApp.alert('您的融资金额最大为<font color="red">' + parseInt(${applicationModel.amountRequested}) + '</font>元!请修改您的额度!!', '提示');
            return;
        }

        // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
        reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if ($("#ownerSSN").val() != "" && !reg.test($("#ownerSSN").val())) {
            myApp.alert('身份证号码不合法!', '提示');
            return;
        }

        reg = /^0\d{2,3}-?\d{7,8}$/;
        if ($("#ownerPhone").val() != "" && !reg.test($("#ownerPhone").val())) {
            myApp.alert('固定电话不合法!', '提示');
            return;
        }

        reg = /^[1-9]*[1-9][0-9]*$/;
        if ($("#ownerResidenceYears").val() != "" && !reg.test($("#ownerResidenceYears").val())) {
            myApp.alert('居住年限不合法!', '提示');
            return;
        }

        reg = /^[1-9]*[1-9][0-9]*$/;
        if ($("#ownerPercentage2").val() != "" && !reg.test($("#ownerPercentage2").val())) {
            myApp.alert('股权百分比不合法!', '提示');
            return;
        }

        reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        if ($("#ownerEmail").val() != "" && !reg.test($("#ownerEmail").val())) {
            myApp.alert('邮箱不合法!', '提示');
            return;
        }

        var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if ($("#owner2RelativePhone").val() != "" && !reg.test($("#owner2RelativePhone").val())) {
            myApp.alert('非同住亲友手机不合法!', '提示');
            return;
        }

        myApp.showPreloader('保存中...')
        $.ajax({
            type: "POST",
            url: contextPath + "new/m/updateUser",
            data:$('#myform').serialize(),
            success: function (data) {
                myApp.hidePreloader();
                if (data.resultCode == "-1") {
                    myApp.alert(data.resultMsg,'提示');
                } else {
                    //成功,跳转主控界面
                    if (eventType == "button") {
                        myApp.confirm('申请资料保存成功，请继续上传图片！是否继续？','提示',function() {
                            $(".tab-link.active").removeClass("active");
                            $("#uploadFileTab").addClass("active");
                            $("#tab1").hide();
                            $("#tab2").show();
                        });
                    } else {
                        $(".tab-link.active").removeClass("active");
                        eventObj.addClass("active");
                        $("#tab1").hide();
                        $("#tab2").show();
                    }

                }
            }
        });
    }


    $("#submitBtn").click(function(){

        //判断需要补件的文件是否都上传了....
        var flag = true;
        $(".badge").each(function(){
            if (parseInt($(this).html()) > 0) {
                myApp.alert($(this).attr("stitle") + "还剩" + $(this).html()  + "张未上传!", "提示");
                flag = false;
                return false;
            }
        });

        if (flag) {
            //判断申请资料TAB是否有填写完整
            $("input").each(function(){
                if ($(this).val() == "" && $(this).attr("id") != "ownerPhone") {
                    var currentFild = $(this);
                    var filedName = $(this).parent().prev().html();
                    myApp.confirm('请完善‘申请资料’中的“'+ filedName +'”信息后再进行提交！是否马上进行完善？','提示',function(){
                        //切换TAB
                        var chooseTabObj =   $(".tab-link.active");
                        var unChooseTabObj = $(".tab-link:not([class='active'])");
                        unChooseTabObj.addClass("active");
                        chooseTabObj.removeClass("active");
                        $("#tab2").hide();
                        $("#tab1").show();
                        currentFild.focus();
                    });
                    flag = false;
                    return false;
                }
            });
        }

        if (flag) {
            $("select").each(function(){
                if ($(this).val() == "") {
                    var currentFild = $(this);
                    var filedName = $(this).parent().prev().html();
                    myApp.confirm('请完善‘申请资料’中的“'+ filedName +'”信息后再进行提交！是否马上进行完善？','提示',function(){
                        //切换TAB
                        var chooseTabObj =   $(".tab-link.active");
                        var unChooseTabObj = $(".tab-link:not([class='active'])");
                        unChooseTabObj.addClass("active");
                        chooseTabObj.removeClass("active");
                        $("#tab2").hide();
                        $("#tab1").show();
                        currentFild.focus();
                    });
                    flag = false;
                    return false;
                }
            });
        }

        //判断聚信立是否验证
        if (flag) {
            if ("${newMerchantUserModel.isJxlValid == '1'}" != 'true') {
                myApp.confirm('您还未进行手机验证！是否马上进行验证？','提示',function() {
                    location.href = "<c:url value='/new/m/juxinliLimit/show'/>";
                });
                flag = false;
            }
        }

        if (flag) {
            myApp.confirm('您确定提交申请吗？','提示',function() {
                myApp.showPreloader('提交中...')
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/uploadFile",
                    data: {},
                    success: function (data) {
                        if (data.resultCode == "-1") {
                            myApp.hidePreloader();
                            myApp.alert(data.resultMsg,'提示');
                        } else {
                            location.href = contextPath + "new/m/applyStatus/show";
                        }
                    }
                });
            });
        }

    });
</script>

</body>
</html>
