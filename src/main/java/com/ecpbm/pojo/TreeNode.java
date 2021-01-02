package com.ecpbm.pojo;

import java.util.List;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: TreeNode
 * @USER: kagura
 * @Description TODO 系统显示菜单实体类，用于封装树形空间的节点信息
 * @Date 2021/1/2 3:34 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class TreeNode {
    private Integer id;  // 节点id
    private String text;  // 节点名称
    private Integer fid;  // 父节点id
    private List<TreeNode> children;  // 包含的子节点

    // 私有属性对应的set和get方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
