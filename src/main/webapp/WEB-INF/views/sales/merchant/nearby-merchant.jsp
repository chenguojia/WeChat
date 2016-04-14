<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
<script src="<c:url value='/resources/script/scrollpagination.js'/>"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=B826df082d0efc90620aeac58b4df2d0">
</script>
<script>
$(document).ready(function(){
	/*默认先加载几条数据*/
	var time=10;
	//init(time);
	$('#applications').scrollPagination({
		'contentPage': 'company.json', // the url you are fetching the results
		'contentData': {}, // these are the variables you can pass to the request, for example: children().size() to know which page you are
		'scrollTarget': $(window), // who gonna scroll? in this example, the full window
		'loadeachtime': time,
		'heightOffset': 10, // it gonna request when scroll is 10 pixels before the page ends
		'beforeLoad': function(){ // before load function, you can display a preloader div
			$('#loading').fadeIn();	
		},
		'afterLoad': function(elementsLoaded){ // after loading content, you can use this function to animate your new elements
			 $('#loading').fadeOut();
			// var i = 0;
			 $(elementsLoaded).fadeInWithDelay();
			/* if ($('#content').children().size() > 30){ 
			 	$('#nomoreresults').fadeIn();
				$('#content').stopScrollPagination();
			 }*/
			 //$('#nomoreresults').fadeIn();
			 //$('#applications').stopScrollPagination();
		}
	});

	

	// code for fade in element by element
	$.fn.fadeInWithDelay = function(){
		var delay = 0;
		return this.each(function(){
			$(this).delay(delay).animate({opacity:1}, 200);
			delay += 100;
		});
	};
	

	//recommend();
	var c=$("#applications li").clone();
	var num=$(".sort").children().length;
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
			}
		else{
			listview[index].style.display="none";
			}
		});
	$(".listview li").click(function(){
		$(this).addClass("index");
		$(this).siblings().removeClass("index");
		var index=$(this).parent().index();
		var sortm=$(".sort>li");
		sortm[index-2].innerHTML=$(this).html();
		$(this).parent().hide();
		sortlist(c);
		recommend();
		});
		$("#showmark").click(function(){
		removeMarker();
		$(".removeanchor").remove();
		var index;
		$("#applications li").each(function(){
			//alert("offsettop: "+ $(this).offset().top + " scrolltop: "+ );
		if(parseInt($(window).height())>= parseInt($(this).offset().top-$(document).scrollTop()) && parseInt($(this).outerHeight()+$(this).offset().top-$(document).scrollTop())>=parseInt($(window).height())){
			index=$(this).index();
			$(this).append("<a class='removeanchor' name='anchor'> </a>");
		}
		else if($(document).scrollTop()>=$(document).height()-$(window).height()){
			index=$("#applications li").last().index();
			$(this).append("<a class='removeanchor' name='anchor'> </a>");
			}
		});
		var x=parseInt(index/time);
			$("#detail").show();
		$("#task-detail").hide();
		$.getJSON("company.json",function(json){				
			for(i=x*time;i<x*time+time;i++){
				openInfoWinFuns = [];
				var mark=addMarker(json[i],i,time);
				var openInfoWinFun = addInfoWindow(mark,json[i],i);
				openInfoWinFuns.push(openInfoWinFun);
				}		
			});
		//time.stopPropagation();    
	});

	});


function recommend(){
	var recommendtitle=$(".recommend p").text();
	var distance=parseInt($(".filter a p span").text());
	var count=$(".list-grid>li").length;
	//alert(count);
	$(".list-grid>li").each(function(){
		var shopdistance=parseInt($(this).find(".howlong").children("span").text());
		if(distance>=shopdistance){
			if(recommendtitle=="推荐"){
				if($(this).find("h4").hasClass("star")){
					$(this).show();
					}
				else{
					$(this).hide();
					}
			}
			else{
				$(this).show();
				}
			}
		else{
			$(this).hide();
			}
		
	});
	}
	
	
