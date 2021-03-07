package com.ecpbm.service.impl;

import com.ecpbm.dao.AdminInfoDao;
import com.ecpbm.pojo.AdminInfo;
import com.ecpbm.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PACKAGE_NAME: com.ecpbm.service.impl
 * @CLASS_NAME: AdminInfoServiceImpl
 * @USER: kagura
 * @Description TODO AdminInfoService接口实现类
 * @Date 2021/1/17 7:12 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
@Service("adminInfoService")
// 使用@Transactional注解将类中所有方法都进行注解处理
// Propagation.REQUIRED表示如果有事务就加入，无则新建事务
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoDao adminInfoDao;

    // 管理员登录验证
    @Override
    public AdminInfo login(AdminInfo ai) {
        return adminInfoDao.selectByNameAndPwd(ai);
    }

    // 根据管理员编号，获取管理员对象及关联的功能权限
    @Override
    public AdminInfo getAdminInfoAndFunctions(Integer id) {
        return adminInfoDao.selectId(id);
    }
}
