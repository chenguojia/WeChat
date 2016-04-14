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
    <form action="" method="post" id="myform">
        <input type="hidden" name="id" value="${returnObj.id}">
        <table class="table table-bordered">
            <tr>
                <td>关键字<font color="red">${optType == '1' ? '' : '*'}</font></td>
                <td>
                    <c:if test="${optType != '1'}">
                        <input type="text" name="keyword" class="form-control required" placeholder="关键字"
                               value="${returnObj.keyword}">
                    </c:if>
                    <c:if test="${optType == '1'}">
                        <c:out value="${returnObj.keyword}"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>优先级<font color="red">${optType == '1' ? '' : '*'}</font></td>
                <td>
                    <c:if test="${optType != '1'}">
                        <select class="form-control required" name="priority">
                            <option value="0"  ${returnObj.priority == '0' ? 'selected' : ''}>低</option>
                            <option value="1"  ${returnObj.priority == '1' ? 'selected' : ''}>中</option>
                            <option value="2"  ${returnObj.priority == '2' ? 'selected' : ''}>高</option>
                        </select>
                    </c:if>
                    <c:if test="${optType == '1'}">
                        <c:if test="${returnObj.priority == '0'}">低</c:if>
                        <c:if test="${returnObj.priority == '1'}">中</c:if>
                        <c:if test="${returnObj.priority == '2'}">高</c:if>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>关键字回复消息类型<font color="red">${optType == '1' ? '' : '*'}</font></td>
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
                <td>关键字回复关联消息<font color="red">${optType == '1' ? '' : '*'}</font></td>
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
            <tr>
                <td>匹配方式<font color="red">${optType == '1' ? '' : '*'}</font></td>
                <td>

                    <c:if test="${optType != '1'}">
                        <select class="form-control required" name="ruleType" id="ruleType">
                            <option value=""></option>
                            <option value="1" ${returnObj.ruleType == '1' ? 'selected' : ''}>精准匹配</option>
                            <option value="2" ${returnObj.ruleType == '2' ? 'selected' : ''}>模糊匹配</option>
                        </select>
                    </c:if>
                    <c:if test="${optType == '1'}">
                        <c:if test="${returnObj.ruleType == '1'}">精准匹配</c:if>
                        <c:if test="${returnObj.ruleType == '2'}">模糊匹配</c:if>
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
            url: "<c:url value="/background/${moduleName}/getRuleResponseByType"/>",
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
                    } else {
                        //失败
                        layer.alert("服务器繁忙，提交出错", 8);
                    }
                }
            });
        }
    });
</script>