function filter(){
var distance=parseInt($(".filter a p span").text());
	$("#applications li").each(function(){
		var shopdistance=parseInt($(this).find(".howlong").children("span").text());
		if(distance<shopdistance){
			$(this).hide();
			}
			else{
				$(this).show();
				}
		});
	}
	
function sortlist(c){
	var sortlist=$(".sortlist a p").text();
	var application=$(".list-grid>li");
	var count= application.length;
	//alert(count);
	if(sortlist=="按距离"){
	for(var j=count;j>=0;j--){
		for(var i=0;i<j;i++){
			if(parseInt($(".list-grid li").eq(i).find(".howlong").children("span").text())>=parseInt($(".list-grid li").eq(i+1).find(".howlong").children("span").text())){	
			$(".list-grid li").eq(i+1).after($(".list-grid li").eq(i));	
				}
		}
	}
	
  }
	else if(sortlist=="按额度"){
		for(var j=count;j>=0;j--){
		for(var i=0;i<j;i++){
			if(parseInt($(".list-grid li").eq(i).find(".credit").children("span").text())<=parseInt($(".list-grid li").eq(i+1).find(".credit").children("span").text())){				
				$(".list-grid li").eq(i+1).after($(".list-grid li").eq(i));
				}
			}
		}
		}

	else if(sortlist=="按等级"){
	for(var j=count;j>=0;j--){
		for(var i=0;i<j;i++){
			if(parseInt($(".list-grid li").eq(i).find(".creditlevel").children("span").attr("class"))<= parseInt($(".list-grid li").eq(i+1).find(".creditlevel").children("span").attr("class"))){				
				$(".list-grid li").eq(i+1).after($(".list-grid li").eq(i));
				}
			}
		}
	}
	};
	
		
function showmap(){
	$("#detail").hide();
	$("#task-detail").show();
	var childhas="#anchor";
	window.location.href  = window.location.hostname +childhas;
	}
</script>
</head>

<body>
<div data-role="page" id="nearby" >
<div id="task-detail">
  <div data-role="header" data-position="fixed" data-theme="b" id="header">
    <h1>附近商铺</h1>
     <a data-transition="none" data-ajax="false" id="showmark" class='ui-btn ui-shadow ui-corner-all ui-btn-icon-left ui-icon-myicon'>地图模式</a>
   <a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a> </div>
  <ul data-role="none" class="sort">
    <li class="filter"> <a href="javascript:;">
      <p><span>1000</span>m</p>
      </a> </li>
    <li class="sortlist"> <a href="javascript:;">
      <p>按距离</p>
      </a> </li>
      <li class="recommend"> <a href="javascript:;">
      <p>所有</p>
      </a> </li>
  </ul>
  <ul id="distance" class="listview">
    <li><a href="">
      <p><span>500</span>m</p>
      </a></li>
    <li class="index"><a href="">
      <p><span>1000</span>m</p>
      </a></li>
    <li><a href="">
      <p><span>1500</span>m</p>
      </a></li>
    <li><a href="">
      <p><span>2000</span>m</p>
      </a></li>
  </ul>
  <ul id="sortlist" class="listview">
    <li class="index"><a href="">
      <p>按距离</p>
      </a></li>
    <li><a href="">
      <p>按等级</p>
      </a></li>
    <li><a href="">
      <p>按额度</p>
      </a></li>
  </ul>
  <ul id="recommend" class="listview">
    <li class="index"><a href="">
      <p>所有</p>
      </a></li>
    <li><a href="">
      <p>推荐</p>
      </a></li>
  </ul>
  <div>
    <ul id="applications" class="list-grid">
     
    </ul>
    <div class="loading" id="loading">数据加载中，请稍候</div>
    <div class="loading" id="nomoreresults">数据已加载完成</div>
  </div>
</div>

  <div id="detail">
<div data-role="header" data-position="fixed" data-theme="b" id="header">
    <h1>地图模式</h1>
     <a data-transition="none" data-ajax="false" onclick="showmap()" class='ui-btn ui-shadow ui-corner-all ui-btn-icon-left ui-icon-bullets' >列表模式</a>
    <a data-transition="none" href="#" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a> </div>
