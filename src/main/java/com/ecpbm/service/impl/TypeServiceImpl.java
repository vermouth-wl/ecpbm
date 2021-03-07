package com.ecpbm.service.impl;

import com.ecpbm.dao.TypeDao;
import com.ecpbm.pojo.Type;
import com.ecpbm.service.ProductInfoService;
import com.ecpbm.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @PACKAGE_NAME: com.ecpbm.service.impl
 * @CLASS_NAME: TypeServiceImpl
 * @USER: kagura
 * @Description TODO TypeService接口实现类
 * @Date 2021/1/17 7:12 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
@Service("typeService")
// 使用@Transactional注解将类中所有方法都进行注解处理
// Propagation.REQUIRED表示如果有事务就加入，无则新建事务
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    // 获取所有商品类型
    @Override
    public List<Type> getAll() {
        return typeDao.selectAll();
    }

    // 添加商品类型
    @Override
    public int addType(Type type) {
        return typeDao.add(type);
    }

    // 修改商品类型
    @Override
    public void updateType(Type type) {
        typeDao.update(type);
    }
}
