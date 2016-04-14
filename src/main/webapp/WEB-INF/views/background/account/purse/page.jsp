<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%--标题--%>
<thead>
<tr class="label-primary">
    <td scope="col" width="2%"><input type="checkbox" id="selectAll"/></td>
    <td scope="col" width="10%"><span>姓名</span></td>
    <td scope="col" width="9%"><span>省份</span></td>
    <td scope="col" width="9%"><span>城市</span></td>
    <td scope="col" width="10%"><span>手机</span></td>
    <td scope="col" width="10%"><span>微信名称</span></td>
    <td scope="col" width="10%"><span>提现金额</span></td>
    <td scope="col" width="17%"><span>创建时间</span></td>
    <td scope="col" width="8%"><span>状态</span></td>
    <td scope="col" width="15%"><span>操作</span></td>
</tr>
</thead>
<%--内容--%>
<tbody>
<c:forEach var="item" items="${queryPageModel.list}">
    <tr>
        <td><input type="checkbox" name="myCheckbox" class="myCheckbox" sid="${item.id}"/></td>
        <td><a class="showModalBtn" url="<c:url value="/background/${moduleName}/view?id=" />${item.id}&optType=1" href="#">${item.name}</a></td>
        <td>${item.branchLabel}</td>
        <td>${item.regionLabel}</td>
        <td>${item.mobile}</td>
        <td>${item.weId}</td>
        <td><fmt:formatNumber value="${item.amount}" pattern="###.##" /></td>
        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.createDate}"/> </td>
        <td>
            <c:if test="${item.flag == 0}">待处理</c:if>
            <c:if test="${item.flag == 1}">已通过</c:if>
            <c:if test="${item.flag == 2}">已驳回</c:if>
        </td>
        <td>
            <button class="btn btn-info btn-xs showModalBtn" type="button" url="<c:url value="/background/${moduleName}/view?id=" />${item.id}&optType=1">查看</button>
            <%--待处理时显示--%>
            <c:if test="${item.flag == 0}">
                <button class="btn btn-warning btn-xs approveBtn" status="1" type="button" sid="${item.id}" parentUrl="<c:url value="/background/${moduleName}/init"/>">通过</button>
                <button class="btn btn-danger btn-xs approveBtn" status="2" type="button" sid="${item.id}" parentUrl="<c:url value="/background/${moduleName}/init"/>">驳回</button>
            </c:if>
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

    //绑定审批按钮事件
    $(".approveBtn").click(function () {
        var parentUrl = $(this).attr("parentUrl");
        var status = $(this).attr("status");
        var id = $(this).attr("sid");

        if (status == '1') {
            layer.confirm('确认通过?', function (index) {
                approve(id,status,'',parentUrl);
            });
        } else {
            layer.prompt({title: '请输入驳回理由？'}, function (reason) {
                approve(id,status,reason,parentUrl);
            });
        }
    });

</script>