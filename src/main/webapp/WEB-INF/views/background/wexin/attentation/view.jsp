<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-header">
    <%--标题--%>
    <h4 class="modal-title" id="myModalLabel">
       关注回复配置
    </h4>
</div>
<div class="modal-body">
    <%--内容--%>
    <form action="" method="post" id="myform">
        <table class="table table-bordered">
            <tr>
                <td>回复消息类型<font color="red">*</font></td>
                <td>
                    <select class="form-control required" name="responseType" id="responseType">
                        <option value=""></option>
                        <option value="text" ${responseType == 'text' ? 'selected' : ''}>文字消息</option>
                        <option value="news" ${responseType == 'news' ? 'selected' : ''}>图文消息</option>
                        <option value="function" ${responseType == 'function' ? 'selected' : ''}>特殊逻辑</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>回复关联消息<font color="red">*</td>
                <td>
                    <select class="form-control required" name="responseId" id="responseId">
                        <%--动态--%>
                       <%-- <option value="${responseId}">${responseObj.name}</option>--%>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="modal-footer" style="text-align:center;">
    <button type="button" class="btn btn-primary" id="submitBtn">
        提交
    </button>
</div>

<script>

    var responseId = " ${responseId}";

    $(function () {
        loadRespanseData();//修改页面启动后触发
    });

    //动态加载responseId
    $('#responseType').change(function () {
        loadRespanseData();
    });

    //公用加载值集
    function loadRespanseData(){
        var responseType = $("#responseType").val();
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
    }

    //提交表单
    $("#submitBtn").click(function () {
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
                        layer.msg('配置成功', 3, {type: 9, rate: 'bottom', shade: [0]});//提示
                    } else {
                        //失败
                        layer.alert("服务器繁忙，配置出错！", 8);
                    }
                }
            });
        }
    });
</script>