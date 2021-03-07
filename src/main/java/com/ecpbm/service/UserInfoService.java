package com.ecpbm.service;

import com.ecpbm.pojo.Pager;
import com.ecpbm.pojo.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.service.impl
 * @CLASS_NAME: UserInfoService
 * @USER: kagura
 * @Description TODO 用户信息业务逻辑接口
 * @Date 2021/1/17 7:09 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface UserInfoService {

    // 获取合法客户
    public List<UserInfo> getValidUser();

    // 根据客户编号查询客户
    public UserInfo getUserInfoById(int id);

    // 分页显示用户
    List<UserInfo> findUserInfo(UserInfo userInfo, Pager pager);

    // 客户计数
    Integer count(Map<String, Object> params);

    // 修改指定编号的客户状态
    void modifyStatus(String ids, int flag);
}
