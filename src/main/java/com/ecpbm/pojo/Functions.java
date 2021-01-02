package com.ecpbm.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: Functions
 * @USER: kagura
 * @Description TODO 系统功能实体类，用于封装系统功能信息
 * @Date 2021/1/2 2:45 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class Functions implements Comparable<Functions> {
    private Integer id;
    private String name;  // 功能菜单名称
    private Integer parentId;  // 父节点id
    private boolean isLeaf;  // 是否叶子节点
    private Set ais = new HashSet();  // 关联的属性

    // 重写compareTo()方法，用于排序时将两个Functions对象的id进行比较，根据比较结果返回负、零、正
    @Override
    public int compareTo(Functions arg0) {
        return ((Integer) this.getId().compareTo((Integer) arg0.getId()));
    }

    // 生成set和get方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public Set getAis() {
        return ais;
    }

    public void setAis(Set ais) {
        this.ais = ais;
    }
}
