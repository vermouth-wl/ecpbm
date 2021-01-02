package com.ecpbm.pojo;

/**
 * @PACKAGE_NAME: com.ecpbm.pojo
 * @CLASS_NAME: Powers
 * @USER: kagura
 * @Description TODO 权限实体类，用于封装权限信息
 * @Date 2021/1/2 2:56 下午
 * @MONTH_NAME_FULL: 一月
 * @DAY: 02
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: ecpbm
 **/
public class Powers {
    private AdminInfo ai;
    private Functions f;

    // 重写toString()
    @Override
    public String toString() {
        return "Powers [ai=" + ai + ", f=" + f + "]";
    }
}
