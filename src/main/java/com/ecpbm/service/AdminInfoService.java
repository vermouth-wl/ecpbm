package com.ecpbm.service;

import com.ecpbm.pojo.AdminInfo;

/**
 * @PACKAGE_NAME: com.ecpbm.service
 * @CLASS_NAME: AdminInfoService
 * @USER: kagura
 * @Description TODO 管理员信息业务逻辑接口
 * @Date 2021/1/17 7:10 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface AdminInfoService {

    // 登录验证
    public AdminInfo login(AdminInfo ai);

    // 根据管理员编号，获取管理员对象及关联的功能权限
    public AdminInfo getAdminInfoAndFunctions(Integer id);
}
