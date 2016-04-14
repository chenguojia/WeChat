<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<style type="text/css">
body{ overflow-y:hidden;}
</style>
</head>
<body>
<div data-role="page" id="nearby" >
	<div id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>附近商铺</h1>
			<a data-transition="none" id="showmap" class='ui-btn ui-shadow ui-corner-all ui-btn-icon-left ui-icon-myicon ui-btn-b'>地图模式</a> <a data-transition="none" href="<c:url value="/"/>"
				class='ui-btn-right ui-btn-back' data-icon="home">主页</a>
		</div>
		<div id="wrapper">
      		<div id="scroller">
        		<div id="pullDown"> <span class="pullDownIcon"></span> <span class="pullDownLabel">准备刷新</span> </div>   
				<ul data-role="none" class="sort">
				  <li class="filter"> <a href="javascript:;">
				    <p data-value="500"><span>500</span>m</p>
				    </a> </li>
				  <li class="sortlist"> <a href="javascript:;">
				    <p data-value="DISTANCE">按距离</p>
				    </a> </li>
				</ul>
				<ul id="distance" class="listview">
				  <li><a href="">
				    <p data-value="300"><span>300</span>m</p>
				    </a></li>
				  <li class="index"><a href="">
				    <p data-value="500"><span>500</span>m</p>
				    </a></li>
				  <li><a href="">
				    <p data-value="800"><span>800</span>m</p>
				    </a></li>
				  <li><a href="">
				    <p data-value="1000"><span>1000</span>m</p>
				    </a></li>
				</ul>
				<ul id="sortlist" class="listview">
				  <li class="index"><a href="">
				    <p data-value="DISTANCE">按距离</p>
				    </a></li>
				  <li><a href="">
				    <p data-value="AMOUNT">按额度</p>
				    </a></li>
				</ul>
				
				<ul id="applications" class="list-grid">
				
				</ul>
				<div id="pullUp"> <span class="pullUpIcon"></span><span class="pullUpLabel">显示更多</span> </div>
			</div>
		</div>		
	</div>
 	<div id="detail">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
    	<h1>地图模式</h1>
     	<a data-transition="none" data-ajax="false" onclick="showlist()" class='ui-btn ui-shadow ui-corner-all ui-btn-icon-left ui-icon-bullets ui-btn-b'>列表模式</a>
    	<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a> </div>
		<div id="allmap">
		</div>
		<div class="changeposition">
	    <input id="checkbox1" data-role="none" type="checkbox" name="checkbox" value="更换当前位置">更换当前位置
	    </div>
	</div>
	<div class="loadingimage"><img src="<c:url value="/resources/image/ajax-loader.gif"/>"/></div>
	<div class="overlay"></div>
	<div data-role="footer" data-position="fixed" data-theme="c">
	  <div data-role="navbar" data-iconpos="left">
	    <ul>
	 <li><a data-ajax="false" data-transition="none" href="<c:url value="/sales/myMerchant"/>"  class="ui-btn-icon-left ui-icon-back">上一页</a></li>
	      <li><a data-transition="none" href="<c:url value='/help/list'/>"  data-icon="info">发现</a></li>
	    </ul>
	  </div>
	</div>
 <script type="text/javascript" src="http://api.map.baidu.com/api?type=quick&amp;ak=B826df082d0efc90620aeac58b4df2d0&amp;v=1.0"></script>	
 <script type="text/javascript" src="<c:url value="/resources/script/iscroll.js"/>"></script>
 <script type="text/javascript">
	var myScroll;
	var pullDownEl;
	var pullDownOffset;
	var pullUpEl;
	var pullUpOffset;
	//var num = 1;
	//var time=10;
	var myicon;
	var pagenum = 1;
	var pagecount;
	var map;	
	var marker2;
	var region;
	var time;
	var el;
	var openInfoWinFuns;
	var userPoint;
	var fetchDataUrl = '<c:url value="/merchant/search?number="/>';
	
	function pullDownAction() {//上拉事件
		pagenum--;
		setTimeout(function(){fetchData();}, 1000); //1秒
	}
	
	function pullUpAction() {
		pagenum++;
		setTimeout(function(){fetchData();}, 1000); //1秒
	}
	
	//map.addEventListener("click", showInfo);
	
	function showInfo(e){
			map.removeOverlay(marker2);
			userPoint=new BMap.Point(e.point.lng, e.point.lat);
			marker2=new BMap.Marker(userPoint,{icon:myicon});
			map.addOverlay(marker2);
			fetchData();
			$("#checkbox1").prop("checked",false);
			map.removeEventListener("click", showInfo);
	}

             
  	function loaded() {//加载完成
	    el = document.getElementById('applications');
        pullDownEl = document.getElementById('pullDown');
        pullUpEl = document.getElementById('pullUp');
   		pullUpOffset = pullUpEl.offsetHeight;
   		pullDownOffset = pullDownEl.offsetHeight;

		myScroll = new iScroll(
            	'wrapper', {
    				useTransition : true,
    				topOffset : pullDownOffset,
                    onRefresh : function() {
    					if (pullDownEl.className.match('loading')) {
    						pullDownEl.className = '';
    						pullDownEl.querySelector('.pullDownLabel').innerHTML = '请稍候，正在加载...';
                        } else if (pullUpEl.className.match('loading')) {
                            pullUpEl.className = '';
                           	pullUpEl.querySelector('.pullUpLabel').innerHTML = '请稍候，正在加载...';
                        }
                    },
                    onScrollMove : function() {
                        if (this.y > 5 && !pullDownEl.className.match('flip')) {
                        	if(pagenum<=1){
                        		pullDownEl.querySelector('.pullDownLabel').innerHTML = '当前是第一页';
                        	}else{
                        		pullDownEl.className = 'flip';
                                pullDownEl.querySelector('.pullDownLabel').innerHTML = '准备刷新...';
                                this.minScrollY = 0;
                        	}
                        } else if (this.y < 5
                                        && pullDownEl.className.match('flip')) {
                            pullDownEl.className = '';
                            pullDownEl.querySelector('.pullDownLabel').innerHTML = '准备刷新...';
                            this.minScrollY = -pullDownOffset;
                        } else if (this.y < (this.maxScrollY - 5)
                                        && !pullUpEl.className.match('flip')) {
                        	if(pagenum == pagecount){
                        		pullUpEl.querySelector('.pullUpLabel').innerHTML = '无更多记录';							                    		
                        	}else{
                        		pullUpEl.className = 'flip';
        						pullUpEl.querySelector('.pullUpLabel').innerHTML = '准备刷新...';
                        	}
                        	this.maxScrollY = this.maxScrollY;
                        } else if (this.y > (this.maxScrollY + 5)
                                        && pullUpEl.className.match('flip')) {
                        	pullUpEl.className = '';
                           	pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉显示更多...';
                           	this.maxScrollY = pullUpOffset;
                        }
                    },
                    onScrollEnd : function() {
                    	if (pullDownEl.className.match('flip')) {
    						pullDownEl.className = 'loading';
    						pullDownEl.querySelector('.pullDownLabel').innerHTML = '开始加载...';
    						pullDownAction(); // Execute custom function (ajax call?)
    					} else if (pullUpEl.className.match('flip')) {
    						pullUpEl.className = 'loading';
                            pullUpEl.querySelector('.pullUpLabel').innerHTML = '开始加载...';
                            pullUpAction(); // Execute custom function (ajax call?)
                        }
                     }
    			});
		
        //地图开始
        map= new BMap.Map("allmap");
        userPoint=new BMap.Point("${userLng}", "${userLat}");
        $("#checkbox1").click(function(){
    		if($(this).prop("checked")=="checked" || $(this).prop("checked")==true){
    			map.addEventListener("click", showInfo);
    			}
    		else{
    			map.removeEventListener("click", showInfo);
    			}
    	});
        
        map.centerAndZoom(userPoint, 16);
        
		map.addControl(new BMap.ZoomControl()); 
		map.addControl(new BMap.ScaleControl());
		myicon=new BMap.Icon("http://api.map.baidu.com/img/markers.png",new BMap.Size(23,25), {
			offset: new BMap.Size(10, 25),
			imageOffset: new BMap.Size(0, -250)
		});
		//TODO: 需要替换,显示客户经理当前位置
		
		marker2=new BMap.Marker(userPoint,{icon:myicon});
		map.addOverlay(marker2);
		var gc = new BMap.Geocoder();  
		gc.getLocation(userPoint, function(rs){
			var addComp = rs.addressComponents;
			region=addComp.city;
		});
		
		openInfoWinFuns=[];
		window.openInfoWinFuns = null;
		
		//上下拉部分开始
          setTimeout(function() {
                  document.getElementById('wrapper').style.left = '0';
          }, 800);
			
		//排序项数量
		var num=$(".sort").children().length;
		//排序下拉框		  
		$(".sort>li").click(function(){
			var index=$(this).index();
			var listview=$(".listview");
			if(listview[index].style.display==""||listview[index].style.display=="none"){
				for(var i=0;i<num;i++){
					if(i==index){
						continue;
					}
					listview[i].style.display="none";
				}
				listview[index].style.display="block";
			}else{
				listview[index].style.display="none";
			}
		});

		//点击排序项
		$(".listview li").click(function(){
			$(this).addClass("index");
			$(this).siblings().removeClass("index");
			var index=$(this).parent().index();
			var sortm=$(".sort>li");
			sortm[index-2].innerHTML=$(this).html();
			$(this).parent().hide();
			fetchData();
		});
			
		$("#showmap").click(function(){
			$("#task-detail").css("visibility","hidden");
			$("#detail").css("visibility","visible");
		});
		fetchData();	

	}
	document.addEventListener('touchmove', function(e) {e.preventDefault();}, false);
