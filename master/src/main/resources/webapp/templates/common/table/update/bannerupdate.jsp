<%-- [滚动广告 修改 部分] --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- [START 滚动广告  修改] -->
<div id="include-update-banner" class="content">
    <s:form action="#path/master/manage.action" method="post">
    <!-- Content begins here -->
    <h2>滚动广告  修改</h2>
    <!-- Fieldset -->
    <fieldset>
        <div class="input_field">
            <label for="sf">新闻标题: </label> <input class="smallfield"
                name="sf" type="text" value="input text" /> <span
                class="field_desc">*</span>
        </div>

        <div class="input_field">
            <label for="mf">新闻日期: </label> <input class="mediumfield"
                name="mf" type="text" value="" /> <span
                class="validate_success">格式正确!</span>
        </div>

        <div class="input_field">
            <label for="lf">封面配图: </label> <input class="bigfield"
                name="lf" type="text" value="" /> <span
                class="validate_error">请上传新闻封面配图!</span>
        </div>
        <div class="input_field">
            <label for="newsType">新闻分类: </label> <span class="form_line"><input
                type="radio" name="newsType" class="radio" />行业资讯</span> <span
                class="form_line"><input type="radio"
                name="newsType" class="radio" />公司新闻</span> <span
                class="form_line"><input type="radio"
                name="newsType" class="radio" />教育新闻</span>
        </div>

        <div class="input_field">
            <label for="lf">新闻内容: </label>
            <textarea cols="50" rows="10"></textarea>
        </div>
        <div class="input_field no_margin_bottom">
            <input class="submit" type="submit" value="提交" /> <input
                class="submit" type="reset" value="重置" />
        </div>
    </fieldset>
    <!-- End of fieldset -->
    <br />
    </s:form>
</div>
<!-- [END 新闻中心 修改] -->
