<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
	<div data-role="page" id="merchant-apply">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>申请融资</h1>
			<a href="<c:url value="/m/home"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form:form action="apply" method="post" class="validate"  modelAttribute="dto">
				<input type="hidden" name="token" value="${token}"/>
				<c:if test="${credit != '暂无额度'}">
					<div data-role="fieldcontain" class="readonly">
						<label>授信额度：</label>
						<label>${credit}</label> 
					</div>
					<div data-role="fieldcontain">
						<label for="loanAmount">申请额度：</label> 
						<form:input path="loanAmount" placeholder="例：10000" type="number" class="required"/>
						<form:errors path="loanAmount" cssClass="error"/>
					</div>				
					<div data-role="fieldcontain">
						<label for="paybackPeriod">还款时间：</label> 
						<select name="paybackPeriod" id="paybackPeriod" class="required">
							<option value="">--- 请选择 ---</option>
							<option value="1">1个月</option>
							<option value="2">2个月</option>
							<option value="3">3个月</option>
						</select>
						<form:errors path="paybackPeriod" cssClass="error"/>
					</div>
					<div data-role="fieldcontain" class="readonly">
						<label>手续费(月)：</label><label id="handlingCharge">0</label>
					</div>
				</c:if>
				
				<div data-role="fieldcontain">
					<label for="contactName">联系人姓名：</label> 
					<form:input path="contactName" placeholder="例：李晓明" class="required" value="${userInfo.name }" minlength="2"/>
					<form:errors path="contactName" cssClass="error"/>
				</div>
				<div data-role="fieldcontain">
					<label for="contactMobile">联系手机号：</label> 
					<form:input path="contactMobile" placeholder="例：13965437789"  class="required" value="${userInfo.mobile }"/>
					<form:errors path="contactMobile" cssClass="error"/> 
				</div>
				<c:if test="${fn:length(coupons) > 0}">
				<div data-role="fieldcontain">
					 <fieldset data-role="controlgroup">
				        <legend>优惠券</legend>
				        <c:forEach items="${coupons}" var="coupon">
				        	<input name="coupon-${coupon.couponNumber}" id="coupon-${coupon.couponNumber}" class="cb-coupon" type="checkbox" data-amount="${coupon.amount}" data-number="${coupon.couponNumber}">
				       	 	<label for="coupon-${coupon.couponNumber}">${coupon.amount}元现金券</label>
				        </c:forEach>
				        <form:hidden path="couponNumbers"/>
				    </fieldset>
					<label style="color:red; margin-top: 10px;">提示：当您同时使用多张优惠券时，每张优惠券额度相加不能超过200元！</label>
				</div>
				</c:if>							
				<div data-role="fieldcontain">
					<label for="memo">备注：</label> 
					<form:textarea path="memo" rows="5" cols="30" />
				</div>		
				
				<input type="submit" id="submitButton" data-theme="b" value="确认" />
				<a href="<c:url value="/m/showRefer"/>"  data-role="button">转介申请</a>
			</form:form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-rel="back" href="#"  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/m/help"/>"  data-icon="info">帮助</a></li>
				</ul>
			</div>
		</div>	
		<script type="text/javascript">
 			$("#merchant-apply").on("pageinit", function(){
				var maxCouponAmount = 200;
				$(".cb-coupon").click(function(){
					var selectedCouponAmount = 0;
					var selectedCouponNumbers = '';
					$(".cb-coupon:checked").each(function(i){
						selectedCouponAmount += parseInt($(this).attr('data-amount'));
						if(i == 0){
							selectedCouponNumbers = $(this).attr('data-number');
						}else{
							selectedCouponNumbers = selectedCouponNumbers + "," + $(this).attr('data-number');
						}
						
					});
					$("#couponNumbers").val(selectedCouponNumbers);
					$(".cb-coupon:not(:checked)").each(function(){
						if(selectedCouponAmount + parseInt($(this).attr('data-amount')) > maxCouponAmount){
							$(this).prop('disabled', true);
						}else{
							$(this).prop('disabled', false);
						}
					});
					
				});
				
				//计算手续费
				$("#loanAmount").blur(function(){
					//授信额度
					var credit = parseFloat("${creditLine}");
					
					//申请额度
					var loanAmount = parseFloat($(this).val());
					
					if(loanAmount > credit){
						alert("你的申请额度不能大于授信额度！请重新输入!");
						$(this).val("");
						return;
					}
					
					var minAmount = loanAmount*(1.6/100);
					var maxAmount = loanAmount*(3/100);
					var title = minAmount + "~" + maxAmount;
					$("#handlingCharge").html(title);
				});
			});
			
			
		</script>	
	</div>
</body>
</html>