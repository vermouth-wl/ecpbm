package com.ecpbm.dao.provider;

import com.ecpbm.pojo.ProductInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.dao.provider
 * @CLASS_NAME: ProductInfoDynaSqlProvider
 * @USER: kagura
 * @Description TODO 商品信息动态SQL提供类
 * @Date 2021/1/2 4:57 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class ProductInfoDynaSqlProvider {

    // 分页动态查询,Map<String, Object>类型的参数params用于封装查询条件
    public String selectWithParam(final Map<String, Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM("product_info");
                if (params.get("productInfo") != null) {
                    ProductInfo productInfo = (ProductInfo) params.get("productInfo");
                    if (productInfo.getCode() != null && !"".equals(productInfo.getCode())) {
                        WHERE("code = #{productInfo.code}");
                    }
                    if (productInfo.getName() != null && !productInfo.getName().equals("")) {
                        WHERE("name like concat('%', #{productInfo.name}, '%')");
                    }
                    if (productInfo.getBrand() != null && !productInfo.getBrand().equals("")) {
                        WHERE("brand like concat('%', #{productInfo.brand}, '%')");
                    }
                    if (productInfo.getType() != null && productInfo.getType().getId() > 0) {
                        WHERE("tid = #{productInfo.type.id}");
                    }
                    if (productInfo.getPriceFrom() > 0) {
                        WHERE("price > #{productInfo.priceFrom}");
                    }
                    if (productInfo.getPriceTo() > 0) {
                        WHERE("price <= #{productInfo.priceTo}");
                    }
                }
            }
        }.toString();
        if (params.get("pager") != null) {
            sql += "limit #{pager.firstLimitParam}, #{pager.perPageRows}";
        }
        return sql;
    }

    // 根据条件动态查询商品总记录数
    public String count(final Map<String, Object> params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("product_info");
                if (params.get("productInfo") != null) {
                    ProductInfo productInfo = (ProductInfo) params.get("productInfo");
                    if (productInfo.getCode() != null && !"".equals(productInfo.getCode())) {
                        WHERE("code = #{productInfo.code}");
                    }
                    if (productInfo.getName() != null && !productInfo.getName().equals("")) {
                        WHERE("name like concat('%', #{productInfo.name}, '%')");
                    }
                    if (productInfo.getBrand() != null && !productInfo.getBrand().equals("")) {
                        WHERE("brand like concat('%', #{productInfo.brand}, '%')");
                    }
                    if (productInfo.getType() != null && productInfo.getType().getId() > 0){
                        WHERE("tid = #{productInfo.type.id}");
                    }
                    if (productInfo.getPriceFrom() > 0) {
                        WHERE("price > #{productInfo.priceFrom}");
                    }
                    if (productInfo.getPriceTo() > 0) {
                        WHERE("price <= #{productInfo.priceTo}");
                    }
                }
            }
        }.toString();
    }
}
