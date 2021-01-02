package com.ecpbm.dao;

import com.ecpbm.pojo.AdminInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @PACKAGE_NAME: com.ecpbm.dao
 * @CLASS_NAME: AdminInfoDao
 * @USER: kagura
 * @Description TODO 管理员信息接口
 * @Date 2021/1/2 4:35 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public interface AdminInfoDao {

    // 根据登录名和密码查询管理员
    @Select("select * from admin_info t where t.name = #{name} and pwd = #{pwd}")
    public AdminInfo selectByNameAndPwd(AdminInfo ai);

    // 根据管理员id获取管理员对象及关联的功能集合
    @Select("select * from admin_info t where t.id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "pwd", property = "pwd"),
            @Result(column = "id", property = "fs", many = @Many(select =
            "com.ecpbm.dao.FunctionDao.selectByAdminId", fetchType = FetchType.EAGER))
    })
    AdminInfo selectId(Integer id);
}
