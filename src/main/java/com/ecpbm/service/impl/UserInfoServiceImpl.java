package com.ecpbm.service.impl;

import com.ecpbm.dao.UserInfoDao;
import com.ecpbm.pojo.Pager;
import com.ecpbm.pojo.UserInfo;
import com.ecpbm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.service.impl
 * @CLASS_NAME: UserInfoServiceImpl
 * @USER: kagura
 * @Description TODO UserInfoService接口实现类
 * @Date 2021/1/17 7:11 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
@Service("userInfoService")
// 使用@Transactional注解将类中所有方法都进行注解处理
// Propagation.REQUIRED表示如果有事务就加入，无则新建事务
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    // 获取合法客户
    @Override
    public List<UserInfo> getValidUser() {
        return userInfoDao.getValidUser();
    }

    // 根据客户编号查询客户
    @Override
    public UserInfo getUserInfoById(int id) {
        return userInfoDao.getUserInfoById(id);
    }

    // 分页显示用户
    @Override
    public List<UserInfo> findUserInfo(UserInfo userInfo, Pager pager) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userInfo", userInfo);
        int recordCount = userInfoDao.count(params);
        pager.setRowCount(recordCount);
        if (recordCount > 0) {
            params.put("pager", pager);
        }
        return userInfoDao.selectWithParam(params);
    }

    // 客户计数
    @Override
    public Integer count(Map<String, Object> params) {
        return userInfoDao.count(params);
    }

    // 修改指定编号的客户状态
    @Override
    public void modifyStatus(String ids, int flag) {
        userInfoDao.updateState(ids, flag);
    }
}
