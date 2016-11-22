/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：Page.java
 * 创建时间：2016年8月2日 下午7:41:23
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页Entity
 * <pre>
 * 概要: 分页Entity
 * 更新: 2016年8月2日 下午7:41:23
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 5414749859596892513L;

    /**
     * 每页显示的记录条数
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    // 每页显示的记录条数
    private int pageSize = DEFAULT_PAGE_SIZE;

    // 当前页号，从1开始
    private int pageIndex = 1;

    // 总记录数
    private long resultCount;

    // 当前记录起始索引
    private int currentResult;

    // 页码显示开始 listbegin
    private int pageNumStart;

    // 页码显示结束 listend
    private int pageNumEnd;

    // 显示页码个数，默认为10
    private int showPageNum = 10;

    // Page判断 true：需要分页的地方，传入的参数是Page实体；
    // false:需要分页的地方，传入的参数所代表的实体拥有Page属性
    private boolean entityOrField;

    // 总页数
    private int totalPage;

    // 当前存放的记录（类型为list）
    private List<T> data = new ArrayList<T>();

    // PageData map对象
    private PageData pd = new PageData();

    /**
     * 无参构造方法
     */
    public Page() {

    }

    /**
     * 构造方法
     * @param pageIndex 当前页号
     * @param totalSize DB中总记录条数
     */
    public Page(Integer pageIndex, long totalSize) {
        this.pageIndex = pageIndex == null ? 1 : pageIndex;
        this.resultCount = totalSize;
        setPageNumStart(pageNumStart);
        setPageNumEnd(pageNumEnd);
    }

    /**
     * 构造方法
     * @param pageIndex 当前页码 
     * @param totalSize DB中总记录条数
     * @param pageSize 本页容量
     */
    public Page(Integer pageIndex, long totalSize, int pageSize) {
        this(pageIndex, totalSize);
        this.pageSize = pageSize;
    }

    /**
     * 构造方法
     * @param pageIndex 当前页码
     * @param totalSize DB中总记录条数
     * @param pageSize 本页容量
     * @param data 本页包含的数据
     */
    public Page(Integer pageIndex, long totalSize, int pageSize, List<T> data) {
        this(pageIndex, totalSize);
        this.pageSize = pageSize;
        this.setData(data);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 当前页
     * @return 第一条记录的截取位置
     */
    public int getPageIndex() {
        pageIndex = pageIndex < 1 ? 1 : pageIndex;
        pageIndex = getPageCount() < pageIndex ? getPageCount() : pageIndex;
        return pageIndex;
    }

    /**
     * 获取总页数
     * @return 符合查询条件的记录总数
     */
    public int getPageCount() {
        if (resultCount % pageSize == 0) {
            return (int) (resultCount / pageSize);
        } else {
            return (int) (resultCount / pageSize + 1);
        }
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getResultCount() {
        return resultCount;
    }

    public void setResultCount(long resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * 取得当前记录起始索引
     * @return
     */
    public int getCurrentResult() {
        currentResult = (getPageIndex() - 1) * getPageSize();
        if (currentResult < 0) {
            currentResult = 0;
        }
        return currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

    public int getPageNumStart() {
        return pageNumStart;
    }

    /**
     * 设置显示页码的开始部分
     * <br/>
     * Math.ceil()向上取整计算，返回大于或等于函数参数，并且与之最接近的整数
     * @param pageNumStart
     * <br/>
     * <pre>
     * 算法：
     * 1.如果"接近显示页码个数的一半的最大值">= 当前页码:则值设为1
     * 2.如果当前页码 + 接近显示页码个数的一半的最大值 > 总页数：
     *    1).总页数与显示页码个数的差+1是否小于等于0，如果小于等于0，则设置显示页码的开始为1
     *    2).如果大于0，则显示页码的开始值为:总页数与现实页码个数的差+1
     * 3.如果当前页码 + 接近显示页码个数的一半的最大值 <= 总页数: 
     *    则显示页码的开始值为：当前页码-接近显示页码个数的一半的最大值+1
     * </pre>
     */
    public void setPageNumStart(int pageNumStart) {
        int hafPage = (int) Math.ceil((double) showPageNum / 2);

        // 如果上述计算的结果大于等于当前页码
        if (pageIndex <= hafPage) {
            this.pageNumStart = 1;
        } else {

            // 如果当前页码 + 接近显示页码个数的一半的最大值 > 总页数
            if (getPageCount() < pageIndex + hafPage) {

                // 总页数与显示页码个数的差+1是否小于等于0，如果小于等于0，则设置显示页码的开始为1
                // 如果大于0，则显示页码的开始值为 总页数与现实页码个数的差+1
                this.pageNumStart = (getPageCount() - showPageNum + 1) <= 0 ?
                        1 : (getPageCount() - showPageNum + 1);

            // 如果当前页码 + 接近显示页码个数的一半的最大值 <= 总页数
            // 则显示页码的开始值为：当前页码-接近显示页码个数的一半的最大值+1
            } else {
                this.pageNumStart = pageIndex - hafPage + 1;
            }
        }
    }

    public int getPageNumEnd() {
        return pageNumEnd;
    }

    /**
     * 设置显示页码的结束值
     * <pre>
     * 1.如果当前页码小于等于Math.ceil(显示页码个数的一半)，则值设定为：
     *    1）显示页码个数大于总页数：则值为“总页数”
     *    2）显示页码个数小于等于总页数：则值为“显示页码个数的值”
     * 2.Math.ceil(显示页码个数的一半)+当前页码 >= 总页数：则值为“总页数”
     * 3.Math.ceil(显示页码个数的一半)+当前页码 < 总页数：则值为“Math.ceil(显示页码个数的一半)+当前页码”
     * </pre>
     * @param pageNumEnd
     */
    public void setPageNumEnd(int pageNumEnd) {
        int hafPage = (int) Math.ceil((double) showPageNum / 2);
        if (pageIndex <= hafPage) {
            this.pageNumEnd = getPageCount() < showPageNum ?
                    getPageCount() : showPageNum;
        } else {
            if (getPageCount() <= hafPage + pageIndex) {
                this.pageNumEnd = getPageCount();
            } else {
                this.pageNumEnd = pageIndex + hafPage;
            }
        }
    }

    public int getShowPageNum() {
        return showPageNum;
    }

    public void setShowPageNum(int showPageNum) {
        this.showPageNum = showPageNum;
    }

    public boolean isEntityOrField() {
        return entityOrField;
    }

    public void setEntityOrField(boolean entityOrField) {
        this.entityOrField = entityOrField;
    }

    /**
     * 取得总页数
     * @return
     */
    public int getTotalPage() {
        if (resultCount % pageSize == 0) {
            totalPage = (int) (resultCount / pageSize);
        } else {
            totalPage = (int) (resultCount / pageSize + 1);
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 取得当前页中包含的数据
     * @return 当前页数据
     */
    public List<T> getData() {
        if (this.data == null) {
            this.data = new ArrayList<T>();
        }
        return data;
    }

    /**
     * 设置当前页包含的数据
     * @param data 当前页数据
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    public PageData getPd() {
        return pd;
    }

    public void setPd(PageData pd) {
        this.pd = pd;
    }

    /**
     * 获取第一条数据
     * @return
     */
    public T getFirstData() {
        return ListUtil.isBlank(data) ? null : data.get(0);
    }

    /**
     * 判断该页是否还有下一页
     * @return
     */
    public boolean hasNextPage() {
        return this.getPageIndex() < this.getPageCount() - 1;
    }

    /**
     * 判断是否有上一页
     * @return 如果当前页码大于0，则返回true；否则返回false
     */
    public boolean hasPreviousPage() {
        return this.getPageIndex() > 0;
    }

    /**
     * 获取任意一页第一条数据在数据集中的位置
     * @param pageSize 每页的容量
     * @return 该页第一条数据在符合条件的查询结果集中的位置
     */
    public int getStartOfPage(int pageSize) {
        return (pageIndex - 1) * pageSize;
    }

    /**
     * 获取下一页
     * @return 如果当前页码+1 大于总页数，则返回总页数；反之，返回当前页码+1的数值
     */
    public int getNextPage() {
        return this.getPageIndex() + 1 > this.getPageCount()?
                this.getPageCount() : this.getPageIndex() + 1;
    }

    /**
     * 获取上一页
     * @return 如果当前页码-1大于0，则返回当前页码-1的值；反之，小于等于0，则返回1
     */
    public int getPrePage() {
        return this.getPageIndex() - 1 > 0 ? this.getPageIndex() - 1 : 1;
    }

    /**
     * 获取“查询时记录从哪一行开始”对应的值
     * <pre>
     * 1).如果当前页码小于等于0：(1 - 1) * 每页显示的记录条数
     * 2).如果当前页码大于0：（当前页码-1）* 每页显示的记录条数
     * </pre>
     * @return
     */
    public long getStart() {
        return ((this.getPageIndex() <= 0 ?
                1 : this.getPageIndex())- 1) * pageSize;
    }

    public long getSize() {
        return (this.getPageIndex() <= 0 ? 1 : this.getPageIndex()) * pageSize;
    }

    /**
     * 获取分页信息（用于页面显示的分页文本）
     */
    public String getPageStr() {
        StringBuffer sb = new StringBuffer();
        totalPage = getTotalPage();
        if (getResultCount()>0) {
            sb.append("<div class=\"message\">共<i class=\"blue\">"
                   +resultCount + "</i>条记录，当前显示第&nbsp;<i class=\"blue\">"
                   + pageIndex + "&nbsp;</i>页,共&nbsp;<i class=\"blue\">"
                   + totalPage + "&nbsp;</i>页</div>");
            sb.append(" <ul class=\"paginList\">\n");
            if (pageIndex==1) {
                sb.append(" <li class=\"paginItem\"><a>首页</a></li>\n");
                sb.append(" <li class=\"paginItem\"><a><span class=\"pagepre\"></span></a></li>\n");
            } else {
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage(1)\">首页</a></li>\n");
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                        + (pageIndex - 1) + ")\"><span class=\"pagepre\"></span></a></li>\n");
            }

            //分页标签显示数量
            int showTag = 5;
            int startTag = 1;
            if (showTag < pageIndex) {
                startTag = pageIndex - 1;
            }
            int endTag = startTag+showTag - 1;
            for (int i = startTag; i <= totalPage && i <= endTag; i++) {
                if(pageIndex == i) {
                    sb.append("<li class=\"paginItem current\"><a href=\"javascript:;\">"
                            + i + "</a></li>\n");
                } else {
                    sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                            + i +")\">" + i + "</a></li>\n");
                }
            }
            if (pageIndex == totalPage) {
                sb.append(" <li class=\"paginItem\"><a><span class=\"pagenxt\"></span></a></li>\n");
                sb.append(" <li class=\"paginItem\"><a>尾页</a></li>\n");
            } else {
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                        + (pageIndex + 1) + ")\"><span class=\"pagenxt\"></span></a></li>\n");
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                        + totalPage + ")\">尾页</a></li>\n");
            }

            sb.append("</ul>\n");
            sb.append("<script type=\"text/javascript\">\n");

            // 换页函数
            sb.append("function nextPage(page){");
            sb.append(" ");
            sb.append(" if(true && document.forms[0]){\n");
            sb.append("     var url = document.forms[0].getAttribute(\"action\");\n");
            sb.append("     if(url.indexOf('?')>-1){url += \"&" + (entityOrField ? "pageIndex" : "page.pageIndex") + "=\";}\n");
            sb.append("     else{url += \"?" + (entityOrField ? "pageIndex":"page.pageIndex") + "=\";}\n");
            sb.append("     url = url + page + \"&" + (entityOrField ? "pageSize":"page.pageSize") + "=" + pageSize + "\";\n");
            sb.append("     document.forms[0].action = url;\n");
            sb.append("     document.forms[0].submit();\n");
            sb.append(" }else{\n");
            sb.append("     var url = document.location+'';\n");
            sb.append("     if(url.indexOf('?')>-1){\n");
            sb.append("         if(url.indexOf('pageIndex')>-1){\n");
            sb.append("             var reg = /pageIndex=\\d*/g;\n");
            sb.append("             url = url.replace(reg,'pageIndex='+page);\n");
            sb.append("         }else{\n");
            sb.append("             url += \"&" + (entityOrField ? "pageIndex" : "page.pageIndex") + "=\"+page;\n");
            sb.append("         }\n");
            sb.append("     }else{url += \"?" + (entityOrField ? "pageIndex" : "page.pageIndex") + "=\"+page;}\n");
            sb.append("     url = url  + \"&" + (entityOrField ? "pageSize" : "page.pageSize") + "=" + pageSize + "\";\n");
            sb.append("     document.location = url;\n");
            sb.append(" }\n");
            sb.append("}\n");

            // 调整每页显示条数
            sb.append("function changeCount(value){");
            sb.append(" ");
            sb.append(" if(true && document.forms[0]){\n");
            sb.append("     var url = document.forms[0].getAttribute(\"action\");\n");
            sb.append("     if(url.indexOf('?')>-1){url += \"&" + (entityOrField ? "pageIndex" : "page.pageIndex") + "=\";}\n");
            sb.append("     else{url += \"?" + (entityOrField ? "pageIndex" : "page.pageIndex") + "=\";}\n");
            sb.append("     url = url + \"1&" + (entityOrField ? "pageSize" : "page.pageSize") + "=\"+value;\n");
            sb.append("     document.forms[0].action = url;\n");
            sb.append("     document.forms[0].submit();\n");
            sb.append(" }else{\n");
            sb.append("     var url = document.location+'';\n");
            sb.append("     if(url.indexOf('?')>-1){\n");
            sb.append("         if(url.indexOf('pageIndex')>-1){\n");
            sb.append("             var reg = /pageIndex=\\d*/g;\n");
            sb.append("             url = url.replace(reg,'pageIndex=');\n");
            sb.append("         }else{\n");
            sb.append("             url += \"1&" + (entityOrField ? "pageIndex" : "page.pageIndex") + "=\";\n");
            sb.append("         }\n");
            sb.append("     }else{url += \"?" + (entityOrField? "pageIndex" : "page.pageIndex") + "=\";}\n");
            sb.append("     url = url + \"&" + (entityOrField? "pageSize" : "page.pageSize") + "=\"+value;\n");
            sb.append("     document.location = url;\n");
            sb.append(" }\n");
            sb.append("}\n");

            sb.append("</script>\n");
        }
        String pageStr = sb.toString();
        return pageStr;
    }

    /**
     * 基于异步请求的分页查询，获取页码，需要页面自己完善nextPage()
     */
    public String getPageStrOnAjax() {
        StringBuffer sb = new StringBuffer();
        totalPage = getTotalPage();
        if(0 < getResultCount()){
            sb.append("<div class=\"message\">共<i class=\"blue\">"
                    + resultCount + "</i>条记录，当前显示第&nbsp;<i class=\"blue\">"
                    + pageIndex + "&nbsp;</i>页,共&nbsp;<i class=\"blue\">"
                    + totalPage + "&nbsp;</i>页</div>");
            sb.append(" <ul class=\"paginList\">\n");
            if(pageIndex == 1){
                sb.append(" <li class=\"paginItem\"><a>首页</a></li>\n");
                sb.append(" <li class=\"paginItem\"><a><span class=\"pagepre\"></span></a></li>\n");
            }else{
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage(1)\">首页</a></li>\n");
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                        + (pageIndex - 1) + ")\"><span class=\"pagepre\"></span></a></li>\n");
            }

            //分页标签显示数量
            int showTag = 5;
            int startTag = 1;
            if(showTag < pageIndex){
                startTag = pageIndex - 1;
            }
            int endTag = startTag+showTag - 1;
            for (int i = startTag; i <= totalPage && i <= endTag; i++){
                if (pageIndex == i) {
                    sb.append("<li class=\"paginItem current\"><a href=\"javascript:;\">"
                            + i + "</a></li>\n");
                } else {
                    sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                            + i + ")\">" + i + "</a></li>\n");
                }
            }
            if (pageIndex == totalPage) {
                sb.append(" <li class=\"paginItem\"><a><span class=\"pagenxt\"></span></a></li>\n");
                sb.append(" <li class=\"paginItem\"><a>尾页</a></li>\n");
            } else {
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                        + (pageIndex + 1) + ")\"><span class=\"pagenxt\"></span></a></li>\n");
                sb.append(" <li class=\"paginItem\" style=\"cursor:pointer;\"><a onclick=\"nextPage("
                        + totalPage + ")\">尾页</a></li>\n");
            }

            sb.append("</ul>\n");
        }
        String pageStr = sb.toString();
        return pageStr;
    }

}
