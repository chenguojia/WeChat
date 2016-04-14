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
                    <div class="center sliding">基础资料</div>
                </div>
            </div>
            <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
            <div class="pages navbar-through toolbar-through">
                <!-- Page, data-page contains page name-->
                <div data-page="index" class="page">
                    <!-- Scrollable page content-->
                    <div class="page-content">
                        <form  method="post" id="myform">
                            <div class="content-block-title">
                                <span class="glyphicon glyphicon-list wechat-icon-list margin-r05" aria-hidden="true"></span>必填信息
                            </div>
                            <div class="list-block uploadfile-block">
                                 <ul>
                                     <li>
                                         <div class="item-content">
                                             <div class="item-inner">
                                                 <div class="item-title label">所属行业</div>
                                                 <div class="item-input row wechat-select">
                                                     <div class="col-50">
                                                         <select class="select-inner"id="industryPId" name="industryPId">
                                                             <option value="">请选择</option>
                                                             <c:forEach var="item" items="${industryPIds}">
                                                                 <option value="${item.id}"  ${newMerchantUserModel.industryPId == item.id ? 'selected' : ''} >${item.title}</option>
                                                             </c:forEach>
                                                         </select>
                                                     </div>
                                                     <div class="col-50">
                                                         <select class="select-inner" id="industryCId" name="industryCId">
                                                             <option value="">请选择</option>
                                                         </select>
                                                     </div>
                                                 </div>
                                             </div>
                                         </div>
                                     </li>
                                    <li>
                                        <div class="item-content">
                                            <div class="item-inner">
                                                <div class="item-title label">是否有营业执照</div>
                                                <div class="item-input">
                                                    <select id="hasBusinessLicense" name="hasBusinessLicense">
                                                        <option value="" ${newMerchantUserModel.hasBusinessLicense != '1' ? 'selected' : ''}>请选择</option>
                                                        <option value="1" ${newMerchantUserModel.hasBusinessLicense == '1' ? 'selected' : ''}>有</option>
                                                        <%--<option value="0" ${newMerchantUserModel.hasBusinessLicense == '0' ? 'selected' : ''}>无</option>--%>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li id="bizStartDateLi" style="display:${newMerchantUserModel.hasBusinessLicense == '1' ? 'block' : 'none'}">
                                    <%--<li id="bizStartDateLi">--%>
                                        <div class="item-content">
                                            <div class="item-inner">
                                                <div class="item-title label">营业执照发照日期</div>
                                                <div class="item-input">
                                                    <input type="text" placeholder="请选择日期" readonly id="bizStartDate" name="bizStartDate" value="${newMerchantUserModel.bizStartDate}">
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title label">所在城市</div>
                                            <div class="item-input row wechat-select">
                                                <div class="col-50">
                                                    <select class="select-inner" id="provinceId" name="provinceId">
                                                        <option value="">请选择</option>
                                                        <c:forEach var="item" items="${provinceIds}">
                                                            <option value="${item.id}" ${newMerchantUserModel.provinceId == item.id ? 'selected' : ''} >${item.title}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-50">
                                                    <select class="select-inner" id="cityId" name="cityId">
                                                        <option value="">请选择</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title label">实体门店数</div>
                                            <div class="item-input">
                                                <input type="number" name="numLocations" id="numLocations" placeholder="例如：5" value="${newMerchantUserModel.numLocations}"/>
                                            </div>
                                        </div>

                                    </li>
                                    <li>
                                        <div class="item-content">
                                            <div class="item-inner">
                                                <div class="item-title label">营业面积(m²)</div>
                                                <div class="item-input">
                                                    <select id="surveySquareFootage" name="surveySquareFootage">
                                                        <option value="">请选择</option>
                                                        <option value="500+" ${newMerchantUserModel.surveySquareFootage == '500+' ? 'selected' : ''}>500+</option>
                                                        <option value="150-500" ${newMerchantUserModel.surveySquareFootage == '150-500' ? 'selected' : ''}>150-500</option>
                                                        <option value="50-150" ${newMerchantUserModel.surveySquareFootage == '50-150' ? 'selected' : ''}>50-150</option>
                                                        <option value="30-50" ${newMerchantUserModel.surveySquareFootage == '30-50' ? 'selected' : ''}>30-50</option>
                                                        <option value="0-30" ${newMerchantUserModel.surveySquareFootage == '0-30' ? 'selected' : ''}>0-30</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <div class="basic-limit-note">
                                    <span class="margin-b05 displayblock">1. 实体门店数为同一营业执照下的门店数</span>
                                    <span>2. 营业面积为以上门店数的总面积</span>
                                </div>
                            </div>
                            <div class="content-block-title">
                                <span class="glyphicon glyphicon-list-alt wechat-icon-list-alt margin-r05" aria-hidden="true"></span>选填信息
                            </div>
                            <div class="list-block uploadfile-block">
                                <ul>
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title label">学历</div>
                                            <div class="item-input">
                                                <select name="opratorAcdQua" id="opratorAcdQua">
                                                    <option value="">请选择</option>
                                                    <option value="硕士及以上"  ${newMerchantUserModel.opratorAcdQua == '硕士及以上' ? 'selected' : ''}>硕士及以上</option>
                                                    <option value="本科"  ${newMerchantUserModel.opratorAcdQua == '本科' ? 'selected' : ''}>本科</option>
                                                    <option value="大专"  ${newMerchantUserModel.opratorAcdQua == '大专' ? 'selected' : ''}>大专</option>
                                                    <option value="高中/中专"  ${newMerchantUserModel.opratorAcdQua == '高中/中专' ? 'selected' : ''}>高中/中专</option>
                                                    <option value="初中及以下"  ${newMerchantUserModel.opratorAcdQua == '初中及以下' ? 'selected' : ''}>初中及以下</option>
                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title label">户口所在地</div>
                                            <div class="item-input">
                                                <select name="opratorIsLocal" id="opratorIsLocal">
                                                    <option value="">请选择</option>
                                                    <option value="是" ${newMerchantUserModel.opratorIsLocal == '是' ? 'selected' : ''}>本地</option>
                                                    <option value="否" ${newMerchantUserModel.opratorIsLocal == '否' ? 'selected' : ''}>外地</option>
                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item-content">
                                        <div class="item-inner">
                                            <div class="item-title label">门店物业性质</div>
                                            <div class="item-input">
                                                <select name="tenementNature" id="tenementNature">
                                                    <option value="">请选择</option>
                                                    <option value="自置物业" ${newMerchantUserModel.tenementNature == '自置物业' ? 'selected' : ''}>自置物业</option>
                                                    <option value="租借" ${newMerchantUserModel.tenementNature == '租借' ? 'selected' : ''}>租借</option>
                                                    <option value="其它" ${newMerchantUserModel.tenementNature == '其它' ? 'selected' : ''}>其它</option>
                                                </select>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <%--兼容安卓选择门店数键盘遮挡问题--%>
                            <div class="padding-rl15">
                                <a class="button button-fill toolbar-btn" href="#" id="submitBtn">提交</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        var myApp = new Framework7({
            modalTitle: '卡得万利商业保理',
            ajaxLinks: 'a.ajax'
        });

        // Calendar picker
        var calendarDateFormat = myApp.calendar({
            input: '#bizStartDate',
            dateFormat: 'yyyy-MM-dd',
            onDayClick:function(){
                calendarDateFormat.close();
            }
        });


        if ("${!empty newMerchantUserModel.provinceId}" == "true") {
            refreshCitys("${newMerchantUserModel.provinceId}");
        }
        if ("${!empty newMerchantUserModel.industryPId}" == "true") {
            refreshIndustryCId("${newMerchantUserModel.industryPId}");
        }

        //判断有误选择营业执照
        $("#hasBusinessLicense").change(function(){
            if ($(this).val() == "1") {
                $("#bizStartDateLi").show();
            } else {
                $("#bizStartDateLi").hide();
            }
        });

        //根据一级行业查询二级行业
        $('#industryPId').change(function(){
            var industryId = $(this).val();
            refreshIndustryCId(industryId);
        });
        //刷新一级行业
        function refreshIndustryCId(industryId){
            $.ajax({
                type: "GET",
                url: contextPath + "new/m/queryIndustryDetails",
                data: {"industryId": industryId},
                success: function (data) {
                    $('#industryCId').html('');
                    $('#industryCId').append("<option value='' selected>请选择</option>");
                    $.each(data.resultData, function(i,e){
                        if ("${newMerchantUserModel.industryCId}" == e.id) {
                            $('#industryCId').append("<option value='"+ e.id +"' restricted='" + e.restricted  +"' title='" +e.title+ "' selected>" + e.title + "</option>");
                        } else {
                            $('#industryCId').append("<option value='"+ e.id +"' restricted='" + e.restricted  +"' title='" +e.title+ "' >" + e.title + "</option>");
                        }
                    });
                }
            });
        }

        //根据身份查询城市
        $('#industryCId').change(function(){
            var selectedOption=$(this).find("option:selected")
            if(selectedOption.attr("restricted") != undefined && selectedOption.attr("restricted") == '1'){
                var title = "'" + selectedOption.attr("title") +  "'该行业暂无额度，请等待数天后再进行尝试！是否继续填写资料？";
                myApp.confirm(title,'提示',function() {
                    //停留当前界面不变
                },function() {
                    //返回我的额度界面
                    location.href = "<c:url value='/new/m/myLimit'/>";
                });
            }
        });

        //根据身份查询城市
        $('#provinceId').change(function(){
            var provinceId = $(this).val();
            refreshCitys(provinceId);
        });
        //刷新城市
        function refreshCitys(provinceId){
            $.ajax({
                type: "GET",
                url: contextPath + "new/m/queryCitys",
                data: {"provinceId": provinceId},
                success: function (data) {
                    $('#cityId').html('');
                    //if ("${!empty newMerchantUserModel.cityId && newMerchantUserModel.cityId != ''}" == false)
                    $('#cityId').append("<option value='' selected>请选择</option>");
                    $.each(data.resultData, function(i,e){
                        if ("${newMerchantUserModel.cityId}" == e.id) {
                            $('#cityId').append("<option value='"+ e.id +"' selected>" + e.title + "</option>");
                        } else {
                            $('#cityId').append("<option value='"+ e.id +"'>" + e.title + "</option>");
                        }
                    });
                }
            });
        }


        //提交
        $("#submitBtn").click(function(){

            if ($("#hasBusinessLicense").val() == "") {
                myApp.alert('是否有营业执照不能为空!', '提示');
                return;
            }

            if ($("#hasBusinessLicense").val() == "1" && $("#bizStartDate").val() == "") {
                myApp.alert('营业执照成立/发照日期不能为空!', '提示');
                return;
            }

            if ( $("#industryPId").val() == "" || $("#industryCId").val() == "") {
                myApp.alert('所属行业不能为空!', '提示');
                return;
            }

            if ( $("#provinceId").val() == "" || $("#cityId").val() == "") {
                myApp.alert('所属所在城市不能为空!', '提示');
                return;
            }

            if ( $("#numLocations").val() == "") {
                myApp.alert('实体门店数不能为空!', '提示');
                return;
            }

            var reg = /^[1-9]*[1-9][0-9]*$/;
            if (!reg.test($("#numLocations").val())) {
                myApp.alert('实体门店数不合法!', '提示');
                return;
            }

            if ( $("#surveySquareFootage").val() == "") {
                myApp.alert('营业面积不能为空!', '提示');
                return;
            }


            myApp.confirm('提交后系统开始重新计算您的授信额度，您确定提交吗？','提示',function() {
                myApp.showPreloader('提交中...')
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/basicLimit",
                    data:$('#myform').serialize(),
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

        });

</script>
</body>
</html>
