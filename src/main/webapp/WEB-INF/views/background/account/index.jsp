<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-3 col-xs-4">
    <div class="lists">
        <%--表示为驻地专员权限--%>
        <c:if test="${login_user.type == 2}">
            <a class="list-group-item" url="<c:url value="/background/purse/init"/>" href="#">用户提现记录</a>
        </c:if>
        <%--表示为后台管理员权限--%>
        <c:if test="${login_user.type != 2}">
            <a class="list-group-item" url="<c:url value="/background/admin/init"/>" href="#">管理员配置</a>
            <a class="list-group-item" url="<c:url value="/background/purse/init"/>" href="#">用户提现记录</a>
            <a class="list-group-item" url="<c:url value="/background/resetPassword/init"/>" href="#">商户密码重置</a>
        </c:if>
    </div>
</div>
<div class="col-sm-9 col-xs-8">

    <div id="myAlert1" class="alert alert-warning" style="display: none;">
        <a href="#" class="close" onclick="$('#myAlert1').fadeOut(500);">&times;</a>
        <strong>提醒！</strong>没有查询到匹配的数据!
    </div>

    <div class="panel"  id="dynamicData">
        <%--右边数据包括查询条件、集合数据--%>
    </div>
</div>

<script>

    //页面加载完成后执行
    $(function () {
        //默认第一个菜单选中
        var obj = $(".lists").find("a").first();
        obj.addClass("active");
        //跳转到第一个页面url
        loadMenuContent(obj.attr("url"),"#dynamicData");
    });

    //左边列表点击事件
    $(".list-group-item").click(function () {
        //选中样式
        $(this).parent().find(".active").removeClass("active");
        $(this).addClass("active");
        //根据不同的菜单跳转不同的页面url
        loadMenuContent($(this).attr("url"),"#dynamicData");
    });
</script>
