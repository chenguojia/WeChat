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
                <td width="40%">管理员<font color="red">${optType == '1' ? '' : '*'}</font></td>
                <td width="60%">
                    <c:if test="${optType != '1'}">
                        <%--选择框--%>
                        <div class="input-group">
                            <input type="hidden" name="userId" id="userIdModal" value="${returnObj.userId}"><%--隐藏值--%>
                            <input type="text" name="userName" id="userNameModal" readonly class="form-control required" value="${user.username}"><%--显示值--%>
                            <label class="input-group-addon chooseModalBtn" url="<c:url value="/background/admin/modal/user/init?targetLabelId=userNameModal&targetValueId=userIdModal" />">选择</label><%--操作按钮--%>
                        </div>
                    </c:if>
                    <c:if test="${optType == '1'}">
                        <c:out value="${user.username}"/>
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

    //公用的弹出框选择
    $(".chooseModalBtn").click(function(){
        //加载内容到模态窗体div
        loadMenuContent($(this).attr("url"),"#chooseModalContent");
        //显示模态窗体
        $('#chooseModal').modal('show');
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
                    } else if (data == "2") {
                        //用户已存在
                        layer.alert("改用户已存在，请重新选择其他用户!", 8);
                    }else {
                        //失败
                        layer.alert("服务器繁忙，提交出错", 8);
                    }
                }
            });
        }
    });
</script>