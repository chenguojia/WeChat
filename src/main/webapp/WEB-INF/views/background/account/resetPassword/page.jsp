<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%--标题--%>
<thead>
<tr class="label-primary">
    <td scope="col" width="2%"><input type="checkbox" id="selectAll"/></td>
    <td scope="col" width="15%"><span>账号</span></td>
    <td scope="col" width="13%"><span>密码</span></td>
    <td scope="col" width="46%"><span>商户名称</span></td>
    <td scope="col" width="12%"><span>联系人姓名</span></td>
    <td scope="col" width="12%"><span>操作</span></td>
</tr>
</thead>
<%--内容--%>
<tbody>
<c:forEach var="item" items="${queryPageModel.list}">
    <tr>
        <td><input type="checkbox" name="myCheckbox" class="myCheckbox" sid="${item.id}"/></td>
        <td>${item.username}</td>
        <td>${item.password}</td>
        <td>${item.name}</td>
        <td>${item.contactName}</td>
        <td>
            <button class="btn btn-warning btn-xs resetPasswordBtn" type="button" sid="${item.id}" parentUrl="<c:url value="/background/${moduleName}/init"/>">重置密码</button>
        </td>
    </tr>
</c:forEach>
</tbody>

<script>

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

    //绑定重置密码按钮事件
    $(".resetPasswordBtn").click(function () {
        var parentUrl = $(this).attr("parentUrl");
        var id = $(this).attr("sid");

        layer.prompt({title: '请输入新密码？'}, function (newPassword) {
            $.ajax({
                type: "POST",
                url:"<c:url value="/background/${moduleName}/operation"/>",
                data:{"id":id,"newPassword":newPassword},
                cache: false,
                success: function(data) {
                    if (data == "1") {
                        //成功
                        layer.msg('密码重置成功',3 , {type:9,rate: 'bottom',shade: [0]});//提示
                        loadMenuContent(parentUrl,"#dynamicData");//刷新列表
                    } else {
                        //失败
                        layer.alert("服务器繁忙，密码重置失败!" , 8);
                    }
                }
            });
        });
    });

</script>