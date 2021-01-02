package com.ecpbm.pojo;

import java.util.List;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: AdminInfo
 * @USER: kagura
 * @Description TODO 管理员信息实体类，用于封装管理员信息
 * @Date 2021/1/2 2:41 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class AdminInfo {
    private Integer id;
    private String name;  // 管理员姓名
    private String pwd;  // 管理员密码
    private List<Functions> fs;  // 关联的属性

    // 生成私有属性对应的set和get方法
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<Functions> getFs() {
        return fs;
    }

    public void setFs(List<Functions> fs) {
        this.fs = fs;
    }
}