//地图部分js
	
function showlist(){
	$("#detail").css("visibility","hidden");
	$("#task-detail").css("visibility","visible");
	
}

function addMarker(poi, index){
	var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png", new BMap.Size(23, 25), {
		offset: new BMap.Size(10, 25),
		imageOffset: new BMap.Size(0, 0 - index * 25)
	});
	var p=new BMap.Point(poi.lng, poi.lat);
	var marker = new BMap.Marker(p, {icon: myIcon});
	map.addOverlay(marker);
	return marker;
}

function removeMarker(){
	map.clearOverlays();
	map.addOverlay(marker2);
}
//var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
function walk(lat,lng){
	//map.clearOverlays();
	var p=new BMap.Point(lng,lat);
	var start = {
		latlng: userPoint
	};
	var end = {
		latlng: p
	};
	var opts = {
		mode:BMAP_MODE_WALKING,
		region:region
	};
	var ss = new BMap.RouteSearch();
	ss.routeCall(start,end,opts);
}

function drive(lat,lng){
	//map.clearOverlays();
	var p=new BMap.Point(lng,lat);
	var start = {
		latlng: userPoint
	};
	var end = {
		latlng: p
	};
	var opts = {
		mode:BMAP_MODE_DRIVING,
		region:region
	};
	var ss = new BMap.RouteSearch();
	ss.routeCall(start,end,opts);
}

