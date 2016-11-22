// JavaScript Document
// 2015.10.29 (c)贵州小小马驹科技有限公司

/**
 * 模式更换事件
 * <pre>
 * 处理流程：
 *  1.隐藏所有class为“main”的div
 *  2.显示当前所单击的<a>所对应的div子模块
 *  3.设置hidden标签“mode”
 * </pre>
 */
$(document).ready(function() {

    // 隐藏显示区域的其他div
    /*$('div.content').hide();*/

    // 显示默认div
    $('#index').show();

    // 目标div的ID值的前部分
    var firstName = 'include-';

    // 单击事件（事件委托）
   $('#navigation').click(function(event) {
        var bodyClass = event.target.id.split('-')[1];
        if ($(event.target).is('a')) {

            // 隐藏显示区域的其他div，即准备更换model
            $('div.content').hide();

            // var bodyClass = event.target.id.split('-')[1];

            // 获取当前<a>标签的id值
            var objectIdEndName = event.target.id;

            // 拼接<a>标签所对应的div的id
            var objectName = firstName + objectIdEndName;

            // 显示目标div
            $('#' + objectName).fadeIn('slow');

            // 变更模式状态值
            $('#modeName').css('value', objectIdEndName.replace('-',''));

            // [滚动广告] => [一览]
            if (objectIdEndName == "listview-banners") {

                $.ajax({
                        url:"./master/manage/banner/listViewBanner.action",
                        type:"POST",
                        dataType:"json",
                        success:function(data) {
                          if (data == undefined || data == "[]") {
                              $('#table_listView').append(
                                  "<tr>" +
                                  "<td></td>" +
                                  "<td></td>" +
                                  "<td>Here is empty!</td>" +
                                  "<td></td>" +
                                  "<td></td>" +
                                  "</tr>");
                          } else if ($('#table_listView tr:nth-child(2)').length < 1) {
                              //遍历data
                              $.each(data,function(i,value){
                                  $('#table_listView').append(
                                          "<tr>" +
                                          "<td>" + value.id + "</td>" +
                                          "<td>" + "<img class='img_min_size' src=" + value.imgPath + " />" + "</td>" +
                                          "<td>" + value.bannerTitle + "</td>" +
                                          "<td>" + value.type + "</td>" +
                                          "<td>" + value.status + "</td>" +
                                          "<td>" + value.publishDate + "</td>" +
                                          "</tr>");
                              });
                              
                          }
                        }
                },"json"); 
                /*
                $.getJSON(url,function(data){
                });
                 */
            }

            // [滚动广告] => [发布]
            if (objectIdEndName == "publish-banners") {
                
                $.ajax({
                    url:"./master/manage/banner/addBanner.action",
                    type:"POST",
                    dataType:"json",
                    success:function(data) {
                        if (data == undefined || data == "[]") {
                            $('#table_listView').append(
                                    "<tr>" +
                                    "<td></td>" +
                                    "<td></td>" +
                                    "<td>Here is empty!</td>" +
                                    "<td></td>" +
                                    "<td></td>" +
                            "</tr>");
                        } else if ($('#table_listView tr:nth-child(2)').length < 1) {
                            //遍历data
                            $.each(data,function(i,value){
                                $('#table_listView').append(
                                        "<tr>" +
                                        "<td>" + value.id + "</td>" +
                                        "<td>" + "<img class='img_min_size' src=" + value.imgPath + " />" + "</td>" +
                                        "<td>" + value.bannerTitle + "</td>" +
                                        "<td>" + value.type + "</td>" +
                                        "<td>" + value.status + "</td>" +
                                        "<td>" + value.publishDate + "</td>" +
                                "</tr>");
                            });
                            
                        }
                    }
                },"json"); 
                /*
                $.getJSON(url,function(data){
                });
                 */
            }
            // 停止事件委托
            event.stopPropagation();

        } 
    });
   

});

/**
 * 手动submit
 * @param formName from的name值
 */
function submitControl(formName) {

    // 操作的表单
    var thisForm = document.forms[formName];

    // 将要添加的hidden控件
    var hiddenInput = document.createElement("input");
    hiddenInput.type = "hidden";

    // 将hidden控件添加到表单中
    thisForm.appendChild(hiddenInput);

    // 设置hidden控件的属性
    hiddenInput.name="param.mode";
    hiddenInput.value = document.getElementById("modeName").value;

    // 提交表单
    thisForm.submit();

    // 移除添加的hidden控件
    thisForm.removeChild(hiddenInput);
}

