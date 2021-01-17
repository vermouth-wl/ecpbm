package com.ecpbm.dao;

import com.ecpbm.dao.provider.ProductInfoDynaSqlProvider;
import com.ecpbm.pojo.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.dao
 * @CLASS_NAME: ProductInfoDao
 * @USER: kagura
 * @Description TODO 商品信息接口
 * @Date 2021/1/2 4:47 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public interface ProductInfoDao {

    // 分页获取商品
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "code", property = "code"),
            @Result(column = "name", property = "name"),
            @Result(column = "brand", property = "brand"),
            @Result(column = "pic", property = "pic"),
            @Result(column = "num", property = "num"),
            @Result(column = "price", property = "price"),
            @Result(column = "intro", property = "intro"),
            @Result(column = "status", property = "status"),
            @Result(column = "tid", property = "type", one = @One(select =
            "com.ecpbm.dao.TypeDao.selectById", fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = ProductInfoDynaSqlProvider.class, method = "selectWithParam")
    List<ProductInfo> selectByPage(Map<String, Object> params);

    // 根据条件查询商品总数
    @SelectProvider(type = ProductInfoDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    // 添加商品
    @Insert("insert into product_info(code, name, tid, brand, pic, num, price, intro, status)" +
    "values(#{code}, #{name}, #{type.id}, #{brand}, #{pic}, #{num}, #{price}, #{intro}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(ProductInfo pi);

    // 修改商品
    @Update("update product_info set code = #{code}, name = #{name}, tid = #{type.id}, brand = #{brand}"
    + "pic = #{pic}, num = #{num}, price = #{price}, intro = #{intro}, status = #{status} where id = #{id}")
    void edit(ProductInfo pi);

    // 更新商品状态
    @Update("update product_info set status = #{status} where id in (${ids})")
    void updateState(@Param("ids") String ids, @Param("flag") int flag);

    // 获取在售商品列表
    @Select("select * from product_info t where t.status = 1")
    List<ProductInfo> getOnSaleProduct();

    // 根据id获取商品对象
    @Select("select * from product_info t where t.id = #{id}")
    ProductInfo getProductInfoById(int id);
}
