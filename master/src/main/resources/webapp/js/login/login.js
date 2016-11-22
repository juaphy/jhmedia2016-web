/* =====================================================
 * 工程名称：XiaoxiaoMaju.Web
 * 对象名称：login.js
 * 创建时间：2015年9月19日
 * 更新信息：2016年7月30日（广州市番禺区大石镇植村村东南街5号）
 * (R) Copyright 贵州小小马驹科技有限公司
 * =====================================================/

/* =====================================================
 * 有关后台登录机能的javaScript
 * <pre>
 * 概要: 声明有关后台登录机能的javaScript代码
 * 更新: 2015年9月19日 下午9:52:03
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 * =====================================================*/

/**
 * XMLHttpRequst对象的一个实例变量
 */
var xmlHttp;
$(function() {
    $("#login").on("click", function() {
        if(isEmpty($("#securityCode").val())) {
            layer.msg("请输入验证码！");
            return false;
        }
    });
});

/**
 * 判断字符串是否为空
 */
function isEmpty(obj) {
    return obj == null || obj == "" || obj == "null";
}
/**
 * 清除error消息
 */
function clearErrorMsg(objectName) {

   /* // 判定Ajax请求返回的服务器响应状态
    if (xmlHttp.readyState == 4) {
        if (xmlHttp.status == 200) {
        }
    }*/
    document.getElementById(objectName).innerHTML = "&nbsp;";
    document.getElementById("messages").innerHTML = "&nbsp;";
}

/**
 * New一个XMLHttpRequest
 */
function createXMLHttpRequest() {
    if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

/**
 * Ajax异步清除session中的errorMsg的值
 */
function clearSessionOfErrorMsg(objectName) {
    var url = "${path}/XiaoxiaoMaju.Web/master/clearErrorMsg.action";

    createXMLHttpRequest();

    // 指定请求属性
    xmlHttp.open("POST",url);

    // 发送请求
    xmlHttp.send(null);

    xmlHttp.onreadystatechange = clearErrorMsg(objectName);
}

function imgClick (objceId,path) {

    //点击图片更换验证码 
    objceId.src = path +
            "/master/login/SecurityCodeImageAction.action?timestamp="
            + new Date().getTime();
}
