<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://dev.jtsage.com/cdn/datebox/latest/jqm-datebox.min.css" /> 
<script type="text/javascript" src="http://dev.jtsage.com/cdn/datebox/latest/jqm-datebox.core.min.js"></script>
<script type="text/javascript" src="http://dev.jtsage.com/cdn/datebox/latest/jqm-datebox.mode.calbox.min.js"></script>
<script type="text/javascript" src="http://dev.jtsage.com/cdn/datebox/i18n/jquery.mobile.datebox.i18n.zh-CN.utf8.js"></script>
</head>
<body>
	<div data-role="page" id="pos-installation-leads-create">
		<div data-role="header" data-position="fixed" data-theme="b" >
			<h1>提交开业宝线索</h1>
			<a href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
		<div data-role="content">
			<form id="sumitForm" action="<c:url value='/leads/create'/>" method="post" class="validate">
				<input type="hidden" name="token" value="${token}"/>
				<div data-role="fieldcontain">
					<label for="merchantNumber">商户编号：</label> 
					<input type="text" name="merchantNumber" id="merchantNumber" value="${leads.merchantNumber}" maxlength="15" placeholder="如果没有商编可以不填"/>
				</div>
				<div data-role="fieldcontain">
					<label for="merchantName">商户名称：</label> 
					<input type="text" name="merchantName" id="merchantName" value="${leads.merchantName}" class="required"/>
				</div>
				<%--<div data-role="fieldcontain">
					<label for="merchantMcc">商户MCC编码：</label>
					<div style="display: inline-block; width:100%">
						<div class="ui-block-a" style="width:60%">
							<input type="text" id="merchantMcc" name="merchantMcc" value="" maxlength="4">
						</div>
						<div class="ui-block-b" style="width:40%">
							<input type="button" data-type="button" data-theme="b" id="check-mcc-button" value="检测MCC">
						</div>
					</div>
					<label style="font-size:12px">注：部分行业暂时不能申请开业宝，请先输入MCC编码检测</label>
				</div>--%>
				<div data-role="fieldcontain">
					<label for="merchantIndustry">商户行业：</label> 
					<form:select path="leads.merchantIndustry" class="required">
						<form:options items="${industries}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="merchantProvince">经营省份：</label> 
					<form:select path="leads.provinceId" class="required">
						<form:options items="${provinces}" itemLabel="name" itemValue="id"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="merchantCity">经营地市：</label> 
					<form:select path="leads.regionId" class="required">
						<form:options items="${citys}" itemLabel="name" itemValue="id"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="merchantCity">经营地段：</label> 
					<form:select path="leads.businessLocation" class="required">
						<form:options items="${businessLocations}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>				
				<div data-role="fieldcontain">
					<label for="businessArea">营业面积(平方米)：</label> 
					<form:select path="leads.businessArea" class="required">
						<form:options items="${businessAreas}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="staffNumber">员工人数：</label> 
					<form:select path="leads.staffNumber" class="required">
						<form:options items="${staffNumbers}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="merchantContact">联系人姓名：</label> 
					<input type="text" name="merchantContact" id="merchantContact" class="required"/>
				</div>
				<div data-role="fieldcontain">
				    <fieldset data-role="controlgroup">
   						<legend>身份:</legend>
						<form:radiobuttons path="leads.contactPosition" items="${positions}" itemLabel="name" itemValue="value" class="required"/>
					</fieldset>							
				</div>
				<div data-role="fieldcontain">
					<label for="contactMobile">手机号码：</label> 
					<input type="text" name="contactMobile" id="contactMobile" class="required mobile"/>
				</div>
				<div data-role="fieldcontain">
					<label for="managerEducationLevel">经营人学历：</label> 
					<form:select path="leads.managerEducationLevel" class="required">
						<form:options items="${educationLevels}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="managerMarriageStatus">经营人婚姻状况：</label> 
					<form:select path="leads.managerMarriageStatus" class="required">
						<form:options items="${marriageStatuses}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="managerChildrenStatus">经营人子女状况：</label> 
					<form:select path="leads.managerChildrenStatus" class="required">
						<form:options items="${childrenStatuses}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="managerHukouStatus">经营人户口状况：</label> 
					<form:select path="leads.managerHukouStatus" class="required">
						<form:options items="${hukouStatuses}" itemLabel="name" itemValue="value"/>
					</form:select>	
				</div>
				<div data-role="fieldcontain">
					<label for="estimatedRevenue">预计营业额(月)：</label> 
					<input type="text" name="estimatedRevenue" id="estimatedRevenue" class="required"/>
				</div>									
				<div data-role="fieldcontain">
					<label for="memo">备注：</label> <input type="text" name="memo" id="memo" />
				</div>
				<%-- 产品类型 ：装机贷--%>
				<input type="hidden" name="product" value="3"/>
				<input type="submit" id="submitButton" data-theme="b" value="确认" />
			</form>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href='<c:url value="${backUrl}"/>'  class="ui-btn-icon-left ui-icon-back">返回</a></li>
					<li><a href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
		<div style="max-width:400px;" data-theme="a" data-overlay-theme="b" id="mccPopupDialog" data-role="popup">
			<div class="ui-corner-top ui-header ui-bar-a" data-theme="b" data-role="header" data-role="banner">
				<h1 class="ui-title" data-role="heading" id="title">有效MCC</h1>
			</div>
			<div class="ui-corner-bottom ui-content" data-role="main">
				<p id="message">您输入的MCC编码在开业宝受理范围内，请继续填写并申请</p>
				<a data-theme="a" data-rel="back" data-role="button" href="#" >关&nbsp;&nbsp;闭</a>
			</div>
		</div>		
		<script type="text/javascript">
			var mccRegex = /\d{4}/ ;
		
			//加载城市级联
			$("#pos-installation-leads-create").on("pageinit",function(){
				refreshRegionByProvince();	
				var checkMccUrl = "<c:url value="/rest/mcc/check/"/>";
				$("#check-mcc-button").click(function(){
					var mcc = $.trim($("#merchantMcc").val());
					if(mccRegex.test(mcc)){
						$.get(checkMccUrl + mcc, function(data){
							if(data.code == "success"){
								var category = data.message.split(",")[0];
								var flag = data.message.split(",")[1];
//								alert("category is " + category + ",flag is " + flag);
								$("#merchantIndustry").val(category);
								$('#merchantIndustry').selectmenu('refresh', true);
								if(flag == 0 && category != "其他类"){
									$("#submitButton").button('enable');
									$("#mccPopupDialog #title").html("有效MCC");
									$("#mccPopupDialog #message").html("您输入的MCC编码在开业宝受理范围内，请继续填写并申请");
								}else{
									$("#submitButton").button('disable'); 
									$("#mccPopupDialog #title").html("无效MCC");
									$("#mccPopupDialog #message").html("非常抱歉，您输入的MCC编码不在开业宝的受理范围内");
								}
							}else{
								$("#submitButton").button('disable');
								$("#mccPopupDialog #title").html("无效MCC");
								$("#mccPopupDialog #message").html("非常抱歉，您输入的MCC编码不能识别，请检查输入是否有误");
							}
							$("#submitButton").button('refresh'); 
						});
					}else{
						$("#mccPopupDialog #title").html("无效MCC");
						$("#mccPopupDialog #message").html("MCC一般为4位数字，请正确输入");
					}
					$("#mccPopupDialog").popup("open");
				});
			});
		</script>		
	</div>
</body>
</html>
