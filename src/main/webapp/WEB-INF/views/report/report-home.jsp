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
	<style type="text/css">.container .rows {padding-top: 20px;}</style>
	<!-- 验证表单 -->
	<script type="text/javascript" src="<c:url value="/resources/script/jquery.validate.min.js"/>"></script>
	<script>$.extend($.validator.messages, {required: "请输入必填项."});$(document).ready(function(){$('#form1').validate();});</script>
	<style type="text/css">
		input .error { border: 1px solid red;}
		label.error {color: #EA5200;}
		#loading{position:fixed;_position:absolute;top:50%;left:50%;width:124px;height:124px;overflow:hidden;background:url(<c:url value="/resources/image/loaderc.gif"/>) no-repeat;z-index:7; margin:-62px 0 0 100px; display: none;}
		.pagination>li>em {position:relative;float:left;padding:6px 12px;margin-left:-1px;line-height:1.428571429;text-decoration:none;background-color:#fff;border: 1px solid #ddd;border-top:none; border-bottom:none;}  
	</style>
	<!-- 分页 -->
	<link rel="stylesheet" href="<c:url value="/resources/css/jquery.pagination.css"/>" />
  	<script type="text/javascript" src="<c:url value="/resources/script/jquery.pagination.js"/>"></script>
	<!-- 日历 -->
	<%-- <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>" />
  	<script type="text/javascript" src="<c:url value="/resources/script/jquery-ui.js"/>"></script> --%>
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
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
		<h1 style="text-align: center">报表列表</h1>
		<div class="rows table-bordered clearfix" style="min-height: 534px;">
			<div class="col-sm-3 col-xs-4">
				<div class="lists" id="templs">
				</div>
			</div>
			<div class="col-sm-9 col-xs-8">
				
				<div id="myAlert1" class="alert alert-warning" style="display: none;">
				   <a href="#" class="close"  onclick="$('#myAlert1').fadeOut(500);">&times;</a>
				   <strong>提醒！</strong>没有查询到匹配的数据!
				</div>
				
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title" id="templName" style="font-weight: bold;margin-bottom: 10px;"></h3>
						<p id="templDesc" style="font-size: 12px;"></p>
						<form name="form1" class="clearfix" id="form1" action="<c:url value="/report/exportReport"/>" method="post" >
							<input type="hidden" name="id" id="reportId" value="" />
							<!-- 参数 -->
							<div id="params">
							</div>
							
							<div class="input-group" style="float: right">
								<button class="btn btn-default" id="previewReport" style="margin-right: 10px;"  type="button">查询</button>
								<button class="btn btn-primary" id="exportReport"  type="button">导出</button>
							</div>
						</form>
					</div>
					<div class="panel-body" style="display: none;" id="previewReportContent">
						
						<div class="table-responsive" style="max-height: 300px; overflow-y: scroll">
							<table class="table table-hover" cellpadding="0" cellspacing="0" border="0"  id="previewReportDiv"> 
							</table>
						</div>
						
						<div class="paging">
							<div id="Pagination" class="pagination"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 加载div -->
	<div id="loading"></div> 
	
	<script>
		var firstReportTempl = null;//第一个模板默认选中
		
		//页面加载完后执行
		$(function(){
			loadAllReportTempls(1);
		}); 
		
		//加载左边所有报表模板
		function loadAllReportTempls(isFirst){
			//加载左边所有报表模板
			$.ajax({
	        	type: "GET",
	            url: "<c:url value="/report/loadAllReportTempls"/>",
	            data: {},
	            dataType: "json",
	            success: function(data){
	            	var html = "";
	            	//遍历
	           		$.each(data, function(objIndex, obj){
	           			if(objIndex == 0) firstReportTempl = obj ;
	           			html += "<a class='list-group-item report' id='reportTempl" + obj['id'] + "' href='##' sid='" + obj['id'] + "' sname='" + obj['name'] + "' sdesc='" + obj['desc'] + "' title='" + obj['name'] + "' > "+ (objIndex+1) +" . " + obj['name'] + "</a>";
                   	});
	            	
					//填充
	           		$('#templs').html(html);
					
	           		//绑定左边列表点击加载右边参数
	        		$(".report").click(function(){
	        			//隐藏提示框
	        			$('#myAlert1').hide();
	        			
	        			//设置选中效果
	        			$("a.active").first().removeClass("active");
	        			$(this).addClass("active");
	        			
	        			//隐藏列表
	        			$("#previewReportContent").hide();
	        			//填充标题和描述
	        			$("#templName").text($(this).attr("sname"));
	        			$("#templDesc").text($(this).attr("sdesc"));
	        			$("#reportId").val($(this).attr("sid"));
	        			//加载参数
	        			loadReportParams($(this).attr("sid"));
	        		});
	           		
	           		//表示第一次加载
	        		if(isFirst == '1'){
	        			//第一个模板默认第一次选中
	        			$("#reportTempl"+firstReportTempl['id']).addClass("active");
	        			//默认加载第一个模板到右边
	        			$("#templName").text($("#reportTempl"+firstReportTempl['id']).attr("sname"));
	        			$("#templDesc").text($("#reportTempl"+firstReportTempl['id']).attr("sdesc"));
	        			$("#reportId").val($("#reportTempl"+firstReportTempl['id']).attr("sid"));
	        			//加载参数
	        			loadReportParams($("#reportTempl"+firstReportTempl['id']).attr("sid")); 
	        		}
	            }
			});
		}
		
		//加载选中报表的参数
		function loadReportParams(id){
			//加载选中报表的参数
			$.ajax({
	        	type: "GET",
	            url: "<c:url value="/report/loadReportParams"/>",
	            data: {"id":id},
	            dataType: "json",
	            success: function(data){
	            	//表示选中的模板有参数
	            	var html = "";
	            	//遍历
	           		$.each(data, function(objIndex, obj){
	           			//判断是否日期参数
	           			var datepickerClass = obj['valueClassName'] == 'java.util.Date' ? 'datepicker' : '';
	           			var readonly = obj['valueClassName'] == 'java.util.Date' ? "readonly='readonly'" : "";
						var isRequired = obj["properties"]["isRequired"] == "1" ? "required" : "";//是否必输项
						var isSelect = obj["properties"]["isSelect"];//是否下拉框
						var selectValues = obj["parameters"];//下拉框值集

						if (isSelect == "1") {
							//选择框
							html += "<div class='input-group'>" +
										"<label class='input-group-addon'>" + obj['description'] + "</label>" +
										"<select name='" + obj['name'] + "' class='form-control "+ isRequired +"'>";

							html += "<option value=''></option>";

							for (var i = 0; i < selectValues.length; i++) {
								var currValue = selectValues[i];
								html += "<option value=\"" + currValue['value'] + "\">" + currValue['name'] + "</option>";
							}

							html +=		"</select>" +
									"</div>" +
									"<br>";
						} else {
							//输入框
							html += "<div class='input-group'>" +
										"<label class='input-group-addon'>" + obj['description'] + "</label> <input type='text' name='" + obj['name'] + "' class='form-control "+ isRequired +" "+ datepickerClass +"' "+ readonly +" ></input>" +
									"</div>" +
									"<br>";
						}

                   	});
					//填充
	           		$('#params').html(html);
					
	           		$(".datepicker" ).datepicker({dateFormat: "yy-mm-dd"});
					
	            },error:function(data){
	            	//表示选中的模板没有参数
	           		$('#params').html("");//清空
	           		//及时预览
	           		previewReport();
	            }
			});
		}
		
		//导出
		$("#exportReport").click(function(){
			$('#form1').removeAttr('target');
			$('#form1').attr("action","<c:url value="/report/exportReport"/>");
			$('#form1').submit();
		});
		
		//预览按钮事件
		var pageDataMap = {}; //存放每个模板文件的分页数据的map，key为模板id，value为每页数据数组
		$("#previewReport").click(function(){
			if($("#form1").valid()){
				previewReport();
			}
		});
		
		//预览通用方法
		function previewReport(){
			$("#loading").show();
			//延迟加载,转圈圈
			setTimeout(function(){
				$.ajax({
		            cache: true,
		            type: "POST",
		            url:"<c:url value="/report/previewReport"/>",
		            data:$('#form1').serialize(),// 你的formid
		            async: false,
		            success: function(data) {
						
		            	if($(data).find("a").length < 1){
		            		$('#myAlert1').fadeIn(500);//显示提示框
		            		setTimeout(function (){$('#myAlert1').fadeOut(500);}, 3000);//自动隐藏提示框
		            		 //隐藏列表
			                $("#previewReportContent").hide();
			                //隐藏加载 
			                $("#loading").hide();
		            		return;
		            	}
		            	
		               	//存放当前模板每一页数据的数组
		                var pageDataArr = new Array($(data).find("a").length);
		               	//存储数组
		                $(data).find("a").each(function(i){
		                	//获取分页数据
		                	pageDataArr[i] = $(this).next().html();
		                });
		               	
		               	//将当前选中的模板id作为key
		               	var key = $("#reportId").val();
		               	//将当前每一页数据存进map中
		                pageDataMap[key] = pageDataArr;
		                
		                //获取第一页数据写进预览列表
		                var htmlData = pageDataMap[key][0];
		                
		                //写入页面
		                $("#previewReportDiv").html(htmlData);
		                //替换所有p标签
		                replacePInTempl();
		                //修改显示列表的分页数字
		                updatePagination(pageDataArr);
		                //显示列表
		                $("#previewReportContent").fadeIn(500);
		                //隐藏加载 
		                $("#loading").hide();
		            }
		        });
			},100);
			
			
		}
		
		//调整模板导出后的样式，替换所有的p标签
		function replacePInTempl(){
			 $("td p").each(function(){
                 var xx=$(this).html();
                 $(this).replaceWith(xx);
             });
			 //删除空数据
			 $("td").each(function(){
                 if($(this).html() == ""){
                	 $(this).parent().remove();
                 }
             });
		}
		
		/**分页**/
		var pageIndex = 0; //页面索引初始值   
	    var pageSize = 33; //每页显示条数初始化，修改显示条数，修改这里即可   
		function updatePagination(array){
			//总条数
	    	var totalCount = array.length * pageSize;
	    	//Load事件，初始化表格数据，页面索引为0（第一页）,默认选中第一页
			InitTable(0);
            //分页插件初始化，totalCount是总条目数，这是必选参数，其它参数都是可选
            $("#Pagination").pagination(totalCount,{
            	callback : PageCallback,//PageCallback() 为翻页调用次函数。
                prev_text : "«",
                next_text : "»",
                items_per_page : pageSize,
                num_edge_entries : 1,    //两侧首尾分页条目数
                num_display_entries : 9, //连续分页主体部分分页条目数
                current_page : pageIndex//当前页索引
            });
			
            //翻页调用   
            function PageCallback(index, jq) {             
                InitTable(index);  
            } 
            
            //请求数据   
            function InitTable(pageIndex) {  
            	//将当前选中的模板id作为key
               	var key = $("#reportId").val();
            	//写入
                var htmlData = pageDataMap[key][pageIndex];
                $("#previewReportDiv").html(htmlData);
              	//替换所有p标签
                replacePInTempl();
            }
		}
	</script>
	
</body>
</html>
