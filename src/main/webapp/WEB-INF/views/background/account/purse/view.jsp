<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="modal-header">
    <%--关闭图标--%>
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <%--标题--%>
    <h4 class="modal-title" id="myModalLabel">
        查看提现详情
    </h4>
</div>
<div class="modal-body">
    <%--内容--%>
    <form action="" method="post" id="myform">
        <table class="table table-bordered">
            <tr>
                <td>姓名</td>
                <td><c:out value="${user.username}"/></td>
            </tr>
            <tr>
                <td>省份</td>
                <td><c:out value="${branchLabel}"/></td>
            </tr>
            <tr>
                <td>城市</td>
                <td><c:out value="${regionLabel}"/></td>
            </tr>
            <tr>
                <td>手机</td>
                <td><c:out value="${sales.mobile}"/></td>
            </tr>
            <tr>
                <td>微信名称</td>
                <td><c:out value="${user.weId}"/></td>
            </tr>
            <tr>
                <td>提现金额</td>
                <td><fmt:formatNumber value="${returnObj.amount}" pattern="###.##" /></td>
            </tr>
            <tr>
                <td>用户余额</td>
                <td><fmt:formatNumber value="${returnObj.balance}" pattern="###.##" /></td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${returnObj.createDate}"/></td>
            </tr>
            <tr>
                <td>状态</td>
                <td>
                    <c:if test="${returnObj.flag == 0}">待处理</c:if>
                    <c:if test="${returnObj.flag == 1}">已通过</c:if>
                    <c:if test="${returnObj.flag == 2}">已驳回</c:if>
                </td>
            </tr>
            <%--驳回是显示理由--%>
            <c:if test="${returnObj.flag == 2}">
                <tr>
                    <td>理由</td>
                    <td class="wordWrap"><c:out value="${returnObj.reason}"/></td>
                </tr>
            </c:if>
        </table>
    </form>
</div>
<div class="modal-footer" style="text-align:center;">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
</div>

<script>

</script>