package com.ecpbm.pojo;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: SearchProductInfo
 * @USER: kagura
 * @Description TODO 查询条件实体类，用于封装商品查询条件
 * @Date 2021/1/2 3:29 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class SearchProductInfo {
    private Integer id;  // 产品编号
    private String code;  // 产品编码
    private String name;  // 产品名称
    private String brand;  // 产品品牌
    private double priceFrom;
    private double priceTo;
    private Integer tid;

    // 生成私有属性对应的set和get方法
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
