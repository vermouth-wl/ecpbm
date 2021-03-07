package com.ecpbm.service.impl;

import com.ecpbm.dao.ProductInfoDao;
import com.ecpbm.pojo.Pager;
import com.ecpbm.pojo.ProductInfo;
import com.ecpbm.service.ProductInfoService;
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
 * @CLASS_NAME: ProductInfoServiceImpl
 * @USER: kagura
 * @Description TODO ProductInfo接口实现类
 * @Date 2021/1/17 7:12 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
@Service("productInfoService")
// 使用@Transactional注解将类中所有方法都进行注解处理
// Propagation.REQUIRED表示如果有事务就加入，无则新建事务
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoDao productInfoDao;

    // 分页显示商品
    @Override
    public List<ProductInfo> findProductInfo(ProductInfo productInfo, Pager pager) {
        // 创建对象params
        Map<String, Object> params = new HashMap<String, Object>();
        // 将封装有查询条件的productInfo对象放入params
        params.put("productInfo", productInfo);
        // 根据条件计算商品总数
        int recordCount = productInfoDao.count(params);
        // 给paper对象设置rowCount属性值（记录总数）
        pager.setRowCount(recordCount);
        if (recordCount > 0) {
            // 将page对象放入params
            params.put("pager", pager);
        }
        // 分页获取商品信息
        return productInfoDao.selectByPage(params);
    }

    // 商品计数
    @Override
    public Integer count(Map<String, Object> params) {
        return productInfoDao.count(params);
    }

    // 添加商品
    @Override
    public void addProductInfo(ProductInfo pi) {
        productInfoDao.save(pi);
    }

    // 修改商品
    @Override
    public void modifyProductInfo(ProductInfo pi) {
        productInfoDao.edit(pi);
    }

    // 修改商品状态
    @Override
    public void modifyStatus(String ids, int flag) {
        productInfoDao.updateState(ids, flag);
    }

    // 获取在售商品列表
    @Override
    public List<ProductInfo> getOnSaleProduct() {
        return productInfoDao.getOnSaleProduct();
    }

    // 根据商品id获取商品对象
    @Override
    public ProductInfo getProductInfoById(int id) {
        return productInfoDao.getProductInfoById(id);
    }
}
