<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--标题--%>
<thead>
<tr class="label-primary">
    <td scope="col" width="2%"><input type="checkbox" id="selectAll"/></td>
    <td scope="col" width="80%"><span>用户名</span></td>
    <td scope="col" width="18%"><span>操作</span></td>
</tr>
</thead>
<%--内容--%>
<tbody>
<c:forEach var="item" items="${queryPageModel.list}">
    <tr>
        <td><input type="checkbox" name="myCheckbox" class="myCheckbox" sid="${item.id}"/></td>
        <td><a class="chooseModalItemBtn" currLabel="${item.username}" currValue="${item.id}" targetLabelId="${targetLabelId}" targetValueId="${targetValueId}"  href="#">${item.username}</a></td>
        <td>
            <button class="btn btn-info btn-xs chooseModalItemBtn" type="button" currLabel="${item.username}" currValue="${item.id}" targetLabelId="${targetLabelId}" targetValueId="${targetValueId}">选择</button>
        </td>
    </tr>
</c:forEach>
</tbody>

<script>

    //选择查询子项按钮
    $(".chooseModalItemBtn").click(function(){
        var currLabel = $(this).attr("currLabel");//当前选中文本
        var currValue = $(this).attr("currValue");//当前选中id
        var targetLabelId = $(this).attr("targetLabelId");//填充文本的对象id
        var targetValueId = $(this).attr("targetValueId");//填充id的的对象的id
        //填充
        $("#" + targetLabelId).val(currLabel);
        $("#" + targetValueId).val(currValue);
        //隐藏
        $('#chooseModal').modal('hide');
        $("#chooseModalContent").html("");//清空
    });

    //全选事件
    $("#selectAll").change(function () {
        if ($(this).is(':checked')) {
            $("input[name='myCheckbox']").each(function(){
                $(this).prop("checked", true);
            });
        } else {
            $("input[name='myCheckbox']").each(function(){
                $(this).removeAttr("checked");
            });
        }
    });
    //单个选择
    $(".myCheckbox").click(function(){
        if ($(this).is(':checked')) {
            //判断是否所有的都选中了
            var flag = true;
            $(".myCheckbox").each(function(){
                if(!$(this).is(":checked")){
                    flag = false;
                    return false;
                }
            });
            if(flag){
                $("#selectAll").prop("checked", true);
            }
        } else {
            $("#selectAll").removeAttr("checked");
        }
    });

</script>