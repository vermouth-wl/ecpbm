package com.ecpbm.pojo;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: OrderInfo
 * @USER: kagura
 * @Description TODO 订单实体类，用于封装订单信息
 * @Date 2021/1/2 3:09 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class OrderInfo {
    private Integer id;  // 订单id标识
    private Integer uid;  // 客户id标识
    private UserInfo ui;
    private String status;  // 订单状态
    private String orderTime;  // 订单下单时间
    private double orderPrice;  // 订单价格
    private String orderTimeFrom;
    private String orderTimeTo;

    // 生成私有属性对应set和get
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public UserInfo getUi() {
        return ui;
    }

    public void setUi(UserInfo ui) {
        this.ui = ui;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderTimeFrom() {
        return orderTimeFrom;
    }

    public void setOrderTimeFrom(String orderTimeFrom) {
        this.orderTimeFrom = orderTimeFrom;
    }

    public String getOrderTimeTo() {
        return orderTimeTo;
    }

    public void setOrderTimeTo(String orderTimeTo) {
        this.orderTimeTo = orderTimeTo;
    }
}
