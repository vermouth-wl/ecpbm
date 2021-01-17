package com.ecpbm.dao;

import com.ecpbm.pojo.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @PACKAGE_NAME: com.ecpbm.dao
 * @CLASS_NAME: TypeDao
 * @USER: kagura
 * @Description TODO
 * @Date 2021/1/17 2:43 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface TypeDao {

    // 查询所有商品类型
    @Select("select * from type")
    public List<Type> selectAll();

    // 根据商品类别编号查询类型
    @Select("select * from type t where t.id = #{id}")
    Type selectById(int id);

    // 添加商品类型
    @Insert("insert into type(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int add(Type type);

    // 更新商品类型
    @Update("update type set name = #{name} where id = #{id}")
    public int update(Type type);
}
