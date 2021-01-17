package com.ecpbm.dao.provider;

import com.ecpbm.pojo.OrderInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @PACKAGE_NAME: com.ecpbm.dao.provider
 * @CLASS_NAME: OrderInfoDynaSqlProvider
 * @USER: kagura
 * @Description TODO
 * @Date 2021/1/17 3:03 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 17
 * @DAY_NAME_FULL: 星期日
 * @PROJECT_NAME: ecpbm
 **/
public class OrderInfoDynaSqlProvider {

    // 分页动态查询
    public String selectWithParam(final Map<String, Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM("order_info");
                if (params.get("orderInfo") != null) {
                    OrderInfo orderInfo = (OrderInfo) params.get("orderInfo");
                    if (orderInfo.getId() != null && orderInfo.getId() > 0) {
                        WHERE("id = #{orderInfo.id}");
                    } else {
                        if (orderInfo.getStatus() != null && !"请选择".equals(orderInfo.getStatus())) {
                            WHERE("status = #{orderInfo.status}");
                        }
                        if (orderInfo.getOrderTimeFrom() != null && !"".equals(orderInfo.getOrderTimeFrom())) {
                            WHERE("ordertime >= #{orderInfo.OrderTimeFrom}");
                        }
                        if (orderInfo.getOrderTimeTo() != null && !"".equals(orderInfo.getOrderTimeTo())) {
                            WHERE("ordertime < #{orderInfo.orderTimeTo}");
                        }
                        if (orderInfo.getUid() > 0) {
                            WHERE("uid = #{orderInfo.uid}");
                        }
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
                FROM("order_info");
                if (params.get("orderInfo") != null) {
                    OrderInfo orderInfo = (OrderInfo) params.get("orderInfo");
                    if (orderInfo.getId() != null && orderInfo.getId() > 0) {
                        WHERE("id = #{orderInfo.id}");
                    } else {
                        if (orderInfo.getStatus() != null && !"请选择".equals(orderInfo.getStatus())) {
                            WHERE("status = #{orderInfo.status}");
                        }
                        if (orderInfo.getOrderTimeFrom() != null && !"".equals(orderInfo.getOrderTimeFrom())) {
                            WHERE("ordertime >= #{orderInfo.orderTimeFrom}");
                        }
                        if (orderInfo.getOrderTimeTo() != null && !"".equals(orderInfo.getOrderTimeTo())) {
                            WHERE("ordertime < #{orderInfo.orderTimeTo}");
                        }
                        if (orderInfo.getUid() > 0) {
                            WHERE("uid = #{orderInfo.uid}");
                        }
                    }
                }
            }
        }.toString();
    }
}
