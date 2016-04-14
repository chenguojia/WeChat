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
                <div class="left"><a href="<c:url value='/new/m/applyStatus/show'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">融资待确认</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="fc-title">卡得万利商业保理（上海）有限公司<br/>商业保理确认书</div>
                        <%--动态遍历--%>
                        <c:forEach var="item" items="${confirmlists}">
                            <div class="content-block-title">${item.title}</div>
                            <div class="list-block uploadfile-block">
                                <ul>
                                    <c:forEach var="childItem" items="${item.items}">
                                        <li>
                                            <div class="item-content">
                                                <div class="item-inner">
                                                    <div class="item-title label">${childItem.title}：</div>
                                                    <div class="item-input">
                                                        <span>${childItem.value}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:forEach>

                        <div class="padding-rl15 margin-b10">
                            <input type="Checkbox" name="rdoA" value="0" checked="checked" id="agree-terms" />
                            <span class="checkbox_check">
                                <label for="agree-terms">同意</label>
                                <a class="open-popup" data-popup=".popup-selectCity" href="#" onClick="popClose()">应收账款转让登记协议</a>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="toolbar tabbar tabbar-labels">
            <div class="toolbar-inner row">
                <a class="button button-fill toolbar-btn col-50" href="#" id="submitBtn">确认</a>
                <a class="button color-gray toolbar-btn col-50 prompt-ok" href="#">放弃</a>
            </div>
        </div>
    </div>
</div>
<div class="popup popup-selectCity">
    <%--<p class="padding-rl15">--%>
        <%--<a href="#" class="close-popup">返回</a>--%>
    <%--</p>--%>
    <div class="page-content contacts-content register-padding">
        <jsp:include page="/new/m/clause/affirmLoansClause"/>
    </div>
</div>
    <%--协议关闭按钮--%>
    <div class="close-display display-none">
        <div class="close-line-height"></div>
        <a href="#" class="close-popup padding-l10" onClick="$('.close-display').addClass('display-none')">返回</a>
    </div>

    <script>
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });

    //同意条款
    $("#agree-terms").change(function () {
        if ($(this).is(":checked")) {
            $(".toolbar-btn").removeClass("disabled");
        } else {
            $(".toolbar-btn").addClass("disabled");
        }
    })

    $(".toolbar-btn").click(function(){
        if ($(this).html() == "确认") {
            myApp.showPreloader('处理中...');
            $.ajax({
                type: "POST",
                url: contextPath + "new/m/affirmLoans",
                data: {"isOk": "1","reson": ""},
                success: function (data) {
                    if (data.resultCode == "-1") {
                        myApp.hidePreloader();
                        myApp.alert(data.resultMsg,'提示');
                    } else {
                        //成功,跳转主控界面
                        location.href = contextPath + "new/m/applyStatus/show";
                    }
                }
            });
        } else {
            myApp.prompt('请输入放弃理由!', function (value) {
                myApp.showPreloader('处理中...');
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/affirmLoans",
                    data: {"isOk": "0","reson": value},
                    success: function (data) {
                        if (data.resultCode == "-1") {
                            myApp.hidePreloader();
                            myApp.alert(data.resultMsg,'提示');
                        } else {
                            //成功,跳转主控界面
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
