package com.ecpbm.service.impl;

import com.ecpbm.dao.OrderInfoDao;
import com.ecpbm.pojo.OrderDetail;
import com.ecpbm.pojo.OrderInfo;
import com.ecpbm.pojo.Pager;
import com.ecpbm.service.OrderInfoService;
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
 * @CLASS_NAME: OrderInfoServiceImpl
 * @USER: kagura
 * @Description TODO OrderInfoService接口实现类
 * @Date 2021/1/17 7:12 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
@Service("orderInfoService")
// 使用@Transactional注解将类中所有方法都进行注解处理
// Propagation.REQUIRED表示如果有事务就加入，无则新建事务
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    OrderInfoDao orderInfoDao;

    // 分页显示订单
    @Override
    public List<OrderInfo> findOrderInfo(OrderInfo orderInfo, Pager pager) {
        // 创建对象params
        Map<String, Object> params = new HashMap<String, Object>();
        // 将封装有查询对象的orderInfo封装进params
        params.put("orderInfo", orderInfo);
        // 根据条件计算商品总数
        int recordCount = orderInfoDao.count(params);
        // 给pager对象设置rowCount属性（记录总数）
        pager.setRowCount(recordCount);
        if (recordCount > 0) {
            params.put("pager", pager);
        }
        return orderInfoDao.selectByPage(params);
    }

    // 订单计数
    @Override
    public Integer count(Map<String, Object> params) {
        return orderInfoDao.count(params);
    }

    // 添加订单
    @Override
    public int addOrderInfo(OrderInfo oi) {
        return orderInfoDao.saveOrderInfo(oi);
    }

    // 添加订单明细
    @Override
    public int addOrderDetail(OrderDetail od) {
        return orderInfoDao.saveOrderDetail(od);
    }

    // 根据订单id获取订单对象
    @Override
    public OrderInfo getOrderInfoById(int id) {
        return orderInfoDao.getOrderInfoById(id);
    }

    // 根据订单id获取订单明细列表
    @Override
    public List<OrderDetail> getOrderDetailByOid(int oid) {
        return orderInfoDao.getOrderDetailByOid(oid);
    }

    // 删除订单
    @Override
    public int deleteOrder(int id) {
        int result = 1;
        try {
            orderInfoDao.deleteOrderDetail(id);
            orderInfoDao.deleteOrderInfo(id);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
}
