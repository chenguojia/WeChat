<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar" style="display: ${isApp == '0' ? 'block' : 'none'}">
            <div class="navbar-inner">
                <div class="left"><a href="<c:url value='/new/m/more'/>" class="back link wechat-back"> <i class="icon icon-back card-back"></i></a></div>
                <div class="center sliding">公司简介</div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="background-color: #ffffff;">
                <!-- Scrollable page content-->
                <div class="page-content page-content-scroll ${isApp == '0' ? '' : 'none-navbar'}">
                    <div class="caseShare_pic aboutUs_titPic"><a href="#" class="caseShare-popup"><img src="<c:url value="/resources/newm/images/welcome.jpg"/>" width="100%"></a></div>
                    <div class="content-block caseShare_story">
                        <span>卡得万利商业保理（上海）有限公司（以下简称卡得万利）成立于2012年12月，注册资金5000万元人民币。其母公司-卡得万利信息技术（上海）有限公司是中国领先的消费信贷服务提供商，成立于2007年，专为中小企业提供消费信贷、融资咨询等服务，帮助中小企业快速发展。</span>
                        <p><span>卡得万利是商务部开展保理业试点后首批获准成立的商业保理和融资保理服务提供商，同时也是上海市政府指定的专门为小微零售商户提供融资服务的企业。自成立以来一直致力于解决小微企业的融资难题，目前已经为近百万家中小商户完成融资授信服务，覆盖全国31个省份300多个地级市，成为业内翘楚。卡得万利还与这些小伙伴们形成了长期合作的关系，首次签约服务的小微企业，二次及二次以上续约率达到60%以上。</span></p>
                        <p><span>我们的宗旨是以信用授信为核心，以小微企业为服务对象，推进小微企业诚信建设，直接推动金融创新，最终实现小微企业融资无门槛。在他们需要支持的时候，我们将坚定的站在他们身后给予他们支持，让他们在追求梦想的道路上无所畏惧。</span></p>
                        <p><span>2015年，卡得万利将持续以市场为导向、风险控制为前提、以客户为中心，以效益为目标，追求可持续发展，力争发展成为" 运作安全、内控严密、资本充足、服务优质、有核心竞争力"的现代金融服务企业。</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var myApp = new Framework7({
        modalTitle: '卡得万利商业保理',
        ajaxLinks: 'a.ajax'
    });
</script>
</body>
</html>