package com.ecpbm.service;

import com.ecpbm.pojo.OrderDetail;
import com.ecpbm.pojo.OrderInfo;
import com.ecpbm.pojo.Pager;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.service
 * @CLASS_NAME: OrderInfoService
 * @USER: kagura
 * @Description TODO 订单信息业务逻辑接口
 * @Date 2021/1/17 7:11 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface OrderInfoService {

    // 分页显示订单
    List<OrderInfo> findOrderInfo(OrderInfo orderInfo, Pager pager);

    // 订单计数
    Integer count(Map<String, Object> params);

    // 添加订单主表
    public int addOrderInfo(OrderInfo oi);

    // 添加订单明细
    public int addOrderDetail(OrderDetail od);

    // 根据订单编号获取订单信息
    public OrderInfo getOrderInfoById(int id);

    // 根据订单编号获取订单明细信息
    public List<OrderDetail> getOrderDetailByOid(int oid);

    // 删除订单
    public int deleteOrder(int id);
}
