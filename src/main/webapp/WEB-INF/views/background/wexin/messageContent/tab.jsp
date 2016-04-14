<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul id="myTab" class="nav nav-tabs">
    <li><a href="#text" data-toggle="tab" url="<c:url value="/background/messageContent/init?type=text"/>">文字消息</a> </li>
    <li><a href="#news" data-toggle="tab" url="<c:url value="/background/messageContent/init?type=news"/>">图文消息</a></li>
    <li><a href="#function" data-toggle="tab" url="<c:url value="/background/messageContent/init?type=function"/>">特殊逻辑</a></li>
</ul>

<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade" id="text">
        <%--文字消息内容--%>
    </div>

    <div class="tab-pane fade" id="news">
        <%--图文消息内容--%>
    </div>

    <div class="tab-pane fade" id="function">
        <%--特殊逻辑内容--%>
    </div>
</div>

<script>

    $(function(){
        //默认填充数据到第一个TAB中
        loadMenuContent($(".nav-tabs li a:first").attr("url"),$(".nav-tabs li a:first").attr("href"));
        //默认选中第一个tab
        $(".nav-tabs li:first").addClass("active")
        $(".tab-content div:first").addClass("in active")
    });

    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        //当前选中的TAB标签页对象
        var currActiveTab = $(e.target);
        //先清空所有tab数据
        $(".tab-pane").html("");
        //填充数据到选中的TAB中
        loadMenuContent(currActiveTab.attr("url"),currActiveTab.attr("href"));
    });
</script>