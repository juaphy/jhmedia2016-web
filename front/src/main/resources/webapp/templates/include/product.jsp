<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8" />
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- product Start -->
<div class="cont">
  <div class="con_left">
    <div class="con_left1 clearfix">
      <div class="con_left_title "> 产品介绍 /<span>Product</span></div>
        <div class="sideMenu">
          <div class="con_left_title_main" style="text-align:left;"> 锐取 </div>
          <h3 class="" style="padding-left:50px;"><a href="http://www.szreach.com/spzx/gsxcp/">产品</a></h3>
          <h3 class="" style="padding-left:50px;"><a href="http://www.szreach.com/spzx/gsxcp/">视频</a></h3>
          
          <div class="con_left_title_main" style="text-align:left;"> 大娱号 </div>
          <h3 style="padding-left:50px;"><a href="http://www.szreach.com/spzx/wsp/">产品</a></h3>
          <h3 style="padding-left:50px;"><a href="http://www.szreach.com/spzx/wsp/">视频</a></h3>
        </div>
    <script type="text/javascript">
            jQuery(".sideMenu").slide({
                titCell:"h3", //鼠标触发对象
                targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
                effect:"slideDown", //targetCell下拉效果
                delayTime:300 , //效果时间
                triggerTime:150, //鼠标延迟触发时间（默认150）
                defaultPlay:true,//默认是否执行效果（默认true）
                returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
                });
        </script> 
    </div>
    </div>
  </div>
  <div class="con_right">
    <div class="con_right_title clearfix">
        <span>您所在的位置 &gt;
            <a href="index.html">主页</a> &gt; 
            <a href="product.html">产品介绍</a> &gt; 
        </span>
        <strong>产品介绍</strong>
    </div>
    <div class="con_right_case">
      <ul>
        <li>
            <a href="http://www.szreach.com/spzx/cpfa/229.html"><img src="images/product/product-01.jpg"></a>
            <div class="pic_txt"> <strong><a href="#">EasySet 3D</a></strong> </div>
        </li>
        <li>
            <a href="http://www.szreach.com/spzx/cpfa/228.html"><img src="images/product/product-02.jpg"></a>
            <div class="pic_txt"> <strong><a href="#">广播级录制解决方案</a></strong> </div>
        </li>
        <li>
            <a href="http://www.szreach.com/spzx/cpfa/227.html"><img src="images/product/product-03.jpg"></a>
            <div class="pic_txt"> <strong><a href="#">多媒体配件</a></strong> </div>
        </li>        
      </ul>
    </div>

    <!-- 页码 START -->
    <div class="fenye  ">
      <ul>
        <li>首页</li>
        <li class="thisclass">1</li>
        <li><a href="http://www.szreach.com/spzx/list_26_2.html">2</a></li>
        <li><a href="http://www.szreach.com/spzx/list_26_3.html">3</a></li>
        <li><a href="http://www.szreach.com/spzx/list_26_2.html">下一页</a></li>
        <li><a href="http://www.szreach.com/spzx/list_26_3.html">末页</a></li>
      </ul>
    </div>
    <!-- 页码 END -->
  </div>
<!-- product end -->