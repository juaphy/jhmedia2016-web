<%-- [新闻发布] --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- [START 新闻中心 发布] -->
<div id="include-add-news" class="content">
    <s:form action="/master/manage/news.action" method="post" name="news">
    <!-- Content begins here -->
    <h2>新闻中心 修改</h2>
    <!-- Fieldset -->
    <fieldset>
        <div class="input_field">
            <label for="sf">新闻标题: </label>
            <input class="smallfield" name="param.news.newsName" type="text" value="" id="newsName" />
            <span class="field_desc" id="newsTitleVMK">*</span>
        </div>

        <div class="input_field">
            <label for="mf">新闻日期: </label>
            <input class="mediumfield" name="param.news.newsAddDateTime" type="text" value="" />
            <span class="field_desc" id="newsDateVMK">*</span>
        </div>

        <div class="input_field">
            <label for="lf">封面配图: </label>
            <input class="bigfield" name="param.news.newsPicture" type="text" value="" />
            <span class="field_desc" id="newsPicVMK">*</span>
        </div>
        <div class="input_field">
            <label for="newsType">新闻分类: </label>
            <span class="form_line">
                <input type="radio" name="param.news.newsType" class="radio" value="1"/>行业资讯
            </span>
            <span class="form_line">
                <input type="radio" name="param.news.newsType" class="radio" value="2"/>公司新闻
            </span> 
            <span class="form_line">
                <input type="radio" name="param.news.newsType" class="radio" value="3"/>教育新闻
            </span>
        </div>

        <div class="input_field">
            <label for="lf">新闻内容: </label>
            <textarea cols="50" rows="10" name="param.news.newsDetailed"></textarea>
        </div>
        <div class="input_field no_margin_bottom">
            <input class="submit" type="button" value="提交" onclick="submitControl('news');" />
            <input class="submit" type="reset" value="重置" />
            <span class="textField">(*为必须 输入项)</span>
        </div>
    </fieldset>
    <!-- End of fieldset -->
    <br />
    </s:form>
</div>
<!-- [END 新闻中心 发布] -->