package com.ecpbm.service;

import com.ecpbm.pojo.Type;

import java.util.List;

/**
 * @PACKAGE_NAME: com.ecpbm.service
 * @CLASS_NAME: TypeService
 * @USER: kagura
 * @Description TODO 商品类型信息业务逻辑接口
 * @Date 2021/1/17 7:10 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface TypeService {

    // 获取所有商品类型
    public List<Type> getAll();

    // 添加商品类型
    public int addType(Type type);

    // 更新商品类型
    public void updateType(Type type);
}
