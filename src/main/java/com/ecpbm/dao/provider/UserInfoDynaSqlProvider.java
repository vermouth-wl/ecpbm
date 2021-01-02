package com.ecpbm.dao.provider;

import com.ecpbm.pojo.UserInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.dao.provider
 * @CLASS_NAME: UserInfoDynaSqlProvider
 * @USER: kagura
 * @Description TODO 用户信息动态SQL提供类
 * @Date 2021/1/2 3:57 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class UserInfoDynaSqlProvider {

    // 分页动态查询，Map<String, Object>类型的参数params用于封装查询条件
    public String selectWithParam(final Map<String, Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM("user_info");
                if (params.get("userInfo") != null) {
                    UserInfo userInfo = (UserInfo) params.get("userInfo");
                    if (userInfo.getUserName() != null && !userInfo.getUserName().equals("")) {
                        WHERE("userName like concat('%', #{userInfo.userName}), '%'");
                    }
                }
            }
        }.toString();
        if (params.get("pager") != null) {
            sql += "limit #{pager.firstLimitParam}, #{pager.perPageRows}";
        }
        return sql;
    }

    // 根据条件动态查询总记录数
    public String count(final Map<String, Object> params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM("user_info");
                if (params.get("userInfo") != null) {
                    UserInfo userInfo = (UserInfo) params.get("userInfo");
                    if (userInfo.getUserName() != null && !userInfo.getUserName().equals("")) {
                        WHERE("userName like concat('%', #{userInfo,userName}, '%')");
                    }
                }
            }
        }.toString();
    }
}