function addInfoWindow(mark,poi,index){
	// infowindow的标题
	var infoWindowTitle = '<div style="font-weight:bold;color:#CE5521;font-size:14px">'+poi.name+'</div>';
	// infowindow的显示信息
	var infoWindowHtml = [];
	infoWindowHtml.push('<table class="infoWindow" cellspacing="0" style="table-layout:fixed;width:100%;font:12px arial,simsun,sans-serif"><tbody>');
	infoWindowHtml.push('<tr>');
	infoWindowHtml.push('<td style="vertical-align:top;line-height:16px;white-space:nowrap;word-break:keep-all">商户编号： </td>');
	infoWindowHtml.push('<td style="vertical-align:top;line-height:16px">'+poi.id+'</td>');
	infoWindowHtml.push('</tr>');
	infoWindowHtml.push('<tr>');
	infoWindowHtml.push('<td style="vertical-align:top;line-height:16px;white-space:nowrap;word-break:keep-all">额度： </td>');
	infoWindowHtml.push('<td style="vertical-align:top;line-height:16px">'+poi.creditLabel+'元</td>');
	infoWindowHtml.push('</tr>');
	infoWindowHtml.push('</tbody></table>');
	infoWindowHtml.push("<div><p>到这里去:</p><button class='drive ui-btn-inline ui-btn' onclick='drive("+poi.lat+","+poi.lng+")'>驾车</button><button class='walk ui-btn-inline ui-btn' onclick='walk("+poi.lat+","+poi.lng+")'>步行</button></div>");
	var infoWindow = new BMap.InfoWindow(infoWindowHtml.join(""),{title:infoWindowTitle,width:220,height:130}); 	
	var openInfoWinFun = function(){
	  mark.openInfoWindow(infoWindow);
	  for(var cnt = 0; cnt < 10; cnt++){
	      if(!document.getElementById("list" + cnt)){continue;}
	      if(cnt == index){
	          document.getElementById("list" + cnt).style.backgroundColor = "#f0f0f0";
	      }else{
	          document.getElementById("list" + cnt).style.backgroundColor = "#fff";
	      }
	  	}
	}
	mark.addEventListener("click", openInfoWinFun);
	return openInfoWinFun;
}


function showloadingimage(className){
	 var top = ($(window).height() - $(className).height())/2;   
     var left = ($(window).width() - $(className).width())/2;   
     var scrollTop = $(document).scrollTop();   
     var scrollLeft = $(document).scrollLeft();
     $(className).css( {  'top' : top + scrollTop +"px", left : left + scrollLeft +"px","display":"block"} );  
     $(".overlay").show();
}

function hideloadingimage(className){
	 $(className).hide();
	$(".overlay").hide();
}

function fetchData(){
	showloadingimage(".loadingimage");
	var range = $("li.filter p").attr("data-value");
	var sortField = $("li.sortlist p").attr("data-value");
 	$.ajax({
		dataType:'json',
		url:'<c:url value="/sales/listAroundMerchants"/>',
		data:{range:range, sortField:sortField, page:pagenum, lat:userPoint.lat, lng:userPoint.lng},
		success: function(json){
			if(json.code == "success"){
				while(el.hasChildNodes()){
					el.removeChild(el.firstChild);
				}
				removeMarker();
				$.each(json.payload, function(i, item){
					$('<li><a data-ajax="false" href="'+ fetchDataUrl + item.mid + '"><h4>'+ item.name+'</h4><div class="info"><p class="credit">授信额度: </span><span>'
							+ item.creditLabel+'元</span></p><p class="howlong"><span>'
							+ item.distanceLabel+'</span>m</p></div></a></li>').appendTo(el);
					var mark=addMarker(item,i,time);
					openInfoWinFuns=[];
					var openInfoWinFun = addInfoWindow(mark,item,i);
					 openInfoWinFuns.push(openInfoWinFun);
				});
				pagenum = json.pageNum;
				pagecount = json.pageCount;
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '准备刷新';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '显示更多';
				myScroll.refresh();
				hideloadingimage(".loadingimage");
			}
		 },
	 });
}

  
$("#nearby").on("pageshow", function(){
	loaded();	
});
</script>
</div>

</body>
</html>
