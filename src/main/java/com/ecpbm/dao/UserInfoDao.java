package com.ecpbm.dao;

import com.ecpbm.dao.provider.UserInfoDynaSqlProvider;
import com.ecpbm.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.dao
 * @CLASS_NAME: UserInfoDao
 * @USER: kagura
 * @Description TODO 用户信息接口
 * @Date 2021/1/2 3:49 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public interface UserInfoDao {

    // 获取系统合法用户，即数据表user_info中status字段为1的客户列表
    @Select("select * from user_info t where t.status = 1")
    public List<UserInfo> getValidUser();

    // 根据客户id号获取客户对象
    @Select("select * from user_info t where t where t.id = #{id}")
    public UserInfo getUserInfoById(Integer id);

    // 分页获取客户信息
    @SelectProvider(type = UserInfoDynaSqlProvider.class, method = "selectWithParam")
    public List<UserInfo> selectWithParam(Map<String, Object> params);

    // 根据条件查询客户总数
    @SelectProvider(type = UserInfoDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    // 更新客户状态
    @Update("update user_info set status = #{flag} where id in (${ids})")
    void updateState(@Param("ids") String ids, @Param("flag") Integer flag);
}
