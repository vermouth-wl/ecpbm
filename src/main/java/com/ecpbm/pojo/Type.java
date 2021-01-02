package com.ecpbm.pojo;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: Type
 * @USER: kagura
 * @Description TODO 商品类型实体类，用于封装商品类型信息
 * @Date 2021/1/2 3:06 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class Type {
    private Integer id;  // 产品类型编号
    private String name;  // 产品类型名称

    // 生成对应私有属性的set和get方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
