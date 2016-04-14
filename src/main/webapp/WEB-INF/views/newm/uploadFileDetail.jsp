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
                <div class="left"><a href="<c:url value='${sourceType == 1 ?  "/new/m/uploadFile/show?selectedTabIndex=2" : "/new/m/addFile/show"} '/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">上传${groupName}</div>
                <%--<div class="right"><a href="<c:url value='${sourceType == 1 ?  "/new/m/uploadFile/show?selectedTabIndex=2" : "/new/m/addFile/show"} '/>" class="back link wechat-back"> 下一类别</a></div>--%>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <div>
                        <div class="list-block media-list">
                            <ul>

                                <c:forEach var="item" items="${uploadFileChildModels}" varStatus="i">
                                    <li>
                                        <div href="#" class="item-content">
                                            <div class="item-inner">
                                                <div class="item-title-row">
                                                    <div class="item-title id-title"><i class="icon idfront-icon"></i>${item.abbr}</div>
                                                </div>
                                                <div class="pic-thumbnail">
                                                    <div class="row">

                                                        <%--示例图片--%>
                                                        <c:if test="${!empty item.demo &&  item.demo != ''}">
                                                            <div class="thumbnail-inner">
                                                                <img class="thumbnailimg-eg imgObj" src="${item.demo}"/>
                                                                <div class="thumbnailimg-tips" style="margin-left:10px;margin-top:5px;">标准示例图片</div>
                                                            </div>
                                                        </c:if>

                                                        <%--循环该分组下所有图片--%>
                                                        <c:forEach var="picItem" items="${item.files}">
                                                            <div class="thumbnail-inner imgDiv">
                                                                <img class="thumbnailimg imgObj <c:if test="${picItem.width > picItem.height}">width-large</c:if><c:if test="${picItem.width < picItem.height}">height-large</c:if> " src="${picItem.url}" />
                                                                <a class="delete-btn" checklistId="${item.checklistId}" sid="${picItem.fileId}" ><img class="delete-img" src="<c:url value="/resources/newm/images/delete.png"/>" /></a>
                                                            </div>
                                                        </c:forEach>

                                                        <%--添加图片操作按钮--%>
                                                        <div class="thumbnail-inner">
                                                            <img class="thumbnailimg-add" src="<c:url value="/resources/newm/images/add-pic.png"/>"/>
                                                            <input class="upload-btn" accept="image/*" capture="camera"  name="pictureFile"  id="pictureFile${i.index + 1}"  type="file" checklistId="${item.checklistId}" />
                                                        </div>
                                                    </div>
                                                </div>

                                                <c:if test="${!empty item.rfe && item.rfe != ''}">
                                                    <div class="uploadFile-note">
                                                        <span class="glyphicon  glyphicon-info-sign wechat-icon-uploadFile-info"></span>
                                                        <span class="upload-note">${item.rfe}</span>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>

                            </ul>
                            <p style="margin-left: 10px;font-size: 12px;">温馨提示：图片上传后，系统自动保存。</p>
                        </div>
                        <div class="padding-rl15">
                        <p></p>
                        <%--<a class="button button-fill button-big" href="upload-file.html">保存</a>--%>
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

    bindUploadChangEvent();//触发上传事件
    bindImageClickEvent();//绑定图片预览事件
    bindImageDeleteEvent();//绑定删除图片事件

    //绑定上传事件公用方法
    function bindUploadChangEvent() {
        //移除事件
        $("input[name='pictureFile']").unbind("change");
        //绑定事件
        $("input[name='pictureFile']").change(function () {
            var myObjId = $(this).attr("id");
            var checklistId = $(this).attr("checklistId");
            //调用lrz压缩图片
            lrz(this.files[0], {width: 500}, function (results) {
                console.log(results);
                //将图像post到后台
                $.ajax({
                    cache: false,
                    type: "POST",
                    url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/checklists/"+ checklistId +"/files/" + results.origin.name,
                    data: results.base64.substring(results.base64.indexOf(",") + 1),
                    success: function (data) {
                        console.log(data);
                        <%--正式代码--%>
                        if (data.error != null && data.error != "") {
                            myApp.alert(data.error, '提示');
                        } else {
                            //成功
                            //设置图片的高宽按照比例缩放样式
                            var classValue = "";
                            if (data.width > data.height) classValue = "width-large";
                            else classValue = "height-large";
                            //追加HTML
                            $("#" + myObjId).parent().before('' +
                            '<div class="thumbnail-inner imgDiv">' +
                            '<img class="thumbnailimg imgObj '+ classValue +'" src="' + data.url + '" />' +
                            '<a class="delete-btn" sid="'+ data.objectId +'" ><img class="delete-img" src="<c:url value="/resources/newm/images/delete.png"/>" /></a>' +
                            '</div>');
                            bindImageDeleteEvent();//绑定删除图片事件
                            bindImageClickEvent();//绑定图片预览事件
                        }

                    } ,headers: {
                        "X-CRM-Application-Id":"wechat",
                        "X-CRM-Access-Token":"${accessToken}",
                        "Content-Type":"text/base64"
                    }
                });
            });
        });
    }

    //绑定删除图片事件
    function bindImageDeleteEvent() {
        //删除图片
        $(".delete-btn").click(function () {
            var obj =  $(this);
            var checklistId =obj.attr("checklistId");
            //调用服务器删除
            var fileId =obj.attr("sid");
            $.ajax({
                cache: false,
                type: "DELETE",
                url: "${wsCrmRestfulMerchantUrl}/merchants/${newMerchantUserModel.objectId}/files/" + fileId,
                data: {},
                success: function (data) {
                    if (data.error != null && data.error != "") {
                        //失败则提示
                        myApp.alert(data.error, '提示');
                    } else {
                        //成功则页面移除
                        obj.parent().remove();
                    }
                },headers: {
                    "X-CRM-Application-Id":"wechat",
                    "X-CRM-Access-Token":"${accessToken}"
                }
            });
        });
    }

    //绑定图片预览事件
    function bindImageClickEvent() {

        //自定义导航栏
        var navbarHtml = '' +
                '<div class="navbar">' +
                '<div class="navbar-inner">' +
                '<div class="left sliding">' +
                '<a href="#" class="back link wechat-back close-popup photo-browser-close-link">' +
                '<i class="icon icon-back card-back"></i>' +
                '<span></span>' +
                '</a>' +
                '</div>' +
                '<div class="center sliding">' +
                '<span class="photo-browser-current"></span> <span class="photo-browser-of">/</span> <span class="photo-browser-total"></span>' +
                '</div>' +
                '<div class="right">' +
                '</div>' +
                '</div>' +
                '</div>';

        //先取消绑定
        $(".imgObj").unbind("click");

        //点击时打开图片浏览器
        $(".imgObj").click(function () {

            //step1.组装显示的图片集合
            var picArray = new Array();//图片集合
            $(this).parent().parent().find("img").each(function (index, element) {
                if ($(this).attr("src").indexOf("add-pic.png") == -1 && $(this).attr("src").indexOf("delete.png") == -1) {
                    picArray.push($(this).attr("src"));//表示不是添加图片，添加进集合
                }
            });

            //step2.组装图片集合map，用于获取用户点击的是哪一张
            var picsMap = {};
            for (var i = 0; i < picArray.length; i++) {
                picsMap[picArray[i]] = "" + i;
            }

            //step3.获取当前显示的是哪一张
            var showIndex = picsMap[$(this).attr("src")];

            //step4.构建图片预览器
            var myPhotoBrowserStandalone = myApp.photoBrowser({
                photos: picArray,
                theme: 'dark',
                ofText: "/",
                backLinkText: "关闭",
                navbarTemplate: navbarHtml
            });

            //step5.显示图片预览器
            myPhotoBrowserStandalone.open(showIndex);
        });
    }

</script>

</body>
</html>
