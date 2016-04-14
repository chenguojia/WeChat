<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=utf8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
	<title>最新活动</title>
	<style type="text/css">
		*{ margin:0;padding:0; background-color:#b60005;}
		img{ width:100%;}
		#content{ padding:0 5%; margin-top:20px;}
		.act{ margin-bottom:30px;}
		.act p{color:#fcca00; font-size:18px; padding-left:80px; margin-bottom:10px;height:33px; line-height:33px;}
		.act .act1{ background:url(<c:url value='/resources/image/campaign/new/list1.png'/>) no-repeat;  }
		.act .act2{ background:url(<c:url value='/resources/image/campaign/new/list2.png'/>) no-repeat; }
		.act .act3{ background:url(<c:url value='/resources/image/campaign/new/list3.png'/>) no-repeat; }
	</style>
</head>

<body>
<div id="container">
	<div id="header">
		<img src="<c:url value='/resources/image/campaign/new/bg.jpg'/>" />
	</div>
	<div id="content">
		<c:forEach var="item" items="${campaigns}" varStatus="i">
			<div class="act">
				<p class="title act${i.index + 1}">${item.memo}</p>
				<div>
					<a  data-ajax="false" href="<c:url value='${item.bannerClickUrl}'/>"><img src="<c:url value='${item.bannerPicUrl}'/>"/></a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>