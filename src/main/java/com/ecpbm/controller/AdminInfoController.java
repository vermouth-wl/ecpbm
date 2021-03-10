package com.ecpbm.controller;

import com.ecpbm.pojo.AdminInfo;
import com.ecpbm.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @PACKAGE_NAME: com.ecpbm.controller
 * @CLASS_NAME: AdminInfoController
 * @USER: kagura
 * @Description TODO 管理员Controller层
 * @Date 2021/3/10 8:54 下午
 * @MONTH_NAME_FULL: 三月
 * @DAY: 10
 * @DAY_NAME_FULL: 星期三
 * @PROJECT_NAME: ecpbm
 **/
@SessionAttributes(value = {"admin"})
@Controller
@RequestMapping("/admininfo")
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;
    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(AdminInfo ai, ModelMap model) {
        // 后台登录验证
        AdminInfo adminInfo = adminInfoService.login(ai);
        if (adminInfo != null && adminInfo.getName() != null) {
            // 验证通过后，再判断是否已为该管理员分配功能权限
            if (adminInfoService.getAdminInfoAndFunctions(adminInfo.getId()).getFs().size() > 0) {
                // 验证通过且已分配功能权限，则将admininfo 对象存入model中
                model.put("admin", adminInfo);
                // 以json格式向页面发送成功信息
                return "{\"success\": \"true\", \"message\": \"登录成功\"}";
            } else {
                return "{\"success\": \"false\", \"message\": \"您没有权限，请联系超级管理员设置权限！\"}";
            }
        } else {
            return "{\"success\": \"false\", \"message\": \"登录失败\"}";
        }
    }
}
