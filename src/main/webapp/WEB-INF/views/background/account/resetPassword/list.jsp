<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel-heading">
    <h3 class="panel-title" id="templName" style="font-weight: bold;margin-bottom: 10px;"></h3>

    <p id="templDesc" style="font-size: 12px;"></p>

    <form name="form1" class="clearfix" id="form1" action="<c:url value="/report/exportReport"/>"
          method="post">
        <input type="hidden" name="id" id="reportId" value=""/>
        <!-- 参数 -->
        <div id="params">
        </div>
        <div class="input-group" style="float: right">
           <%-- <button class="btn btn-primary batchPassBtn " type="button" parentUrl="<c:url value="/background/${moduleName}/init"/>" status="1">通过</button>--%>
        </div>
    </form>
</div>

<!--动态数据-->
<div class="panel-body">
    <%--内容--%>
    <div class="table-responsive" style="max-height:300px;overflow-y:scroll">
        <table class="table table-hover" cellpadding="0" cellspacing="0" border="0" id="myTable">

        </table>
    </div>

    <div class="paging">
        <div id="Pagination" class="pagination"></div>
    </div>
</div>


<script>

    $(function () {
        bindShowModalBtnEvent();//绑定公用显示模态窗体
        initPagination();//初始化分页
    });

    //左边列表点击事件
    $(".list-group-item").click(function () {
        //选中样式
        $(this).parent().find(".active").removeClass("active");
        $(this).addClass("active");
    });

    /**分页**/
    var pageIndex = 0; //页面索引初始值
    var pageSize = "${queryPageModel.pageSize}"; //每页显示条数初始化，修改显示条数，修改这里即可
    function initPagination() {
        //总条数
        var totalCount = "${queryPageModel.totalCount}";
        //Load事件，初始化表格数据，页面索引为0（第一页）,默认选中第一页
        InitTable(0);
        //分页插件初始化，totalCount是总条目数，这是必选参数，其它参数都是可选
        $("#Pagination").pagination(totalCount, {
            callback: PageCallback,//PageCallback() 为翻页调用次函数。
            prev_text: "«",
            next_text: "»",
            items_per_page: pageSize,
            num_edge_entries: 1,    //两侧首尾分页条目数
            num_display_entries: 9, //连续分页主体部分分页条目数
            current_page: pageIndex//当前页索引
        });

        //翻页调用
        function PageCallback(index, jq) {
            InitTable(index);
        }

        //请求数据
        function InitTable(pageIndex) {
            var pageNum = parseInt(pageIndex) + 1;
            $.ajax({
                type: "get",
                url: "<c:url value="/background/${moduleName}/list?currPageNum="/>" + pageNum,
                async: false,
                cache: false,
                success: function (data) {
                    //将页面写入div
                    $("#myTable").html(data);
                    //重新绑定公用显示模态窗体
                    bindShowModalBtnEvent();
                }
            });
        }
    }

    //绑定公用显示模态窗体
    function bindShowModalBtnEvent(){
        $(".showModalBtn").click(function(){
            //加载内容到模态窗体div
            loadMenuContent($(this).attr("url"),"#modalContent");
            //显示模态窗体
            $('#myModal').modal('show');
        });
    }

</script>