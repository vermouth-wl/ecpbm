package com.ecpbm.service;

import com.ecpbm.pojo.Pager;
import com.ecpbm.pojo.ProductInfo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @PACKAGE_NAME: com.ecpbm.service
 * @CLASS_NAME: ProductInfoService
 * @USER: kagura
 * @Description TODO 商品信息业务逻辑接口
 * @Date 2021/1/17 7:10 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface ProductInfoService {

    // 分页显示商品
    List<ProductInfo> findProductInfo(ProductInfo productInfo, Pager pager);

    // 商品计数
    Integer count(Map<String, Object> params);

    // 添加商品
    public void addProductInfo(ProductInfo pi);

    // 修改商品
    public void modifyProductInfo(ProductInfo pi);

    // 更新商品状态
    void modifyStatus(String ids, int flag);

    // 获取在售商品列表
    List<ProductInfo> getOnSaleProduct();

    // 根据商品id获取商品对象
    ProductInfo getProductInfoById(int id);
}