<div id="allmap">
</div>
</div>

  <div data-role="footer" data-position="fixed" data-theme="c">
    <div data-role="navbar" data-iconpos="left">
      <ul>
   <li><a data-ajax="false" data-transition="none" href="<c:url value="/sales/myMerchant"/>"  class="ui-btn-icon-left ui-icon-back">上一页</a></li>
        <li><a data-transition="none" href="<c:url value='/help/list'/>"  data-icon="info">发现</a></li>
      </ul>
    </div>
  </div>
</div>
<script>
var map = new BMap.Map("allmap");
map.addControl(new BMap.ZoomControl()); 
map.centerAndZoom(new BMap.Point(121.525353,31.215407), 15);
var myicon=new BMap.Icon("http://api.map.baidu.com/img/markers.png",new BMap.Size(23,25), {
    offset: new BMap.Size(10, 25),
    imageOffset: new BMap.Size(0, -250)
  });
var p2=new BMap.Point(121.525353,31.215407);
var marker2=new BMap.Marker(p2,{icon:myicon});
map.addOverlay(marker2);
var gc = new BMap.Geocoder();  
var region;  
 gc.getLocation(p2, function(rs){
        var addComp = rs.addressComponents;
        region=addComp.city;
    });
window.openInfoWinFuns = null;
function addMarker(poi, index,time){
	var n=parseInt(index%time);
  var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png", new BMap.Size(23, 25), {
    offset: new BMap.Size(10, 25),
    imageOffset: new BMap.Size(0, 0 - n * 25)
  });
  var p=new BMap.Point(poi.lat,poi.lng);
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
	var p=new BMap.Point(lat,lng);
    //driving.search(p2,p);
	var start = {
	     latlng: p2
	}
	var end = {
	    latlng: p
	}
	var opts = {
	    mode:BMAP_MODE_WALKING,
		region:region
	}
	var ss = new BMap.RouteSearch();
	ss.routeCall(start,end,opts);
}
function drive(lat,lng){
	//map.clearOverlays();
	var p=new BMap.Point(lat,lng);
    //driving.search(p2,p);
	var start = {
	     latlng: p2
	}
	var end = {
	    latlng: p
	}
	var opts = {
	    mode:BMAP_MODE_DRIVING,
		region:region
	}
	var ss = new BMap.RouteSearch();
	ss.routeCall(start,end,opts);
}

function addInfoWindow(mark,poi,index){
    var maxLen = 5;
    // infowindow的标题
    var infoWindowTitle = '<div style="font-weight:bold;color:#CE5521;font-size:14px">'+poi.name+'</div>';
    // infowindow的显示信息
    var infoWindowHtml = [];
    infoWindowHtml.push('<table cellspacing="0" style="table-layout:fixed;width:100%;font:12px arial,simsun,sans-serif"><tbody>');
	infoWindowHtml.push('<tr>');
    infoWindowHtml.push('<td style="vertical-align:top;line-height:16px;white-space:nowrap;word-break:keep-all">商户编号： </td>');
    infoWindowHtml.push('<td style="vertical-align:top;line-height:16px">'+poi.ID+'</td>');
    infoWindowHtml.push('</tr>');
    infoWindowHtml.push('</tbody></table>');
	infoWindowHtml.push("<div><p>到这里去:</p><button class='drive ui-btn-inline ui-btn' onclick='drive("+poi.lat+","+poi.lng+")'>驾车</button><button class='walk ui-btn-inline ui-btn' onclick='walk("+poi.lat+","+poi.lng+")'>步行</button></div>");
    var infoWindow = new BMap.InfoWindow(infoWindowHtml.join(""),{title:infoWindowTitle,width:200,height:100}); 	
    var openInfoWinFun = function(){
        mark.openInfoWindow(infoWindow);
        for(var cnt = 0; cnt < maxLen; cnt++){
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
</script>
</body>
</html>
