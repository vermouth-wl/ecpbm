package com.ecpbm.pojo;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: Pager
 * @USER: kagura
 * @Description TODO 分页信息实体类，用于封装分页信息
 * @Date 2021/1/2 3:20 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class Pager {
    private Integer curPage;  // 待显示页
    private Integer perPageRows;  // 每页显示的记录数
    private Integer rowCount;  // 记录总数
    private Integer pageCount;  // 总页数

    // 根据rowCount和perPageRows计算总页数
    public int getPageCount() {
        return (rowCount + perPageRows - 1) / perPageRows;
    }

    // 分页显示，获取当前页的第一条记录的索引
    public int getFirstLimitParam() {
        return (this.curPage - 1) * this.perPageRows;
    }

    // 生成私有属性的set和get方法
    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPerPageRows() {
        return perPageRows;
    }

    public void setPerPageRows(Integer perPageRows) {
        this.perPageRows = perPageRows;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
