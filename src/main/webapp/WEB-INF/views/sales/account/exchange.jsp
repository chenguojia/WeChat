<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %> 
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>
</head>
<body>
<div data-role="page" id="task-detail">
		<div data-role="header" data-position="fixed" data-theme="b" id="header">
			<h1>积分兑换</h1>
			<a data-transition="none" href="<c:url value="/"/>" class='ui-btn-right ui-btn-back'  data-icon="home">主页</a>
		</div>
        <div data-role="content" class="field">
         <div data-role="fieldcontain" class="readonly">
				<label for="integral">可用积分:</label><label id="integral" class="highlight">800分</label> 
			</div>
            <div data-role="fieldcontain" class="readonly">
				<label for="cumulative">累计积分:</label><label id="cumulative">800分</label><a data-transition="none" href="#"  class="ui-btn ui-corner-all ui-btn-inline ui-mini exchanged Integration" data-theme="c" >积分说明</a>
			</div>
            <div data-role="fieldcontain" class="readonly stage">
				<label for="grade">我的等级:</label><p id="grade" class="grade_1">金粉</p>  <a data-transition="none"  href="#"  class="ui-btn ui-corner-all ui-btn-inline ui-mini exchanged" data-theme="c" >等级说明</a>
			   <div data-role="fieldcontain">
                   <label></label> <p class="extrainfo"> 还有<span class="extrascore">200</span>分到<span class="nextgrade">钻石粉</span></p>
               </div>
			</div>
            <div data-role="fieldcontain">
            <label>积分兑换优惠券:</label>
            <div data-role="tabs" id="tabs">
            <div data-role="navbar">
            <ul>
            <li><a href="#one" data-ajax="false" class="ui-btn-active">手续费优惠券</a></li>
            <li><a href="#two" data-ajax="false">话费优惠券</a></li>
            </ul>
            </div>
                <div class="exchange" id="one">
                <p class="enable"><img src="<c:url value="/resources/image/coupons/100_enable.png"/>"/></p>
                <p class="enable"><img src="<c:url value="/resources/image/coupons/200_enable.png"/>"/></p>
                <p class="enable"><img src="<c:url value="/resources/image/coupons/300_enable.png"/>"/></p>
                <p class="enable"><img src="<c:url value="/resources/image/coupons/500_enable.png"/>"/></p>
                <p class="enable"><img src="<c:url value="/resources/image/coupons/1000_enable.png"/>"/></p>
                <p class="enable"><img src="<c:url value="/resources/image/coupons/1500_enable.png"/>"/></p>
                </div>
                <div class="exchange" id="two">
                <p class="enable"><img src="<c:url value="/resources/image/coupons/m_20_enable.png"/>"/></p>
                <p><img src="<c:url value="/resources/image/coupons/m_50_disable.png"/>"/></p>
              </div>
            </div>
			</div>
            <div data-role="fieldcontain">
           <p class="helpcheck"><a data-transition="none" href="#">我的优惠券<span>2</span></a></p>
           <p class="helpcheck"> <a data-transition="none" href="#">活动说明</a> | <a data-transition="none" href="#">优惠券使用说明</a></p>
            </div>
        </div>
		<div data-role="footer" data-position="fixed" data-theme="c">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a data-transition="none" href="<c:url value="/"/>"  data-icon="arrow-l" >返回</a></li>
					<li><a data-transition="none" href="<c:url value="/help/list"/>"  data-icon="info">发现</a></li>
				</ul>
			</div>
		</div>
           <div class="popup">
              <h2>确认框<button class="ui-btn ui-icon-delete ui-btn-icon-notext ui-corner-all close">关闭</button></h2>
              <div class="content"></div>
              <button class="ui-btn ui-corner-all ui-btn-inline">确定</button>
              </div>
      </div>
</body>
</html>