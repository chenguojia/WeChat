<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='${sourceType == "1" ? "/new/m/home" :"/new/m/applyStatus/show"}  '/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">补件</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
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
                                            <a href="<c:url value='/new/m/uploadFileDetail/show?groupName=${childItem.title}&sourceType=2'/>" class="item-link item-content">
                                                <div class="item-inner">
                                                    <div class="item-title-row">
                                                        <div class="item-title">${childItem.title}</div>
                                                        <c:if test="${!empty childItem.lackCount && childItem.lackCount != '0'}">
                                                            <div class="item-after"><span class="badge bg-red" stitle="${childItem.title}">${childItem.lackCount}</span></div>
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
                            <a class="button button-fill button-big" id="submitBtn" >提交</a>
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
            myApp.confirm('您确定提交吗？','提示',function() {
                myApp.showPreloader('提交中...')
                $.ajax({
                    type: "POST",
                    url: contextPath + "new/m/addFile",
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
