<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-header">
    <%--关闭图标--%>
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <%--标题--%>
    <h4 class="modal-title" id="myModalLabel">
        <c:if test="${optType == '1'}">查看</c:if><c:if test="${optType == '2'}">修改</c:if><c:if test="${optType != '1' && optType != '2' }">新增</c:if>最新活动推送配置
    </h4>
</div>
<div class="modal-body">
    <%--内容--%>
    <form action="" method="post" id="myform">
        <input type="hidden" name="id" value="${returnObj.id}">
        <table class="table table-bordered">
            <tr>
                <td>用户类型<font color="red">${optType == '1' ? '' : '*'}</font></td>
                <td>
                    <c:if test="${optType != '1'}">
                        <select class="form-control required" name="userType">
                            <option value="0" ${returnObj.userType == '0' ? 'selected' : ''}>其他</option>
                            <option value="1" ${returnObj.userType == '1' ? 'selected' : ''}>银商客经</option>
                            <option value="4" ${returnObj.userType == '4' ? 'selected' : ''}>商户</option>
                        </select>
                    </c:if>
                    <c:if test="${optType == '1'}">
                        <c:if test="${returnObj.userType == '0'}">其他</c:if>
                        <c:if test="${returnObj.userType == '1'}">银商客经</c:if>
                        <c:if test="${returnObj.userType == '4'}">商户</c:if>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>推送消息类型<font color="red">${optType == '1' ? '' : '*'}</font></td>
                <td>
                    <c:if test="${optType != '1'}">
                        <select class="form-control required" name="responseType" id="responseType">
                            <option value=""></option>
                            <option value="text" ${returnObj.responseType == 'text' ? 'selected' : ''}>文字消息</option>
                            <option value="news" ${returnObj.responseType == 'news' ? 'selected' : ''}>图文消息</option>
                            <option value="function" ${returnObj.responseType == 'function' ? 'selected' : ''}>特殊逻辑</option>
                        </select>
                    </c:if>
                    <c:if test="${optType == '1'}">
                        <c:if test="${returnObj.responseType == 'text'}">文字消息</c:if>
                        <c:if test="${returnObj.responseType == 'news'}">图文消息</c:if>
                        <c:if test="${returnObj.responseType == 'function'}">特殊逻辑</c:if>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>推送类型关联消息<font color="red">${optType == '1' ? '' : '*'}</font></td>
                <td>
                    <c:if test="${optType != '1'}">
                        <select class="form-control required" name="responseId" id="responseId">
                                <%--动态--%>
                            <option value="${responseObj.id}">${responseObj.name}</option>
                        </select>
                    </c:if>
                    <c:if test="${optType == '1'}">
                        <c:out value="${responseObj.name}"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="modal-footer" style="text-align:center;">
    <c:if test="${optType != '1'}">
        <button type="button" class="btn btn-primary" id="submitBtn" parentUrl="<c:url value="/background/${moduleName}/init"/>">
            提交
        </button>
    </c:if>
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
</div>

<script>

    var responseId = " ${responseObj.id}";

    $(function () {
        var optType = "${optType}";
        if (optType == "2") {
            $("#responseType").trigger("change");//修改页面启动后触发
        }
    });

    //动态加载responseId
    $('#responseType').change(function () {
        var responseType = $(this).val();
        $.ajax({
            type: "GET",
            url: "<c:url value="/background/rule/getRuleResponseByType"/>",
            data: {"responseType": responseType},
            cache: false,
            success: function (data) {
                $('#responseId').html('');
                $.each(data, function (i, e) {
                    if (responseId == e.id) {
                        $('#responseId').append($("<option />").val(e.id).text(e.name).attr("selected", true));//选中
                    } else {
                        $('#responseId').append($("<option />").val(e.id).text(e.name));
                    }
                });
            }
        });
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
                        loadMenuContent(parentUrl, "#dynamicData");//刷新列表
                    }else if (data == "2") {
                        //重复
                        layer.alert("已经存在相同用户类型的提示信息，请重新选择!", 8);
                    } else {
                        //失败
                        layer.alert("服务器繁忙，提交出错", 8);
                    }
                }
            });
        }
    });
</script>