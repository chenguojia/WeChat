<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-header">
    <%--标题--%>
    <h4 class="modal-title" id="myModalLabel">
       二维码生成
    </h4>
</div>
<div class="modal-body">
    <%--内容--%>
    <form action="" method="post" id="myform">
        <table class="table table-bordered">
           <tr>
                <td width="12%">动态参数</td>
                <td>
                    <textarea class="form-control required" name="paramas"></textarea>
                </td>
            </tr>
            <tr>
                <td>二维码链接</td>
                <td class="wordWrap"  height="57">
                    <a href="###" id="qrCodeUrl" target="_blank"></a>
                </td>
            </tr>
            <tr>
                <td class="wordWrap" colspan="4" height="447">
                    <img id="qrCodeImg"  src="" class="eighty-percent-width"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="modal-footer" style="text-align:center;">
    <button type="button" class="btn btn-primary" id="submitBtn">
        生成
    </button>
</div>

<script>

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
                    if (data != "") {
                        //成功
                        layer.msg('生成成功', 3, {type: 9, rate: 'bottom', shade: [0]});//提示
                        $("#qrCodeUrl").attr("href",data);
                        $("#qrCodeUrl").text(data);
                        $("#qrCodeImg").attr("src",data);
                    } else {
                        //失败
                        layer.alert("服务器繁忙，生成出错！请检查您输入的动态参数是否合法!", 8);
                    }
                }
            });
        }
    });
</script>