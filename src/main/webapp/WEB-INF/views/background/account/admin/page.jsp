<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--标题--%>
<thead>
<tr class="label-primary">
    <td scope="col" width="2%"><input type="checkbox" id="selectAll"/></td>
    <td scope="col" width="80%"><span>管理员名称</span></td>
    <td scope="col" width="18%"><span>操作</span></td>
</tr>
</thead>
<%--内容--%>
<tbody>
<c:forEach var="item" items="${queryPageModel.list}">
    <tr>
        <td><input type="checkbox" name="myCheckbox" class="myCheckbox" sid="${item.id}"/></td>
        <td><a class="showModalBtn" url="<c:url value="/background/${moduleName}/view?id=" />${item.id}&optType=1" href="#">${item.username}</a></td>
        <td>
            <button class="btn btn-info btn-xs showModalBtn" type="button" url="<c:url value="/background/${moduleName}/view?id=" />${item.id}&optType=1">查看</button>
            <c:if test="${item.id != 1}">
                <button class="btn btn-warning btn-xs showModalBtn" type="button" url="<c:url value="/background/${moduleName}/view?id=" />${item.id}&optType=2">修改</button>
                <button class="btn btn-danger btn-xs deleteBtn" type="button" sid="${item.id}" parentUrl="<c:url value="/background/${moduleName}/init"/>">删除</button>
            </c:if>
        </td>
    </tr>
</c:forEach>
</tbody>

<script>

    //删除按钮事件
    $(".deleteBtn").click(function () {
        var parentUrl = $(this).attr("parentUrl");
        var id = $(this).attr("sid");
        layer.confirm('确认删除?',function(index){
            $.ajax({
                type: "POST",
                url:"<c:url value="/background/${moduleName}/delete"/>",
                data:{"ids":id},
                cache: false,
                success: function(data) {
                    if (data == "1") {
                        //成功
                        layer.msg('删除成功',3 , {type:9,rate: 'bottom',shade: [0]});//提示
                        loadMenuContent(parentUrl,"#dynamicData");//刷新列表
                    } else {
                        //失败
                        layer.alert("服务器繁忙，删除失败!" , 8);
                    }
                }
            });
        });

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