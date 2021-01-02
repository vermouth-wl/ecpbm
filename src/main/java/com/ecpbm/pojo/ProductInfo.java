package com.ecpbm.pojo;

import java.lang.reflect.Type;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: ProductInfo
 * @USER: kagura
 * @Description TODO 商品信息实体类，用于封装商品信息
 * @Date 2021/1/2 3:00 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class ProductInfo {
    private Integer id;
    private String code;  // 商品编号
    private String name;  // 商品名称
    private Type type;  // 关联属性，商品类型
    private String brand;  // 商品品牌
    private String pic;  // 商品小图
    private Integer num;  // 商品数量
    private double price;  // 商品价格
    private String intro;  // 商品介绍
    private Integer status;  // 商品状态
    private double priceFrom;
    private double priceTo;

    // 生成私有属性对应的set和get
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }
}
