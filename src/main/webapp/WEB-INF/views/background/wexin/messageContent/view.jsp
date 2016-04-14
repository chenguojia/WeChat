<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-header">
    <%--关闭图标--%>
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <%--标题--%>
    <h4 class="modal-title" id="myModalLabel">
        <c:if test="${optType == '1'}">查看</c:if><c:if test="${optType == '2'}">修改</c:if><c:if test="${optType != '1' && optType != '2' }">新增</c:if>关键字检索
    </h4>
</div>
<div class="modal-body">
    <%--内容--%>
    <form action="" method="post" id="myform" class="validate" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${returnObj.id}">
        <input type="hidden" name="type" value="${type}">
        <table class="table table-bordered">
            <%--文字消息--%>
            <c:if test="${type == 'text'}">
                <tr>
                    <td>名称<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <input type="text" name="name" class="form-control required" placeholder="名称"
                                   value="${returnObj.name}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.name}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>内容<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <textarea name="content" class="form-control required" placeholder="内容">${returnObj.content}</textarea>
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.content}"/>
                        </c:if>
                    </td>
                </tr>
            </c:if>

            <%--图文消息--%>
            <c:if test="${type == 'news'}">
                <tr>
                    <td>名称<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <input type="text" name="name" class="form-control required" placeholder="名称"
                                   value="${returnObj.name}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.name}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>图文标题<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <input type="text" name="title" class="form-control required" placeholder="图文标题"
                                   value="${returnObj.title}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.title}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td width="30%">图片链接<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td width="70%" class="wordWrap">
                        <c:if test="${optType != '1'}">
                            <input type="text" name="pictureUrl" id="pictureUrl" class="form-control" placeholder="图片链接"
                                   value="${returnObj.pictureUrl}"/>
                            <input type="file" name="pictureFile" id="pictureFile" class="form-control"/>
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <a href="${returnObj.pictureUrl}" target="_blank">${returnObj.pictureUrl}</a>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>文章内容链接<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td class="wordWrap">
                        <c:if test="${optType != '1'}">
                            <input type="text" name="url" class="form-control required" placeholder="文章内容链接"
                                   value="${returnObj.url}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <a href="${returnObj.url}" target="_blank">${returnObj.url}</a>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>关联的主图文消息</td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <select name="parentId" id="parentId" class="form-control">
                                <%--动态消息--%>
                            </select>
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${parentNode.name}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>消息显示排序<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <input type="text" name="sort" class="form-control required number" placeholder="消息显示排序"
                                   value="${returnObj.sort}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.sort}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>消息描述<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td class="wordWrap">
                        <c:if test="${optType != '1'}">
                            <textarea name="description" class="form-control required" placeholder="内容">${returnObj.description}</textarea>
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.description}"/>
                        </c:if>
                    </td>
                </tr>
            </c:if>

            <%--特殊逻辑--%>
            <c:if test="${type == 'function'}">
                <tr>
                    <td>名称<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <input type="text" name="name" class="form-control required" placeholder="名称"
                                   value="${returnObj.name}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.name}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>调用类名<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <input type="text" name="beanName" class="form-control required" placeholder="调用类名"
                                   value="${returnObj.beanName}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.beanName}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>调用方法<font color="red">${optType == '1' ? '' : '*'}</font></td>
                    <td>
                        <c:if test="${optType != '1'}">
                            <input type="text" name="methodName" class="form-control required" placeholder="调用方法"
                                   value="${returnObj.methodName}">
                        </c:if>
                        <c:if test="${optType == '1'}">
                            <c:out value="${returnObj.methodName}"/>
                        </c:if>
                    </td>
                </tr>
            </c:if>

        </table>
    </form>
</div>
<div class="modal-footer" style="text-align:center;">
    <c:if test="${optType != '1'}">
        <button type="button" class="btn btn-primary" id="submitBtn" parentUrl="<c:url value="/background/${moduleName}/init?type=${type}"/>">
            提交
        </button>
    </c:if>
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
</div>

<script>

    $(function () {
        var optType = "${optType}";
        if (optType != "1") {
            if ("${type}" == "news") {
                var parentId = "${type == 'news' ? returnObj.parentId : ''}";
                //图文消息时，加载所有父节点
                $.ajax({
                    type: "GET",
                    url: "<c:url value="/background/${moduleName}/queryParentNode"/>",
                    data: {},
                    cache:false,
                    success: function (data) {
                        $('#parentId').html('');
                        $('#parentId').append($("<option />").val("").text("请选择"));
                        $.each(data, function (i, e) {
                            if (parentId == e.id) {
                                $('#parentId').append($("<option />").val(e.id).text(e.name).attr("selected", true));//选中
                            } else {
                                $('#parentId').append($("<option />").val(e.id).text(e.name));
                            }
                        });
                    }
                });
            }
        }
    });

    //提交表单
    $("#submitBtn").click(function () {
        var parentUrl = $(this).attr("parentUrl");
        if ($("#myform").valid()) {
            $.ajax({
                cache: false,
                type: "POST",
                url: "<c:url value="/background/${moduleName}/submit"/>",
                data: $('#myform').serialize(),// 你的formid
                async: false,
                success: function (data) {
                    if (data == "1") {
                        //成功
                        layer.msg('操作成功', 3, {type: 9, rate: 'bottom', shade: [0]});//提示
                        $('#myModal').modal('hide');//隐藏模态窗体
                        loadMenuContent(parentUrl, "#"+"${type}");//刷新列表，添加到当前选中TAB中
                    } else {
                        //失败
                        layer.alert("服务器繁忙，提交出错", 8);
                    }
                }
            });
        }
    });

    //触发上传事件
    bindUploadChangEvent();

    //绑定上传事件
    function bindUploadChangEvent(){
        /*异步ajax上传*/
        $("#pictureFile").change(function () {
            if ($(this).val() != "") {
                var elementIds = ["pictureFile"]; //flag为id、name属性名
                $.ajaxFileUpload({
                    url: '<c:url value="/fileUpload" /> ',
                    type: 'post',
                    secureuri: false, //一般设置为false
                    fileElementId: 'pictureFile', // 上传文件的id、name属性名
                    dataType: 'text', //返回值类型，一般设置为json、application/json
                    elementIds: elementIds, //传递参数到服务器
                    success: function (data, status) {
                        $("#pictureUrl").val(data);
                        bindUploadChangEvent();//重新绑定，因为上传完成以后会清空原来的上传控件
                    },
                    error: function (data, status, e) {
                        layer.alert("服务器繁忙，上传！", 8);
                        bindUploadChangEvent();//重新绑定，因为上传完成以后会清空原来的上传控件
                    }
                });
            }
        });
    }
</script>