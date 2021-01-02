package com.ecpbm.pojo;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: OrderDetail
 * @USER: kagura
 * @Description TODO 订单明细实体类，用于封装订单明细信息
 * @Date 2021/1/2 3:14 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class OrderDetail {
    private Integer id;  // 订单明细id
    private Integer oid;  // 订单id
    private OrderInfo oi;
    private Integer pid;  // 商品id
    private ProductInfo pi;
    private Integer num;  // 购买数量
    private double price;  // 单价
    private double totalPrice;  // 总价

    // 生成对应的私有属性set和get方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public OrderInfo getOi() {
        return oi;
    }

    public void setOi(OrderInfo oi) {
        this.oi = oi;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public ProductInfo getPi() {
        return pi;
    }

    public void setPi(ProductInfo pi) {
        this.pi = pi;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
