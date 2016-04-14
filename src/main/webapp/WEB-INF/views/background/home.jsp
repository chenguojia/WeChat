<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>卡得万利</title>
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" />
  <script type="text/javascript" src="<c:url value="/resources/script/jquery-1.9.1.min.js"/>"></script>
  <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/resources/layer/layer.min.js"/>"></script>
  <script src="<c:url value="/resources/layer/extend/layer.ext.js"/>"></script>
  <style type="text/css">.container .rows {padding-top: 20px;}</style>
  <!-- 验证表单 -->
  <script type="text/javascript" src="<c:url value="/resources/script/jquery.validate.min.js"/>"></script>
  <script>$.extend($.validator.messages, {required: "请输入必填项."});$(document).ready(function(){$('#form1').validate();});</script>
  <style type="text/css">
    input .error { border: 1px solid red;}
    label.error {color: #EA5200;}
    #loading{position:fixed;_position:absolute;top:50%;left:50%;width:124px;height:124px;overflow:hidden;background:url(<c:url value="/resources/image/loaderc.gif"/>) no-repeat;z-index:7; margin:-62px 0 0 100px; display: none;}
    .pagination>li>em {position:relative;float:left;padding:6px 12px;margin-left:-1px;line-height:1.428571429;text-decoration:none;background-color:#fff;border: 1px solid #ddd;border-top:none; border-bottom:none;}
    .wordWrap{word-break: break-all; word-wrap:break-word}
  </style>
  <!-- 分页 -->
  <link rel="stylesheet" href="<c:url value="/resources/css/jquery.pagination.css"/>" />
  <script type="text/javascript" src="<c:url value="/resources/script/jquery.pagination.js"/>"></script>
  <!-- 日历 -->
  <%-- <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>" />
    <script type="text/javascript" src="<c:url value="/resources/script/jquery-ui.js"/>"></script> --%>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <%--ajax提交form--%>
  <script type="text/javascript" src="<c:url value="/resources/script/ajaxfileupload.js"/>"></script>
  <script>
    //日历中文
    jQuery(function($){
      $.datepicker.regional['zh-CN'] = {
        closeText: '关闭',
        prevText: '<上月',
        nextText: '下月>',
        currentText: '今天',
        monthNames: ['一月','二月','三月','四月','五月','六月',
          '七月','八月','九月','十月','十一月','十二月'],
        monthNamesShort: ['一','二','三','四','五','六',
          '七','八','九','十','十一','十二'],
        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
        dayNamesMin: ['日','一','二','三','四','五','六'],
        weekHeader: '周',
        dateFormat: 'yy-mm-dd',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '年'};
      $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
    });
  </script>
</head>

<body>
<div class="container">

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" id="modalContent">
                <%--内容包括按钮--%>
            </div>
        </div>
    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="chooseModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" id="chooseModalContent">
                <%--内容包括按钮--%>

            </div>
        </div>
    </div>

  <!--导航-->
  <nav class="navbar navbar-default" role="navigation" style="margin-top:10px;margin-bottom:10px;">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">后台管理</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <%--表示为驻地专员权限--%>
        <c:if test="${login_user.type == 2}">
            <li url="<c:url value="/background/account"/>" title="账户管理"><a href="#">账户管理</a></li>
        </c:if>
        <%--表示为后台管理员权限--%>
        <c:if test="${login_user.type != 2}">
            <li url="<c:url value="/background/account"/>" title="账户管理"><a href="#">账户管理</a></li>
            <li url="<c:url value="/report/home"/>" title="报表管理"><a href="#">报表管理</a></li>
            <li url="<c:url value="/background/weixin"/>" title="微信配置"><a href="#">微信配置</a></li>
        </c:if>
      </ul>
        <button type="button" class="btn btn-default navbar-btn logoutBtn" style="float: right; margin-right: 10px;"> 退出</button>
    </div>
  </nav>

  <!--内容块-->
  <div id="content" class="rows table-bordered clearfix" style="min-height: 534px;">

  </div>

</div>

<script>
    //页面加载完成后执行
    $(function () {
        //默认第一个菜单选中
        var obj = $(".nav").find("li").first();
        obj.addClass("active");
        //跳转到第一个页面url
        loadMenuContent(obj.attr("url"),"#content");
    });

    //一级菜单点击
    $(".nav li").click(function () {
        //改变菜单选中颜色，二级菜单不改变
        $(".navbar .active").removeClass("active");
        $(this).addClass("active");
        //根据不同的菜单跳转不同的页面url
        loadMenuContent($(this).attr("url"),"#content");
    });

    //加载菜单选中内容
    function loadMenuContent(url,selector) {
        if (url == null || url == "") {
            $(selector).html("<div style='text-align:center;margin-top:200px;'>暂无内容</div>");
            return;
        } else {
            $.ajax({
                type: "get",
                url: url,
                cache:false,
                success: function (data) {
                    //将页面写入div
                    $(selector).html(data);
                }
            });
        }
    }

    //登录按钮
    $(".logoutBtn").click(function(){
        layer.confirm('确认退出系统?',function(index){
            location.href = "<c:url value="/j_spring_security_logout" />";
        });
    });
</script>

</body>
</html>
