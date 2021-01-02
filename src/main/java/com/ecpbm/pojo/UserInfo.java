package com.ecpbm.pojo;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: UserInfo
 * @USER: kagura
 * @Description TODO 用户信息实体类，用于封装客户信息
 * @Date 2021/1/2 2:27 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class UserInfo {
    private Integer id;
    private String userName;  // 登录名
    private String password;  // 登录密码
    private String realName;  // 真实姓名
    private String sex;  // 性别
    private String address;  // 地址
    private String email;  // 邮件地址
    private String regDate;  // 注册日期
    private Integer status;  // 用户状态

    // 生成私有属性对应的set和get方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
