package com.ecpbm.controller;

import com.ecpbm.pojo.AdminInfo;
import com.ecpbm.pojo.Functions;
import com.ecpbm.pojo.TreeNode;
import com.ecpbm.service.AdminInfoService;
import com.ecpbm.util.JsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    @RequestMapping("getTree")
    @ResponseBody
    public List<TreeNode> getTree(@RequestParam(value = "adminid") String adminid) {
        // 根据管理员对象，获取AdminInfo对象
        AdminInfo adminInfo = adminInfoService.getAdminInfoAndFunctions(Integer.parseInt(adminid));
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        // 获取关联的Functions对象
        List<Functions> functionsList = adminInfo.getFs();
        // 对List<Functions>类型的Functions对象进行排序
        Collections.sort(functionsList);
        // 将排序后的Functions集合对象转换到List<TreeNode>类型的列表nodes
        for (Functions functions : functionsList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(functions.getId());
            treeNode.setFid(functions.getParentId());
            treeNode.setText(functions.getName());
            nodes.add(treeNode);
        }
        // 调用自定义工具类中JsonFactory的buildTree()方法为nodes列表中的各个TreeNode元素中的children属性赋值（该节点包含的子节点）
        List<TreeNode> treeNodes = JsonFactory.buildTree(nodes, 0);
        return treeNodes;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(SessionStatus status) {
        // @SessionAttribute清除
        status.setComplete();
        return "{\"success\": \"true\", \"message\": \"注销成功\"}";
    }
}
