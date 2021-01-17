package com.ecpbm.dao;

import com.ecpbm.pojo.Functions;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PACKAGE_NAME: com.ecpbm.dao
 * @CLASS_NAME: FunctionDao
 * @USER: kagura
 * @Description TODO
 * @Date 2021/1/17 6:52 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public interface FunctionDao {

    // 根据管理员id获取功能权限
    @Select("select * from functions t where t.id in (select a.fid from powers a where a.aid = #{aid})")
    public List<Functions> selectByAdminId(Integer aid);
}
