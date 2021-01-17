package com.ecpbm.dao;

import com.ecpbm.dao.provider.OrderInfoDynaSqlProvider;
import com.ecpbm.pojo.OrderDetail;
import com.ecpbm.pojo.OrderInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.dao
 * @CLASS_NAME: OrderInfoDao
 * @USER: kagura
 * @Description TODO
 * @Date 2021/1/17 2:57 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface OrderInfoDao {

    // 分页获取订单信息
    @Results({
            @Result(column = "uid", property = "ui", one = @One(select =
            "com.ecpbm.dao.UserInfoDao.getUserInfoById", fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = OrderInfoDynaSqlProvider.class, method = "selectWithParam")
    List<OrderInfo> selectByPage(Map<String, Object> params);

    // 根据条件查询订单总数
    @SelectProvider(type = OrderInfoDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    // 保存订单主表信息
    @Insert("insert into order_info(uid, status, ordertime, orderprice)" +
    "values(#{uid}, #{status}, #{ordertime}, #{orderprice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveOrderInfo(OrderInfo oi);

    // 保存订单明细
    @Insert("insert into order_detail(oid, pid, nul) values(#{oid}, #{pid}, #{num})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveOrderDetail(OrderDetail od);

    // 根据订单编号查询订单对象
    @Results({
            @Result(column = "uid", property = "ui", one = @One(select =
            "com.ecpbm.dao.UserInfoDao.getUserInfoById", fetchType = FetchType.EAGER))
    })
    @Select("select * from order_info t where t.id = #{id}")
    public OrderInfo getOrderInfoById(int id);

    // 根据订单编号获取订单明细
    @Results({
            @Result(column = "pid", property = "pi", one = @One(select =
            "com.ecpbm.dao.ProductInfoDao.getProductInfoById", fetchType = FetchType.EAGER))
    })
    @Select("select * from order_detail t where t.oid = #{oid}")
    public List<OrderDetail> getOrderDetailByOid(int oid);

    // 根据订单编号删除订单主表记录
    @Delete("delete from order_info t where t.id = #{id}")
    public int deleteOrderInfo(int id);

    // 根据订单编号删除订单明细记录
    @Delete("delete from order_detail t where t.oid = #{id}")
    public int deleteOrderDetail(int id);
}
